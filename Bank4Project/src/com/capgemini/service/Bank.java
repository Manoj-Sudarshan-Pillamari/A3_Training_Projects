package com.capgemini.service;

import java.sql.SQLException;

import com.capgemini.exception.InsufficientBalanceAmountException;
import com.capgemini.exception.InsufficientOpeningBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;

public interface Bank {

	boolean validateAccount(Integer AccNo) throws InvalidAccountNumberException;

	boolean createAccount(int accountnum, int amount) throws InsufficientOpeningBalanceException;

	int depositAmount(int accountnum, int amount) throws SQLException;

	int withdrawAmount(int accountnumber, int amount) throws InsufficientBalanceAmountException, SQLException;

	int[] fundTransfer(int sourceAccNo, int recieverAccNo, int amt)
			throws InsufficientBalanceAmountException, SQLException;

}