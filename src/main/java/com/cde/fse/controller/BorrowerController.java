package com.cde.fse.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cde.fse.exception.LoginCustomException;
import com.cde.fse.model.Borrower;
import com.cde.fse.service.BorrowerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class BorrowerController {

	private static final Logger log = LoggerFactory.getLogger(BorrowerController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private BorrowerService borrowerService;

	@GetMapping("/search")
	public ResponseEntity<Borrower> searchBorrowers(@Param("keyword") String keyword) throws Exception {
		log.info("::::::::::::::::: Inside searchBorrowers method of Controller :::::::::::::::::::");
		return new ResponseEntity(borrowerService.listAll(keyword), HttpStatus.OK);
	}

	@GetMapping("/borrower")
	public List<Borrower> getAllBorrowers() {
		log.info("::::::::::::::::: Inside getAllBorrowers method of Controller :::::::::::::::::::");
		return borrowerService.getAllBorrowers();
	}

	@GetMapping("/borrower/{borrower_id}")
	public Borrower getBorrowersById(@PathVariable("borrower_id") int borrower_id) {
		log.info("::::::::::::::::: Inside getBorrowersById method of Controller :::::::::::::::::::");
		return borrowerService.getBorrowerById(borrower_id);
	}

	@PostMapping("/save")
	public Borrower saveBorrower(@RequestBody Borrower borrowers) throws Exception {
		log.info("::::::::::::::::: Inside saveOrUpdate method of Controller :::::::::::::::::::");
		Borrower borrower = borrowerService.saveOrUpdate(borrowers);

		if (borrower == null)
			throw new LoginCustomException(new Date(), "Data not saved", "Something is wrong");

		return borrower;
	}

	// creating put mapping that updates the borrower detail
	@PutMapping("/update/{id}")
	public ResponseEntity<Borrower> update(@PathVariable Integer id, @RequestBody Borrower borrower) throws Exception {
		log.info("::::::::::::::::: Inside saveOrUpdate method of Controller :::::::::::::::::::");
		return new ResponseEntity(borrowerService.update(id, borrower), HttpStatus.OK);
	}
	
	@HystrixCommand(fallbackMethod = "callLoanManagementBorrowerApi_Fallback")
    public String callLoanManagementBorrowerApi(String borrowername) {
 
		log.info("Getting Login details for " + borrowername);
 
        String response = restTemplate
                .exchange("http://localhost:8092/borrower"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
            }, borrowername).getBody();
 
        log.info("Response Received as " + response + " -  " + new Date());
 
        return "NORMAL FLOW !!! - Borrower Name -  " + borrowername + " :::  " +
                    " Login Details " + response + " -  " + new Date();
    }
}
