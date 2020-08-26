package com.cde.fse.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cde.fse.model.Borrower;
import com.cde.fse.model.BorrowerDetails;

public class MockData {
	
	public List<Borrower> getBorrowerDetails(){
		
		Borrower borrowerDetails = new Borrower();

		List<Borrower> list = new ArrayList<Borrower>();

		borrowerDetails.setBorrower_id(101);
		borrowerDetails.setBorrower_name("Sumit");
		borrowerDetails.setProperty_address1("Address 1");
		borrowerDetails.setProperty_address2("Address 2");
		borrowerDetails.setProperty_city("Bangalore");
		borrowerDetails.setProperty_zipcode(6011);
		borrowerDetails.setLoan_amount(44567);
		borrowerDetails.setLoan_term(5);
		borrowerDetails.setLoan_id(123);
		borrowerDetails.setLoan_type("Personal Loan");
		borrowerDetails.setLegal_documents("Sample Legal Documents");
		
		list.add(borrowerDetails);

        return list;
    }
	
	public ResponseEntity<Borrower> getData(){

		Borrower borrowerDetails = new Borrower();

		borrowerDetails.setBorrower_id(101);
		borrowerDetails.setBorrower_id(102);
		borrowerDetails.setBorrower_name("Sumit");
		borrowerDetails.setLoan_amount(5000);

        return ResponseEntity.ok(borrowerDetails);
    }
	
	public Borrower borrowerData() {
		
		Borrower borrowerDetails = new Borrower();
		
		borrowerDetails.setBorrower_id(101);
		borrowerDetails.setBorrower_name("Sumit");
		borrowerDetails.setProperty_address1("Address 1");
		borrowerDetails.setProperty_address2("Address 2");
		borrowerDetails.setProperty_city("Bangalore");
		borrowerDetails.setProperty_zipcode(6011);
		borrowerDetails.setLoan_amount(44567);
		borrowerDetails.setLoan_term(5);
		borrowerDetails.setLoan_id(123);
		borrowerDetails.setLoan_type("Personal Loan");
		borrowerDetails.setLegal_documents("Sample Legal Documents");
		
		return borrowerDetails;
		
	}
}
