package com.finzly.loan.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finzly.loan.Entity.LoanDetailsEntity;
import com.finzly.loan.Entity.LoanDetailsFromFrontendEntity;
import com.finzly.loan.Entity.PaymentScheduleEntity;
import com.finzly.loan.ExceptionHandleR.IdNotFoundException;
import com.finzly.loan.Repocitory.LoanDetailsRepo;
import com.finzly.loan.Repocitory.PaymentScheduleRepo;

@Service
public class ModifiedFrontendDataService {

	@Autowired
	LoanDetailsRepo loanDetailsRepo;

	@Autowired
	PaymentScheduleRepo paymentScheduleRepo;

	public String newLoan(LoanDetailsFromFrontendEntity loanDetailsFromFrontend) {

		// to create loan for a customer

		LoanDetailsEntity loanDetails = new LoanDetailsEntity();
		loanDetails.setLoanAmount(loanDetailsFromFrontend.getLoanAmount());
		loanDetails.setTradeDate(LocalDate.now());
		loanDetails.setLoanStartDate(loanDetails.getTradeDate().plusDays(loanDetailsFromFrontend.getLoanStartDate()));
		loanDetails.setMaturityDate(
				loanDetails.getLoanStartDate().plusMonths(loanDetailsFromFrontend.getMaturityMonths()));
		loanDetails.setPaymentFrequency(loanDetailsFromFrontend.getPaymentFrequency());
		loanDetails.setInterestRate(loanDetailsFromFrontend.getInterestRate());
		loanDetails.setPaymentTerm(loanDetailsFromFrontend.getPaymentTerm());

		// to generate paymentSchedule for a customer

		LocalDate loanStartDate = loanDetails.getLoanStartDate();
		PaymentScheduleEntity paymentScheduleEntity = null;
		List<PaymentScheduleEntity> scheduleList = loanDetails.getPaymentScheduleEntity();

		double principalAmount = loanDetailsFromFrontend.getLoanAmount();

		double payableInterestAmountAtPaymentFreq = 0;

		double totalInterestAmountForInterestOnlyPerMth = ((principalAmount * loanDetailsFromFrontend.getInterestRate())
				/ 100) * (loanDetailsFromFrontend.getMaturityMonths() / 12);

		payableInterestAmountAtPaymentFreq = totalInterestAmountForInterestOnlyPerMth
				/ ((12 / loanDetailsFromFrontend.getPaymentFrequency())
						* (loanDetailsFromFrontend.getMaturityMonths() / 12));

		double loanAmountPerFrequency = principalAmount
				/ (loanDetailsFromFrontend.getMaturityMonths() / loanDetailsFromFrontend.getPaymentFrequency());

		while (loanDetails.getMaturityDate().compareTo(loanStartDate) > 0) {

			if (loanDetailsFromFrontend.getPaymentTerm().equals("Interest Only")) {
				loanStartDate = loanStartDate.plusMonths(loanDetailsFromFrontend.getPaymentFrequency());
				if (loanDetails.getMaturityDate().compareTo(loanStartDate) == 0)

					payableInterestAmountAtPaymentFreq = principalAmount + payableInterestAmountAtPaymentFreq;

				paymentScheduleEntity = new PaymentScheduleEntity(0, loanStartDate, principalAmount,
						totalInterestAmountForInterestOnlyPerMth, payableInterestAmountAtPaymentFreq, "PROJECTED");
				scheduleList.add(paymentScheduleEntity);
			}

			else if (loanDetailsFromFrontend.getPaymentTerm().equals("Even Principal")) {
				loanStartDate = loanStartDate.plusMonths(loanDetailsFromFrontend.getPaymentFrequency());

				payableInterestAmountAtPaymentFreq = loanAmountPerFrequency + totalInterestAmountForInterestOnlyPerMth;

				paymentScheduleEntity = new PaymentScheduleEntity(0, loanStartDate, principalAmount,
						totalInterestAmountForInterestOnlyPerMth, payableInterestAmountAtPaymentFreq, "PROJECTED");

				scheduleList.add(paymentScheduleEntity);
				principalAmount = principalAmount - loanAmountPerFrequency;
				totalInterestAmountForInterestOnlyPerMth = (principalAmount * loanDetailsFromFrontend.getInterestRate()
						/ 100) * (loanDetailsFromFrontend.getMaturityMonths() / 12);
			}
		}
		loanDetails.setPaymentScheduleEntity(scheduleList);
		loanDetailsRepo.save(loanDetails);
		return "Loan has been created Sucessfully!";
	}

	public Optional<LoanDetailsEntity> getLoansById(int customerId) {
		LocalDate date = LocalDate.now();
		Optional<LoanDetailsEntity> loanList = loanDetailsRepo.findById(customerId);
		LoanDetailsEntity loanDetailsEntity = loanList.get();
		List<PaymentScheduleEntity> paymentScheduleEntity = loanDetailsEntity.getPaymentScheduleEntity();
		for (PaymentScheduleEntity paymentSchedule : paymentScheduleEntity) {
			if (paymentSchedule.getPaymentDate().equals(date)
					&& paymentSchedule.getPaymentStatus().equals("PROJECTED")) {
				paymentSchedule.setPaymentStatus("AWAITINGPAYMENT");
			}

		}
		loanDetailsRepo.save(loanDetailsEntity);
		return loanDetailsRepo.findById(customerId);

	}

	public String getById(int id) {
		PaymentScheduleEntity paymentSchedule = paymentScheduleRepo.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Data Not found with Id : " + id));
		paymentSchedule.setPaymentStatus("PAID");
		paymentScheduleRepo.save(paymentSchedule);
		return "Paid";
	}

}
