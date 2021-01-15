package com.capgemini.ui;

import com.capgemini.exception.InsufficientBalanceAmountException;
import com.capgemini.exception.InsufficientOpeningBalance;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.service.Bank;
import com.capgemini.service.ICICIBank;
public class Client {

	public static void main(String[] args) {
		
		Bank bank=new ICICIBank();
			
		try {
			System.out.println(bank.createAccount(101,5000));
			System.out.println(bank.createAccount(102,6000));
			System.out.println("Balance after withdrawal is "+ bank.withdrawAmount(102, 2000));
			int[] total = bank.fundTransfer(101, 102, 200);
			System.out.println("Sender Balance = " + total[0] );
			System.out.println("Receiver Balance = " + total[1]);
			System.out.println("After deposit balance is " + bank.depositAmount(102, 200));
			System.out.println(bank.createAccount(103, 200));
		}		
		catch(InvalidAccountNumberException iame)
		{
			System.out.println("Invalid Account number");
		}
		catch(InsufficientBalanceAmountException isbe)
		{
			System.out.println("Insufficient balance");
		}
		catch(InsufficientOpeningBalance isb)
		{
			System.out.println("Insufficient opening balance");
		}		
	}

}
