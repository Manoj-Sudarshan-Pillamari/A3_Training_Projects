package com.capgemini.bean;

public class Account {

	private int accountnumber;
	private int amount;
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Account [accountnumber=" + accountnumber + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
	
}
