package com.capgemini.ui;

import com.capgemini.exception.InsufficientBalanceAmountException;
import com.capgemini.exception.InsufficientOpeningBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.service.Bank;
import com.capgemini.service.BankRunner;
import com.capgemini.service.ICICIBank;
public class Client {

	public static void main(String[] args) {

		Bank bank=new ICICIBank();
		BankRunner bankrunner = new BankRunner(bank);
		try {

			System.out.println(bank.createAccount(101,5000));
			System.out.println(bank.createAccount(102,6000));
			Thread firstThread = new Thread(bankrunner, "first");
			firstThread.start();
			Thread secondThread = new Thread(bankrunner, "second");
			secondThread.start();
			int[] total = bank.fundTransfer(101, 102, 200);
			System.out.println("Sender Balance = " + total[0] );
			System.out.println("Receiver Balance = " + total[1]);
			System.out.println("After deposit balance is " + bank.depositAmount(102, 200));
			System.out.println(bank.createAccount(103, 200));		
		}
		catch(InsufficientOpeningBalanceException iob)
		{
			System.out.println("Insufficient opening balance");
		}
		catch(InsufficientBalanceAmountException ibae)
		{
			System.out.println("Insufficient Balance");
		}
		catch(InvalidAccountNumberException iane)
		{
			System.out.println("Invalid account number");
		}
	}

}
