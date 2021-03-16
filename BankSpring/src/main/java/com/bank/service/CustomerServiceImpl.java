package com.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bean.Customer;
import com.bank.dao.CustomerDao;
import com.exception.CustomeException;
import com.exception.FundTransferException;
import com.exception.WithdrawlException;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	List<String> list=new ArrayList<String>();
//creating Objects with @autowired 	
	@Autowired
	CustomerDao repo;
//all overriding methods
	@Override
	public Customer addCustomer(Customer cust) {
		return repo.save(cust);
	}

	@Override
	public Customer showBalance(int custId) {
		Customer cust= repo.findById(custId).orElse(null);
		try {
			if(cust!=null) 
				return cust;
			else
				throw new CustomeException("no such account");
		} catch (CustomeException e) {
			System.out.println("Try Again");
		}
		return null;
	}

	@Override
	public Customer deposit(int custId, long amount) {
		Customer cust=repo.findById(custId).orElse(null);
		try {
			if(cust!=null) {
				long temp=cust.getCustBalance()+amount;
				cust.setCustBalance(temp);
				repo.save(cust);
				
				list.add("Amount"+" "+amount+" "+"Deposited to your Account"+cust.getCustAccountNo());
				
				return cust;
			}
			else
				throw new CustomeException("no such account");
		} catch (CustomeException e) {
			System.out.println("Try Again");
		}
		
		return null;
	}

	@Override
	public Customer withdrawl(int custId, long amount) {
		Customer cust=repo.findById(custId).orElse(null);
		try {
			if(cust!=null) {
				long avlBal=cust.getCustBalance();
				try {
					if(avlBal>amount) {
						long temp=cust.getCustBalance()-amount;
						cust.setCustBalance(temp);
						repo.save(cust);
						return cust;
					}
					else
						throw new WithdrawlException("Not Enough Balance To Withdrawl");
				} catch (WithdrawlException e) {
					System.out.println("Try With Low Balance");
				}
				return cust;
			}
			else
				throw new CustomeException("no such customer id");
		} catch (CustomeException e) {
			System.out.println("Try Again");
		}
		return null;
			
	}

	@Override
	public Customer fundTransfer(int sId, int rId, long amount) {
		Customer sender=repo.findById(sId).orElse(null);
		long senderBalance=sender.getCustBalance();
		Customer recieve=repo.findById(rId).orElse(null);
		long recieveBalance=recieve.getCustBalance();
		try {
			if(senderBalance>=amount) {
				long stemp=senderBalance-amount;
				sender.setCustBalance(stemp);
				long rtemp=recieveBalance+amount;
				recieve.setCustBalance(rtemp);
				
				repo.save(sender);
				repo.save(recieve);
				
				return sender;
			}
			else
				throw new FundTransferException("Available Balance is Low");
		} catch (FundTransferException e) {
			System.out.println("Try Again");
		}
		return null;
	}

	@Override
	public List<String> print() {
		return list;
	}

	@Override
	public List<Customer> all() {
		List<Customer> all=repo.findAll();
		return all;
	}

	

}
