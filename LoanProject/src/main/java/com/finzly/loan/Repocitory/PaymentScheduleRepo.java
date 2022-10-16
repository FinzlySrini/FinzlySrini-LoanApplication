package com.finzly.loan.Repocitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.finzly.loan.Entity.PaymentScheduleEntity;

@Repository
public interface PaymentScheduleRepo extends JpaRepository<PaymentScheduleEntity, Integer> {

}
