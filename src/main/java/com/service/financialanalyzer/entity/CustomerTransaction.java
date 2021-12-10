package com.service.financialanalyzer.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "CUSTOMER_TRANSACTION")
public class CustomerTransaction {
	
	@Id
	@GeneratedValue
	@Column(name = "trnasaction_id")
	private Integer transactionId;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "transaction_desc")
	private String transactionDesc;
	
	@Column(name = "payment_type")
	private String paymentType;
	
	@Column(name = "transaction_timestamp")
	private LocalDateTime transactionTimestamp;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionDesc() {
		return transactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public LocalDateTime getTransactionTimestamp() {
		return transactionTimestamp;
	}

	public void setTransactionTimestamp(LocalDateTime transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}
	
	
	

}
