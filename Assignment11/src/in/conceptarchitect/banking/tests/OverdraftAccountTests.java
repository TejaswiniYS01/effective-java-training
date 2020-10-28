package in.conceptarchitect.banking.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.CurrentAccount;
import in.conceptarchitect.banking.OverDraftAccount;

public class OverdraftAccountTests {
	
	OverDraftAccount account;
	String name="Vivek";
	String password="p@ss";
	int balance=15000;
	int interestRate = 10;
//	int minBalance=5000;
	
	@Before
	public void init() {
		account=new OverDraftAccount(name, password, balance);
		
	}
	
	
	


	@Test
	public void account_hasOdLimitAs10PercentOfInitialDeposit() {
		Double expectedOdLimit = account.getBalance()/OverDraftAccount.odLimitRate;
		Double actualOdLimit = account.getOdLimit();
		assertEquals(expectedOdLimit,actualOdLimit,0);
	}
	
	@Test
	public void odLimit_increasesOdLimitIfBalanceIncreasesToHistoricHightestValue() {
		Double odLimit = account.getOdLimit();
		Double oldHighestBalance = account.getHighestBalance();
		account.deposit(20000);
		Double newHighestBalance = account.getHighestBalance();
		Double newOdLimit = account.getOdLimit();
		if(newHighestBalance>oldHighestBalance) {
			assertTrue(newOdLimit>odLimit);
		}
	}
	
	@Test
	public void odLimit_doesntChangeOnWithdrawal() {
		Double odLimit = account.getOdLimit();
		account.withdraw(1000, password);
		Double newOdLimit = account.getOdLimit();
		assertEquals(odLimit,newOdLimit);
	}
	
	@Test
	public void odLimit_canIncreaseIfCreditInterestIncreasesAccountBalanceUptoHistoricMax() {
		Double odLimit = account.getOdLimit();
		account.creditInterest(interestRate);
		Double newOdLimit = account.getOdLimit();
		assertTrue(newOdLimit>odLimit);
	}
	
	@Test
	public void odLimit_doesntChangeIfNewBalanceIsLessThanHistoricMaxBalance() {
		Double odLimit = account.getOdLimit();
		Double oldHighestBalance = account.getHighestBalance();
		account.withdraw(5000, password);
		Double newBalance = account.getBalance();
		Double newHighestBalance = account.getHighestBalance();
		Double newOdLimit = account.getOdLimit();
		if(newBalance < oldHighestBalance) {
			assertEquals(odLimit,newOdLimit);
		}
	}
	
		
	@Test
	public void withdraw_canWithdrawUptoBalancePlusOdLimit() {
		Double balance = account.getBalance();
		Double odLimit = account.getOdLimit();
		Boolean result = account.withdraw(balance+odLimit, password);
		assertTrue(result);
	}

	@Test
	public void withdraw_canPushMyBalanceToNegative() {
		Double balance = account.getBalance();
		Double odLimit = account.getOdLimit();
		Double bal = account.getBalance();
		assertTrue(bal<0);
	}
	
	@Test
	public void withdraw_overlimitAttracts1PCOdFee() {
		Double balance = account.getBalance();
		Double odLimit = account.getOdLimit();
		Double bal = account.getBalance();
		Double odCharge = bal - odLimit;
		assertNotNull(odCharge);
	}
	
	
}
