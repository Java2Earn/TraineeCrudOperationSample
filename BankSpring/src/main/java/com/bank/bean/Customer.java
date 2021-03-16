package com.bank.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="bankcustomer")
public class Customer {
	
	@Id
	@SequenceGenerator(name="seq",sequenceName="Acc_sequence")
    @GeneratedValue(generator="seq")
	private int custId;
	private String custName;
	private long custMobile;
	private long custBalance;
	private long custAccountNo;
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custMobile=" + custMobile + ", custBalance="
				+ custBalance + ", custAccountNo=" + custAccountNo + "]";
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(long custMobile) {
		this.custMobile = custMobile;
	}
	public long getCustBalance() {
		return custBalance;
	}
	public void setCustBalance(long custBalance) {
		this.custBalance = custBalance;
	}
	public long getCustAccountNo() {
		return custAccountNo;
	}
	public void setCustAccountNo(long custAccountNo) {
		this.custAccountNo = custAccountNo;
	}
	

	
}
