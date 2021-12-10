package com.service.financialanalyzer.dto;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated
public class CustomerDto {
	
	@JsonProperty("customer_id")
	private Integer customerId;
	
	@JsonProperty("customer_name")
	private String customerName;
	
	@JsonProperty("e_mail")
	private String eMail;
	
	@JsonProperty("mobile_number")
	private long mobileNumber;
	
	@JsonProperty("mobile_number")
	private Date dob;
	
	@JsonProperty("nationality")
	private String nationality;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("govt_id_type")
	private String govtIdType;
	
	@JsonProperty("govt_id")
	private String govtId;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGovtIdType() {
		return govtIdType;
	}

	public void setGovtIdType(String govtIdType) {
		this.govtIdType = govtIdType;
	}

	public String getGovtId() {
		return govtId;
	}

	public void setGovtId(String govtId) {
		this.govtId = govtId;
	}
	
	

}
