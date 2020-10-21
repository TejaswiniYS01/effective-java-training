package in.conceptarchitect.banking;

import in.conceptarchitect.utils.Input;

public class BankAccount {
	
	int accountNumber;
	String name;
	String password;
	double balance;
	double interestRate;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	//you can't change your account number
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	//balance
	public double getBalance() {
		return balance;
	}
	
	//no set balance. to set balance use deposit or withdraw
	
	//get set interest rate
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	
	
	
	public  BankAccount(int accountNumber, String name, String password, double amount, double rate) {
		createAccount(accountNumber, name, password,amount, rate);
	}
	
	
	//I don't want anyone else calling this function
	private void createAccount(int accountNumber, String name, String password, double amount, double rate) {

		this.accountNumber=accountNumber;
		this.name=name;  //this.name is class field, name is argument
		this.password=password;
		
		this.balance=amount; //this is not required as balance has no conflict
		interestRate=rate;   //this is not required
	}
	
	public void show() {
		System.out.println("Account Number\t"+this.accountNumber);//this is not required 
		System.out.println("Name\t"+name); //this is not required
		System.out.println("Password\t"+password); //this is not required
		System.out.println("Balance\t"+balance); //this is not required
		System.out.println("Interest Rate\t"+interestRate); //this is not required
	}
	
	public String deposit(int amount) {
		if(amount>0) {
			balance+=amount;
			return "Amount deposited successfully";
		}
		else {
			return "Invalid Amount. Deposit Failed";
		}
		
	}

	public String withdraw(int amount, String password) {
		if(!this.password.equals(password)) {
			return "invalid credentials";
		}else if(amount<=0) {
			
			return "invalid denomination. please enter positive amount";
			
		} else if(amount> balance) {
			
			return "Insufficient Funds";
			
		}else {
			
			balance-=amount;
			return "please collect your cash";
			
		}
		
	}

	public void creditInterest() {
		balance+=(balance*interestRate)/1200; //one month interest at a time.
	}

}
