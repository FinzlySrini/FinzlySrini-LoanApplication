package com.finzly.loan.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class LoanDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private double loanAmount;
	private LocalDate tradeDate;
	private LocalDate loanStartDate;
	private LocalDate maturityDate;
	private String paymentTerm;
	private int paymentFrequency;
	private double interestRate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentForeignKey", referencedColumnName = "customerId")
	private List<PaymentScheduleEntity> paymentScheduleEntity = new ArrayList<>();

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

	public LocalDate getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}

	public LocalDate getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(LocalDate loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
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

	public List<PaymentScheduleEntity> getPaymentScheduleEntity() {
		return paymentScheduleEntity;
	}

	public void setPaymentScheduleEntity(List<PaymentScheduleEntity> paymentScheduleEntity) {
		this.paymentScheduleEntity = paymentScheduleEntity;
	}

	public LoanDetailsEntity(int customerId, double loanAmount, LocalDate tradeDate, LocalDate loanStartDate,
			LocalDate maturityDate, String paymentTerm, int paymentFrequency, double interestRate,
			List<PaymentScheduleEntity> paymentScheduleEntity) {
		super();
		this.customerId = customerId;
		this.loanAmount = loanAmount;
		this.tradeDate = tradeDate;
		this.loanStartDate = loanStartDate;
		this.maturityDate = maturityDate;
		this.paymentTerm = paymentTerm;
		this.paymentFrequency = paymentFrequency;
		this.interestRate = interestRate;
		this.paymentScheduleEntity = paymentScheduleEntity;
	}

	public LoanDetailsEntity() {
		super();
	}

	@Override
	public String toString() {
		return "LoanDetailsEntity [customerId=" + customerId + ", loanAmount=" + loanAmount + ", tradeDate=" + tradeDate
				+ ", loanStartDate=" + loanStartDate + ", maturityDate=" + maturityDate + ", paymentTerm=" + paymentTerm
				+ ", paymentFrequency=" + paymentFrequency + ", interestRate=" + interestRate
				+ ", paymentScheduleEntity=" + paymentScheduleEntity + "]";
	}

}