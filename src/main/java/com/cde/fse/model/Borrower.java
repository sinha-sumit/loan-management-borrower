package com.cde.fse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "borrower")
@Getter
@Setter
public class Borrower {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrower_id;
	
	private String borrower_name;
	private String property_address1;
	private String property_address2;
	private String property_city;
	private int property_zipcode;
	
	private int loan_amount;
	private int loan_term;
	private int loan_id;
	private String loan_type;
	
	private String legal_documents;
	
	public Borrower() {
		
	}

	public Borrower(int borrower_id, String borrower_name, String property_address1, String property_address2,
			String property_city, int property_zipcode, int loan_amount, int loan_term, int loan_id, String loan_type,
			String legal_documents) {
		this.borrower_id = borrower_id;
		this.borrower_name = borrower_name;
		this.property_address1 = property_address1;
		this.property_address2 = property_address2;
		this.property_city = property_city;
		this.property_zipcode = property_zipcode;
		this.loan_amount = loan_amount;
		this.loan_term = loan_term;
		this.loan_id = loan_id;
		this.loan_type = loan_type;
		this.legal_documents = legal_documents;
	}

	public int getBorrower_id() {
		return borrower_id;
	}

	public void setBorrower_id(int borrower_id) {
		this.borrower_id = borrower_id;
	}

	public String getBorrower_name() {
		return borrower_name;
	}

	public void setBorrower_name(String borrower_name) {
		this.borrower_name = borrower_name;
	}

	public String getProperty_address1() {
		return property_address1;
	}

	public void setProperty_address1(String property_address1) {
		this.property_address1 = property_address1;
	}

	public String getProperty_address2() {
		return property_address2;
	}

	public void setProperty_address2(String property_address2) {
		this.property_address2 = property_address2;
	}

	public String getProperty_city() {
		return property_city;
	}

	public void setProperty_city(String property_city) {
		this.property_city = property_city;
	}

	public int getProperty_zipcode() {
		return property_zipcode;
	}

	public void setProperty_zipcode(int property_zipcode) {
		this.property_zipcode = property_zipcode;
	}

	public int getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(int loan_amount) {
		this.loan_amount = loan_amount;
	}

	public int getLoan_term() {
		return loan_term;
	}

	public void setLoan_term(int loan_term) {
		this.loan_term = loan_term;
	}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	public String getLegal_documents() {
		return legal_documents;
	}

	public void setLegal_documents(String legal_documents) {
		this.legal_documents = legal_documents;
	}
	
}
