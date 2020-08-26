package com.cde.fse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cde.fse.model.Borrower;

public interface BorrowerRepository extends CrudRepository<Borrower, Integer> {

	@Query(value="SELECT * FROM Borrower b WHERE b.borrower_name LIKE %?1%"
            + " OR b.loan_id LIKE %?1%"
            + " OR b.loan_amount LIKE %?1%", nativeQuery=true)
    public List<Borrower> search(String keyword);
}
