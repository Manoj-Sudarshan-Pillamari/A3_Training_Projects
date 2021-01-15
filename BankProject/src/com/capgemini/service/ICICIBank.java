package com.capgemini.service;

import java.util.LinkedList;

import com.capgemini.bean.Account;
import com.capgemini.exception.InsufficientBalanceAmountException;
import com.capgemini.exception.InsufficientOpeningBalance;
import com.capgemini.exception.InvalidAccountNumberException;

public class ICICIBank implements Bank {

	private LinkedList<Account> accounts=new LinkedList<Account>();

	public String createAccount(int accountnumber,int amount) throws InsufficientOpeningBalance
	{		
		if(amount>=500)
		{
			Account account=new Account();
			account.setAccountnumber(accountnumber);
			account.setAmount(amount);
			accounts.add(account);		
			return "Account created Successfully";
		}
		throw new InsufficientOpeningBalance();
	}	

	private Account searchAccount(int accountnumber) throws InvalidAccountNumberException
	{
		for(Account account:accounts)
		{
			if(accountnumber==account.getAccountnumber())
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
	}

	public int withdrawAmount(int accountnumber, int amount) throws InvalidAccountNumberException,InsufficientBalanceAmountException
	{
		Account account= searchAccount(accountnumber);
		if ((account.getAmount()-amount)>=500)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		throw new InsufficientBalanceAmountException();
	}

	public int[] fundTransfer(int senderAccount, int receiverAccount, int transferAmount) throws InsufficientBalanceAmountException, InvalidAccountNumberException
	{
		Account sender=searchAccount(senderAccount);
		Account receiver=searchAccount(receiverAccount);
		if (sender.getAmount()>=transferAmount)
		{
			sender.setAmount(sender.getAmount()-transferAmount);
			receiver.setAmount(receiver.getAmount()+transferAmount);
			int[] total = {sender.getAmount(), receiver.getAmount()};
			return total;
		}		
		throw new InsufficientBalanceAmountException();
	}	

	public int depositAmount(int accountnumber, int amount) throws InvalidAccountNumberException
	{
		Account account= searchAccount(accountnumber);
		account.setAmount(account.getAmount()+amount);
		return account.getAmount();			
	}

}
