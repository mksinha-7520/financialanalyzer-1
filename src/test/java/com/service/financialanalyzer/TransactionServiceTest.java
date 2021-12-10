package com.service.financialanalyzer;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.financialanalyzer.dto.CustomerTransactionDto;
import com.service.financialanalyzer.entity.Customer;
import com.service.financialanalyzer.exception.handling.CustomerNotFoundException;
import com.service.financialanalyzer.exception.handling.PaymentCannotBeNegative;
import com.service.financialanalyzer.exception.handling.PaymentNotAllowed;
import com.service.financialanalyzer.repository.CustomerRepository;
import com.service.financialanalyzer.service.TransactionService;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import  org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {
	
	@Mock
    private CustomerRepository customerRepository;
	
	@InjectMocks
    private TransactionService transactionService = new TransactionService();
	
	Customer customer;
	
	@Before
    public void setMockOutput() {
		MockitoAnnotations.initMocks(this);
		customer= new Customer();
		customer.setCustomerId(1);
		customer.setDob(new Date());
		customer.setBalance(0.0);
		customer.setMobileNumber(9890989098l);
		customer.setState("Delhi");
		customer.setNationality("INDIAN");
		customer.setGovtId("111111111");
		customer.setGovtIdType("ADHAR");
		customer.seteMail("a@b.com");
		customer.setAddress("Delhi");
		customer.setCustomerName("Abhi");
		
		
		
        when(customerRepository.findByCustomerId(anyInt())).thenReturn(customer);
    }
	
	@Test(expected = PaymentCannotBeNegative.class)
	public void whenCustomerBalanceNegativeThanPaymentCannotBeNegativeExceptionReceived() throws EntityNotFoundException, CustomerNotFoundException, PaymentCannotBeNegative, PaymentNotAllowed {
		
		CustomerTransactionDto customerTransactionDto = new CustomerTransactionDto();
		customerTransactionDto.setPaymentType("Receive Payment");
		
		transactionService.getCustomerForGivenId(1, customerTransactionDto);
		
	}
	
	@Test(expected = PaymentNotAllowed.class)
	public void whenCustomerBalanceNegativeThanPPaymentNotAllowedExceptionReceived() throws EntityNotFoundException, CustomerNotFoundException, PaymentCannotBeNegative, PaymentNotAllowed {
		customer.setBalance(10.0);
		CustomerTransactionDto customerTransactionDto = new CustomerTransactionDto();
		customerTransactionDto.setPaymentType("Make Payment");
		customerTransactionDto.setAmount(100.0);
		
		transactionService.getCustomerForGivenId(1, customerTransactionDto);
		
	}

}
