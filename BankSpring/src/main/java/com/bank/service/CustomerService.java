package com.bank.service;

import java.util.List;

import com.bank.bean.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer cust);
	
	public Customer showBalance(int custId);
	
	public Customer deposit(int custId, long amount);
	
	public Customer withdrawl(int custId, long amount);
	
	public Customer fundTransfer(int sId,int rId,long amount);
	
	public List<String> print();
	
	public List<Customer> all();
}
