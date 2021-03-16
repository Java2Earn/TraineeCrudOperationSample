package com.bank.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bean.Customer;
import com.bank.service.CustomerService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bank")
public class BankController {
	
	static int acc=00450;
	
	@Autowired
	CustomerService service;
	
	//CREATING NEW CUSTOMER
	
	@PostMapping("/create")
	public Customer addCustomer(@RequestBody Customer cust) {
		System.out.println(cust);
		Customer newCust=new Customer();
		newCust.setCustName(cust.getCustName());
		newCust.setCustMobile(cust.getCustMobile());
		newCust.setCustBalance(cust.getCustBalance());
		newCust.setCustAccountNo(++acc);
		System.out.println(newCust);
		Customer addcust = service.addCustomer(newCust);
		return addcust;
	}
	
   //GETTING DETAILS BY CUSTOMER ID
	
	@GetMapping("/show/{custId}")
	public long showBalance(@PathVariable("custId") int custId) {
		Customer showcust=service.showBalance(custId);
		return showcust.getCustBalance();
	}
	
   //DEPOSITING AMOUNT
	
	@PutMapping("deposit/{custId}/{amount}")
	public long deposit(@PathVariable("custId") int custId,@PathVariable("amount") long amount) {
		Customer cust=service.deposit(custId, amount);
		return cust.getCustBalance();
	}
	
   //WITHDRAWAL AMOUNT
	
	@PutMapping("withdrawl/{custId}/{amount}")
	public long withdrawl(@PathVariable("custId") int custId,@PathVariable("amount") long amount) {
		Customer cust=service.withdrawl(custId, amount);
		return cust.getCustBalance();
	}
	
	//FUND TRANSFER
	
	@PutMapping("transfer/{sId}/{rId}/{amount}")
	public long fundTransfer(@PathVariable("sId") int sId,@PathVariable("rId") int rId,@PathVariable("amount") long amount) {
		Customer cust= service.fundTransfer(sId, rId, amount);
		return cust.getCustBalance();
	}
	
	//PRINTING TRANSACTIONS
	
	@GetMapping("print")
	public List<String> print() {
		System.out.println("hlo");
		List<String> list=service.print();
		return list;
	}
	
	//GETTING ALL ACCOUNTS
	
	@GetMapping("/all")
	public List<Customer> all(){
		List<Customer> customers=service.all();
		return customers;
	}

}
