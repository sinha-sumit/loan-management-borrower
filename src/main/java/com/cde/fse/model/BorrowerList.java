package com.cde.fse.model;

import java.util.List;

public class BorrowerList {
	
	private String borrower_Id;
    private List<BorrowerDetails> borrowers;
    
	public String getBorrower_Id() {
		return borrower_Id;
	}
	public void setBorrower_Id(String borrower_Id) {
		this.borrower_Id = borrower_Id;
	}
	public List<BorrowerDetails> getBorrowers() {
		return borrowers;
	}
	public void setBorrowers(List<BorrowerDetails> borrowers) {
		this.borrowers = borrowers;
	}
    
}
