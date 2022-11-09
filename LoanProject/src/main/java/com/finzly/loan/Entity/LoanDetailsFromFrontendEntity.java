package com.finzly.loan.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoanDetailsFromFrontendEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private double loanAmount;
	private int loanStartDate;
	private int maturityMonths;
	private String paymentTerm;
	private int paymentFrequency;
	private double interestRate;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(int loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public int getMaturityMonths() {
		return maturityMonths;
	}

	public void setMaturityMonths(int maturityMonths) {
		this.maturityMonths = maturityMonths;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public int getPaymentFrequency() {
		return paymentFrequency;
	}

	public void setPaymentFrequency(int paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public LoanDetailsFromFrontendEntity(int customerId, double loanAmount, int loanStartDate, int maturityMonths,
			String paymentTerm, int paymentFrequency, double interestRate) {
		super();
		this.customerId = customerId;
		this.loanAmount = loanAmount;
		this.loanStartDate = loanStartDate;
		this.maturityMonths = maturityMonths;
		this.paymentTerm = paymentTerm;
		this.paymentFrequency = paymentFrequency;
		this.interestRate = interestRate;
	}

	public LoanDetailsFromFrontendEntity() {
		super();
	}

	@Override
	public String toString() {
		return "LoanDetailsFromFrontendEntity [customerId=" + customerId + ", loanAmount=" + loanAmount
				+ ", loanStartDate=" + loanStartDate + ", maturityMonths=" + maturityMonths + ", paymentTerm="
				+ paymentTerm + ", paymentFrequency=" + paymentFrequency + ", interestRate=" + interestRate + "]";
	}

}