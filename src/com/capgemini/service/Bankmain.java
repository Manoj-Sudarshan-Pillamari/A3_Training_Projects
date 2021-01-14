package com.capgemini.service;

import com.capgemini.bean.Account;
import com.capgemini.exception.InsufficientBalanceAmountException;
import com.capgemini.exception.InsufficientOpeningBalance;
import com.capgemini.exception.InvalidAccountNumberException;

public interface Bankmain {

	
	
	public String createAccount(int accountnumber,int amount) throws InsufficientOpeningBalance;
	
	public Account searchAccount(int accountnumber) throws InvalidAccountNumberException;
	
	public int withdrawAmount(int accountnumber, int amount) throws InvalidAccountNumberException,InsufficientBalanceAmountException;
	
	public int[] fundTransfer(int senderAccount, int receiverAccount, int transferAmount) throws InsufficientBalanceAmountException, InvalidAccountNumberException;
	
	public int depositAmount(int accountnumber, int amount) throws InvalidAccountNumberException;
	
}
