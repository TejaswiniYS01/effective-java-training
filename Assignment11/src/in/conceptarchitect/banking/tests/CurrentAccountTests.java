package in.conceptarchitect.banking.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.CurrentAccount;

public class CurrentAccountTests {
	
	CurrentAccount account;
	String name="Vivek";
	String password="p@ss";
	int balance=15000;
//	int minBalance=5000;
	
	@Before
	public void init() {
		account=new CurrentAccount(name, password, balance);
		
	}

	@Test
	public void creditInterest_doesntCreditInterestToCurrentAccount() {
		//double amount=10000;	
		account.creditInterest(12);
		assertEquals(balance, account.getBalance(),0);  //balance shouldn't change after crediting interest 
				
	}

	
	@Test
	public void withdraw_canWithdrawUptoBalanceUsingRightPassword() {
		boolean result = account.withdraw(balance, password);
		assertEquals(true,result);
		
	}
	
	@Test
	public void withdraw_failsForInsufficientBalance() {
		boolean result = account.withdraw(balance+100, password);
		assertEquals(false,result);
	}
	
	@Test
	public void withdraw_failsForWrongPassword() {
		boolean result = account.withdraw(balance, "password123");
		assertEquals(false,result);
	}
	
	@Test
	public void withdraw_failsForNegativeAmount() {
		boolean result = account.withdraw(balance-2*balance, password);
		assertEquals(false,result);
	}
}
