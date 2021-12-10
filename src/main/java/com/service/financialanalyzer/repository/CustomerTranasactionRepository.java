package com.service.financialanalyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.financialanalyzer.entity.Customer;
import com.service.financialanalyzer.entity.CustomerTransaction;

@Repository
public interface CustomerTranasactionRepository extends JpaRepository<CustomerTransaction, Integer> {

}
