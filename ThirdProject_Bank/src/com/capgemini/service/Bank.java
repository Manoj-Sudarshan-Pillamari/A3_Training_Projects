package com.capgemini.service;

import com.capgemini.exception.InsufficientBalanceAmountException;
import com.capgemini.exception.InsufficientOpeningBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;

public interface Bank {

	public String createAccount(int accountnumber,int amount) throws InsufficientOpeningBalanceException;
	public int withdrawAmount(int accountnumber, int amount) throws InvalidAccountNumberException,InsufficientBalanceAmountException;
	public int[] fundTransfer(int senderAccount, int receiverAccount, int transferAmount) throws InsufficientBalanceAmountException, InvalidAccountNumberException;
	public int depositAmount(int accountnumber, int amount) throws InvalidAccountNumberException;
	
}