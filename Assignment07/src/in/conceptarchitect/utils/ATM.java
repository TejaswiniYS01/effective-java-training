package in.conceptarchitect.utils;

import in.conceptarchitect.banking.BankAccount;

public class ATM {
	
	BankAccount account;
	
	public ATM(BankAccount account) {
		this.account = account;
	}
	
	public void deposit() {
		Input inputAmount=new Input();
		int amount=inputAmount.readInt("amount to deposit?");
		System.out.println(account.deposit(amount));
	}
	
	public void withdraw() {
		Input inputWithdraw=new Input();
		int withdrawAmount = inputWithdraw.readInt("amount to withdraw?");
		String password=inputWithdraw.readString("password");
		System.out.println(account.withdraw(withdrawAmount,password));
	}
	
	public void creditInterest() {
		account.creditInterest();
		System.out.println("The balance after interest credited is "+account.getBalance());
	}
	
	public void displayAccountDetails() {
		System.out.println("Account Number\t"+account.getAccountNumber()); 
		System.out.println("Name\t"+account.getName());
		System.out.println("Password\t"+account.getPassword()); 
		System.out.println("Balance\t"+account.getBalance()); 
		System.out.println("Interest Rate\t"+account.getInterestRate()); 
	}

}
