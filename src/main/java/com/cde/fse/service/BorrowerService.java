package com.cde.fse.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cde.fse.exception.LoginCustomException;
import com.cde.fse.model.Borrower;
import com.cde.fse.repository.BorrowerRepository;

@Service
public class BorrowerService {
	
	private static final Logger log = LoggerFactory.getLogger(BorrowerService.class);
	
	@Autowired
	private BorrowerRepository repository;
	
	public Optional<Borrower> listAll(String keyword) {

		Optional<Borrower> borrower = repository.search(keyword);
		if(!borrower.isPresent()) {
			throw new LoginCustomException(new Date(), "Search Not Found", "Please try with other keyword");
		}
        return borrower;
    }
	
	public List<Borrower> getAllBorrowers() {
		log.info("::::::::::::::::: Inside getAllBorrowers method of Service :::::::::::::::::::");
		List<Borrower> borrowers = new ArrayList<Borrower>();
		repository.findAll().forEach(borrowers1 -> borrowers.add(borrowers1));
		return borrowers;
	}
	
	public Borrower getBorrowerById(int id) {
		log.info("::::::::::::::::: Inside getBorrowerById method of Service :::::::::::::::::::");
		return repository.findById(id).get();
	}

	public Borrower saveOrUpdate(Borrower borrower) {
		log.info("::::::::::::::::: Inside saveOrUpdate method of Service :::::::::::::::::::");
		return repository.save(borrower);
	}

	public Borrower update(int borrower_id, Borrower borrower) {
		log.info("::::::::::::::::: Inside update method of Service :::::::::::::::::::");
		if(repository.findById(borrower_id).isPresent()) {
			borrower.setBorrower_id(borrower_id);
			 return repository.save(borrower);
		} else {
			throw new LoginCustomException(new Date(), "Update record failed", "Please try again");
		}
	}

}
