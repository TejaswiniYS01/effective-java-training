package in.conceptarchitect.banking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.SavingsAccount;
import in.conceptarchitect.banking.exceptions.InsufficientBalanceException;
import in.conceptarchitect.banking.exceptions.InvalidCredentialsException;

public class SavingsAccountTests {

	SavingsAccount account;
	String name="Vivek";
	String password="p@ss";
	int balance=15000;
	int minBalance=5000;

	@Before
	public void init() {
		
		account=new SavingsAccount(name, password, balance);
		
	}
	
	@Test(expected=InvalidCredentialsException.class)
	public void withdraw_failsForWrongPassword() {
		account.withdraw(1, "wrong-password");
		
//		assertFalse(result);
		
		
	}
	
	
	@Test(expected=InsufficientBalanceException.class)
	public void withdraw_failsIfNetBalancePostWithdrawRedudesBelowMinBalance() {
		
		account.withdraw(balance-minBalance+1, password);		
//		assertFalse(result);
	}
	
	@Test
	public void withdraw_succeedsIfPostWithdrawMinBalanceIsAvailable() {
		account.withdraw(balance-minBalance, password);
		double minBal = account.getBalance();
		assertEquals(minBalance,minBal,0.1);
//		assertTrue(result);
	}
	
	@Test
	public void withdraw_reducesTheBalance() {
		
		account.withdraw(1000, password);
		
		assertEquals(balance-1000, account.getBalance(),0.01);
	}
	
	@Test
	public void creditInterest_addsMonthlyInterstToBalance() {

		//arrange
		double rate=12;
		double updatedBalance= balance+ balance*rate/1200;
		
		//act
		account.creditInterest(rate);		
		
		
		//assert
		assertEquals(updatedBalance, account.getBalance(),0.2);  //balance shouldn't change after crediting interest 
		
		
	}


	

}
