package com.capgemini.service;

import java.sql.SQLException;
import com.capgemini.beans.Account;
import com.capgemini.exception.InsufficientBalanceAmountException;
import com.capgemini.exception.InsufficientOpeningBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.utility.DatabaseCode;

public class ICICIBank implements Bank {
	DatabaseCode db = new DatabaseCode();
	
	@Override
	public boolean validateAccount(Integer AccNo) throws InvalidAccountNumberException
	{	
		if(db.searchData(AccNo))
			return true;
		else	
			throw new InvalidAccountNumberException();
		
	}
	
	@Override
	public boolean createAccount(int accountnum,int amount) throws InsufficientOpeningBalanceException
	{
		Account account = new Account();
		if( db.searchData(accountnum))
		{
			return false;
		}
		else {
			account.setAccountnumber(accountnum);
			if(amount>=500)
			{
				account.setAmount(amount);
				boolean flag =db.insertData(account);
				return flag;
			}
			else
				throw new InsufficientOpeningBalanceException();
		}		
	}	
	
	@Override
	public int depositAmount(int accountnum, int amount) throws SQLException {
		Account account = db.fetchData(accountnum);
		account.setAmount(account.getAmount()+amount);
		if(db.updateData(account)==1)
//		if(db.updateData(account))
		{
			return account.getAmount();
		}
		else if(db.updateData(account)==0) {
			return 0;
		}
		return 0;
//		throw new InvalidAccountNumberException();		
	}
	
	@Override
	public int withdrawAmount(int accountnumber, int amount) throws InsufficientBalanceAmountException, SQLException
	{
		Account account = db.fetchData(accountnumber);
		if(account.getAmount()-amount>=500)
		{
			account.setAmount(account.getAmount()-amount);
			if(db.updateData(account)==1)
//					.updateData(account))
			{
				return account.getAmount();
			}
			else if(db.updateData(account)==0) {
				return 1;
			}
			return 1;
		}
		else
			throw new InsufficientBalanceAmountException();
	}
	
	@Override
	public int[] fundTransfer(int sourceAccNo,int recieverAccNo, int amt) throws InsufficientBalanceAmountException, SQLException {
		int[] balance =null;
		Account sourceAccount = db.fetchData(sourceAccNo); 
		Account recieverAccount = db.fetchData(recieverAccNo);
		if(sourceAccount.getAmount()-amt>=500)
		{
			sourceAccount.setAmount(sourceAccount.getAmount()-amt);
			recieverAccount.setAmount(recieverAccount.getAmount()+amt);
			if(db.updateData(sourceAccount)==1 && db.updateData(recieverAccount)==1)
			{
				balance = new int[] {sourceAccount.getAmount(), recieverAccount.getAmount()};
				return balance;
			}				
			else
				return null;
		}
			else
				throw new InsufficientBalanceAmountException();
	}	
}
