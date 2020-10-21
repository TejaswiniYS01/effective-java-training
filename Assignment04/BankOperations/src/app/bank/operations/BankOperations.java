package app.bank.operations;

public class BankOperations {
	
	public BankAccount createAccount(String name, String password, Double balance) {
		BankAccount bankAccount = new BankAccount("xyz000"+1, name, password, balance);
		System.out.println("An account has been created for "+bankAccount.getName()+" with balance : "+bankAccount.getBalance());
		return bankAccount;
	}
	
	public BankAccount depositMoney(BankAccount account, Double amount) {
		if(amount<=0) {
			System.out.println("The entered amount should be greater than zero");
		}else {
			double newBal = account.getBalance()+amount;
			account.setBalance(newBal);
			System.out.println("Your account has been credited with Rs. "+amount+" and the new balance is Rs. "+account.getBalance());
		}
		return account;
	}
	
	public BankAccount withdrawMoney(BankAccount account, Double amount, String password) {
		if(password!=null && account.getPassword().equals(password)) {
			if(amount!=null && amount<=0) {
				System.out.println("The entered amount should be greater than zero");
			}else if(amount>account.getBalance()) {
				System.out.println("Insufficient Balance");
			} else {
				Double newBal = account.getBalance() - amount;
				account.setBalance(newBal);
				System.out.println("Rs. "+amount+" has been debited from your account and the new balance is Rs. "+account.getBalance());
			}
		}else {
			System.out.println("The entered password is not correct");
		}
		return account;
	}
	
	public BankAccount creditInterest(BankAccount account) {
		if(account.getBalance() !=null && account.getBalance()>0) {
			Double interestAmount = account.getBalance()*account.getInterestRate()/1200 ;
			System.out.printf("Interest of Rs. %2f has been credited ",interestAmount);
			account.setBalance(interestAmount+ account.getBalance());
		}
		return account;
	}
	
	

}
