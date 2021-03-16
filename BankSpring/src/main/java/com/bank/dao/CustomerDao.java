package com.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.bean.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
