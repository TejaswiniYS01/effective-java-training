package in.conceptarchitect.banking.tests;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;

public class BankTests {
	
	
	BankAccount account;
	String name="Tej";
	String correctPassword="pass";
	double balance=50000;
	BankAccount toAccount;
	String toName="Trupthi";
	String toPassword="pass";
	double toBalance=50000;
	Bank bank;
	int interestRate = 10;
	int targetAccountNumber;
	int sourceAccountNumber;
	
	@Before
	public void init() {
		bank = new Bank("icici",interestRate);
		account=new BankAccount(name,correctPassword, balance);
		sourceAccountNumber = bank.openAccount(name,correctPassword, balance);
		targetAccountNumber = bank.openAccount(toName, toPassword, toBalance);
		
	}
	
	
	@Test
	public void transfer_shouldFailIfFromAccountDoesntExist() {
		boolean result = bank.transfer(111, 1000, correctPassword, targetAccountNumber);
		assertEquals(false,result);
	}
	
	@Test
	public void transfer_shouldFailIfInvalidToAccount() {
		boolean result = bank.transfer(sourceAccountNumber, 1000, correctPassword, 111);
		assertEquals(false,result);
	}
	
	@Test
	public void transfer_shouldFailForInvalidPassword() {
		boolean result = bank.transfer(sourceAccountNumber, 1000, "abc", 111);
		assertEquals(false,result);
	}
	
	@Test
	public void transfer_shouldFailForInsufficientBalance() {
		boolean result = bank.transfer(sourceAccountNumber, balance+1, correctPassword, targetAccountNumber);
		assertEquals(false,result);
	}
	
	@Test
	public void transfer_shouldSucceedInHappyPath() {
		boolean result = bank.transfer(sourceAccountNumber, balance, correctPassword, targetAccountNumber);
		assertEquals(true,result);
	}
	
	@Test
	public void creditInterest_creditsOneMonthOfInterest() {
		double expectedBal = balance+=(balance*interestRate)/1200;
		account.creditInterest(interestRate);
		double actualBalAfterInterest = account.getBalance();
		assertTrue(expectedBal==actualBalAfterInterest);
	}
	
	@Test
	public void closeAccount_failsForInvalidAccountNumber() {
		boolean result = bank.close(targetAccountNumber+111, toPassword);
		assertEquals(false,result);
	}
	
	@Test
	public void closeAccount_cantWithdrawFromClosedAccount() {
		boolean result = bank.close(targetAccountNumber, toPassword);
		if(result) {
			boolean withdrawSuccess = bank.withdraw(targetAccountNumber, 1000, toPassword);
			assertEquals(false,withdrawSuccess);
		}
	}
	
	
	@Test
	public void openAccount_AssignsSequentialAccountNumber() {
		assertEquals(targetAccountNumber,sourceAccountNumber+1);
	}
	

}
