package com.finzly.loan.Entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private LocalDate paymentDate;
	private double principalAmount;
	private double projectedInterest;
	private double paymentAmount;
	private String paymentStatus;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}

	public double getProjectedInterest() {
		return projectedInterest;
	}

	public void setProjectedInterest(double projectedInterest) {
		this.projectedInterest = projectedInterest;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentScheduleEntity(int paymentId, LocalDate paymentDate, double principalAmount, double projectedInterest,
			double paymentAmount, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.principalAmount = principalAmount;
		this.projectedInterest = projectedInterest;
		this.paymentAmount = paymentAmount;
		this.paymentStatus = paymentStatus;
	}

	public PaymentScheduleEntity() {
		super();
	}

	@Override
	public String toString() {
		return "PaymentScheduleEntity [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", principalAmount="
				+ principalAmount + ", projectedInterest=" + projectedInterest + ", paymentAmount=" + paymentAmount
				+ ", paymentStatus=" + paymentStatus + "]";
	}

}