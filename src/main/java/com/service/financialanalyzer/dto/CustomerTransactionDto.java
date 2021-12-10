package com.service.financialanalyzer.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class CustomerTransactionDto {
	
private Integer transactionId;
	
	@JsonIgnore
	@NotNull(message = "Name cannot be null")
	@JsonProperty("customerId")
	private Integer customerId;
	
	@NotNull(message = "Amount cannot be null")
	@JsonProperty("amount")
	private double amount;
	
	@JsonProperty("transactionDesc")
	private String transactionDesc;
	
	@NotNull(message = "Payment Type cannot be null")
	@NotEmpty(message = "Payment Type cannot be empty")
	@JsonProperty("paymentType")
	private String paymentType;
	
	@NotNull(message = "Transaction Timestamp cannot be null")
	@JsonProperty("transactionTimestamp")
	private LocalDateTime transactionTimestamp;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
