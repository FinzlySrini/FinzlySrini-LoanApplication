package com.finzly.loan.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.loan.Entity.LoanDetailsEntity;
import com.finzly.loan.Entity.LoanDetailsFromFrontendEntity;
import com.finzly.loan.Entity.PaymentScheduleEntity;
import com.finzly.loan.Repocitory.LoanDetailsRepo;
import com.finzly.loan.Repocitory.PaymentScheduleRepo;
import com.finzly.loan.Service.ModifiedFrontendDataService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoanApplicationController {

	@Autowired
	ModifiedFrontendDataService modifiedFrontendDataService;

	@Autowired
	LoanDetailsRepo loanDetailsRepo;

	@Autowired
	PaymentScheduleRepo paymentScheduleRepo;

	@PostMapping("/CreateNewLoan")
	public String Newloan(@RequestBody LoanDetailsFromFrontendEntity loanDetailsFromFrontend) {
		modifiedFrontendDataService.newLoan(loanDetailsFromFrontend);
		return "Loan is Created sucessfully!";
	}

	@GetMapping("/DisplayLoans")
	public List<LoanDetailsEntity> displayLoans() {
		return loanDetailsRepo.findAll();

	}

	@GetMapping("/DisplayPaymentSchedule")
	public List<PaymentScheduleEntity> displayPaymentSchedule() {
		return paymentScheduleRepo.findAll();
	}
	
	@GetMapping("/LoansById/{customerId}")
	public Optional<LoanDetailsEntity> getLoansById(@PathVariable int customerId){
		
		return this.modifiedFrontendDataService.getLoansById(customerId);
	}
	
	@PutMapping("/PaidStatus/{id}")
	public String paidStatus(@PathVariable int id) {
		return modifiedFrontendDataService.getById(id);
	}
}


