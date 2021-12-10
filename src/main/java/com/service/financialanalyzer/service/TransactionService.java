package com.service.financialanalyzer.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.financialanalyzer.dto.CustomerTransactionDto;
import com.service.financialanalyzer.entity.Customer;
import com.service.financialanalyzer.entity.CustomerTransaction;
import com.service.financialanalyzer.exception.handling.CustomerNotFoundException;
import com.service.financialanalyzer.exception.handling.PaymentCannotBeNegative;
import com.service.financialanalyzer.exception.handling.PaymentNotAllowed;
import com.service.financialanalyzer.repository.CustomerRepository;
import com.service.financialanalyzer.repository.CustomerTranasactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerTranasactionRepository customerTranasactionRepository;
	
	public static final String PAYMENT_TYPE = "Make Payment";

	public Customer getCustomerForGivenId(Integer customerId, CustomerTransactionDto customerTransactionDto) throws CustomerNotFoundException, PaymentCannotBeNegative, PaymentNotAllowed, EntityNotFoundException {
		
		Customer customer = customerRepository.findByCustomerId(customerId);
		
		if(null == customer.getCustomerId()) {
			throw new CustomerNotFoundException();
		}

		if(customer.getBalance() <= 0.0) {
			throw new PaymentCannotBeNegative();
		}
		
		if(customer.getBalance() < customerTransactionDto.getAmount() 
				&& customerTransactionDto.getPaymentType().equals(PAYMENT_TYPE)) {
			throw new PaymentNotAllowed();
		}
		
		return customer;
		
	}
	
	public void saveCustomerTransaction(CustomerTransaction customerTransaction) {
		
		customerTranasactionRepository.save(customerTransaction);
		
	}
}
