package com.service.financialanalyzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import java.util.Optional;
import java.util.logging.*;

import com.service.financialanalyzer.dto.CustomerTransactionDto;
import com.service.financialanalyzer.entity.Customer;
import com.service.financialanalyzer.entity.CustomerTransaction;
import com.service.financialanalyzer.exception.handling.CustomerNotFoundException;
import com.service.financialanalyzer.exception.handling.PaymentCannotBeNegative;
import com.service.financialanalyzer.exception.handling.PaymentNotAllowed;
import com.service.financialanalyzer.repository.CustomerRepository;
import com.service.financialanalyzer.service.TransactionService;

import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("api")
@Validated
public class FinancialAdviserController {
	
	private final static Logger LOGGER = 
            Logger.getLogger(FinancialAdviserController.class.getName());
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@PostMapping("/customers/{customerId}/transactions")
	public void getCustomerTransaction(@Valid @RequestBody CustomerTransactionDto customerTransactionDto,
			@PathVariable("customerId") Integer customerId) throws CustomerNotFoundException, PaymentCannotBeNegative, PaymentNotAllowed {
		
		LOGGER.info("inside transactions controller.");
		
		Customer customer = transactionService.getCustomerForGivenId(customerId, customerTransactionDto);
		
		
		CustomerTransaction customerTransaction = modelMapper.map(customerTransactionDto, CustomerTransaction.class);
		
		LOGGER.info("Customer Transaction Mapping done.");
		
		setPaymentTypeAndBalance(customerTransaction, customer );		
		
		customerRepository.save(customer);		
		
		
		
		transactionService.saveCustomerTransaction(customerTransaction);
		
		
		
		
	}
	
	public void setPaymentTypeAndBalance(CustomerTransaction customerTransaction, Customer customer) {
		if(customerTransaction.getPaymentType().equals("Make Payment")) {
			customerTransaction.setPaymentType("Debit");
		} else if(customerTransaction.getPaymentType().equals("Receive Payment")) {
			customerTransaction.setPaymentType("Credit");
		}
		
		if(customerTransaction.getAmount() !=0.0 && customerTransaction.getPaymentType().equals("Debit") ) {
			customer.setBalance(customer.getBalance() - customerTransaction.getAmount());
			
		} else if(customerTransaction.getPaymentType().equals("Credit") ) {
			customer.setBalance(customer.getBalance() + customerTransaction.getAmount());
		}
	}

}
