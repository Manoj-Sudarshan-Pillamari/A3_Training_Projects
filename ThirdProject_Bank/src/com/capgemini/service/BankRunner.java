package com.capgemini.service;

import com.capgemini.exception.InsufficientBalanceAmountException;
import com.capgemini.exception.InvalidAccountNumberException;

public class BankRunner implements Runnable {

	Bank bank;	
		
	public BankRunner(Bank bank) {
		super();
		this.bank = bank;
	}

	@Override
	public void run() {
		
		try {
			if(Thread.currentThread().getName().equals("first"))
			{
				System.out.println("Balance = " + bank.withdrawAmount(101, 500));
			}
			else{
				System.out.println("Balance = " + bank.withdrawAmount(102, 1000));
			}
		}	
		catch(InvalidAccountNumberException iame)
		{
			System.out.println("Invalid Account number");
		}
		catch(InsufficientBalanceAmountException isbe)
		{
			System.out.println("Insufficient balance");
		}		

	}

}
