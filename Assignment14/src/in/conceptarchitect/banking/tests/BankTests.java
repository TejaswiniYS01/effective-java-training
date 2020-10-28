package in.conceptarchitect.banking.tests;

import static in.conceptarchitect.utils.CustomAsserts.assertType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.SavingsAccount;
import in.conceptarchitect.banking.exceptions.InsufficientBalanceException;
import in.conceptarchitect.banking.exceptions.InvalidAccountNumberException;
import in.conceptarchitect.banking.exceptions.InvalidCredentialsException;

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
		sourceAccountNumber = bank.openAccount("savings",name,correctPassword, balance);
		targetAccountNumber = bank.openAccount("savings",toName, toPassword, toBalance);
		
	}
	
	@Test(expected=InvalidAccountNumberException.class)
	public void transfer_shouldFailIfFromAccountDoesntExist() {
		bank.transfer(0, 1000, correctPassword, targetAccountNumber);
		//assertEquals(false,result);
	}
	
	@Test(expected=InvalidAccountNumberException.class)
	public void transfer_shouldFailIfInvalidToAccount() {
		bank.transfer(sourceAccountNumber, 1000, correctPassword, 0);
		//assertEquals(false,result);
	}
	

	@Test(expected=InvalidCredentialsException.class)
	public void transfer_shouldFailForInvalidPassword() {
		bank.transfer(sourceAccountNumber, 1000, "abc", targetAccountNumber);
		//assertEquals(false,result);
	}
	
	@Test(expected=InsufficientBalanceException.class)
	public void transfer_shouldFailForInsufficientBalance() {
		bank.transfer(sourceAccountNumber, balance+1, correctPassword, targetAccountNumber);
		//assertEquals(false,result);
	}
	
	@Test
	public void transfer_shouldSucceedInHappyPath() {
		bank.transfer(sourceAccountNumber, balance-5000, correctPassword, targetAccountNumber);
	}
	
	@Test
	public void creditInterest_creditsOneMonthOfInterest() {
		double expectedBal = balance+=(balance*interestRate)/1200;
		account.creditInterest(interestRate);
		double actualBalAfterInterest = account.getBalance();
		assertTrue(expectedBal==actualBalAfterInterest);
	}
	
	@Test(expected=InvalidAccountNumberException.class)
	public void closeAccount_failsForInvalidAccountNumber() {
		bank.close(111, toPassword);
//		assertEquals(false,result);
	}
	
	@Test(expected=Exception.class)
	public void closeAccount_cantWithdrawFromClosedAccount() {
		bank.close(targetAccountNumber, toPassword);
		bank.withdraw(targetAccountNumber, 1000, toPassword);
	}
	
	
	@Test
	public void openAccount_AssignsSequentialAccountNumber() {
		assertEquals(targetAccountNumber,sourceAccountNumber+1);
	}
	
	
	@Test
	public void openAccount_withSavingsTypeCreatesASavingAccount() {
		
		Bank bank=new Bank("bank name",1);
		
		bank.openAccount("savings", "someone", "somepassword", 1000);
		
		BankAccount account=bank.getAccount(1,"somepassword");
		
		assertType(SavingsAccount.class, account);
		
	}
	
	
	

}
