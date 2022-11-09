package com.finzly.loan.Repocitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.finzly.loan.Entity.LoanDetailsEntity;

@Repository
public interface LoanDetailsRepo extends JpaRepository<LoanDetailsEntity, Integer> {

}
