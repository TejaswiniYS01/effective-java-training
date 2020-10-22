package in.conceptarchitect.banking;

public class Bank {

	int accountCount=0;   	
	String name;
	double interestRate;
	public final int MAX_ACCOUNTS=10; //PROBLEM: we can't have more than this much account

	//storage for BankAccounts
	BankAccount [] accounts=new BankAccount[MAX_ACCOUNTS];

	public Bank(String name, double interstRate) {

		this.interestRate=interstRate;
		this.name=name;


	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getAccountCount() {
		return accountCount;
	}

	public String getName() {
		return name;
	}


	private BankAccount getAccountById(int accountNumber) {
		if(accountNumber<1 || accountNumber>accountCount)
			return null; //no such account

		BankAccount account=accounts[accountNumber];
		return account;
	}

	public int openAccount(String name, String password, double amount) {

		BankAccount account=new BankAccount(name,password,amount);

		//Bank should set the account Number which is accessible due to package scope
		account.accountNumber=++accountCount;

		//add the account to account list

		//account number x will be stored on location x
		//we will never use index 0 to store a account
		accounts[account.accountNumber]=account;

		//return the account Number
		return account.accountNumber;
	}



	public boolean close(int accountNumber, String password) {
		BankAccount account = getAccountById(accountNumber);
		//TODO: validate password is correct
		if(account != null) {
			if(!account.authenticate(password)) {
				System.out.println("Invalid credentials");
				return false;
			}else if(account.getBalance()<=0) {//TODO: validate it has balance>0
				System.out.println("Insufficient balance");
				return false;
			}else  {//TODO: close the account and return true
				accounts[accountNumber] = null;
				return true;
			}
		}else {
			return false;
		}
	}

	public boolean deposit(int accountNumber, double amount) {

		BankAccount account = getAccountById(accountNumber);
		if(account!=null) {
			return account.deposit(amount);
		}else {
			return false;
		}

	}



	public boolean withdraw(int accountNumber, double amount, String password) {
		BankAccount account = getAccountById(accountNumber);
		if(account!=null) {
			return account.withdraw(amount, password);
		}else {
			return false;
		}
		//TODO: we must verify account exists


	}



	public boolean transfer(int sourceAccountNumber,  double amount, String password,int targetAccountNumber) {

		BankAccount src = getAccountById(sourceAccountNumber);
		BankAccount target=getAccountById(targetAccountNumber);

		if(src==null)
			return false;
		if(target==null) 
			return false;


		if(src.withdraw(amount, password))
			return target.deposit(amount);
		else	
			return false;
	}

	public void printAccountList() {

		System.out.println("Account\tBalance\tName");
		for(int i=1;i<=accountCount;i++) {
			BankAccount a=accounts[i];
			System.out.printf("%d\t%f\t%s\n",a.getAccountNumber(),a.getBalance(),a.getName());
		}
	}


	public void creditInterests() {

		System.out.println("Account\tBalance\tName");
		for(int i=1;i<=accountCount;i++) {
			BankAccount a=accounts[i];
			a.creditInterest(interestRate);
			System.out.printf("%d\t%f\t%s\n",a.getAccountNumber(),a.getBalance(),a.getName());
		}
	}

	public void show(int accountNumber) {
		BankAccount account = getAccountById(accountNumber);
		if(account!=null) {
			account.show();
		}
	}

	public double getBalance(int accountNumber) {
		BankAccount account = getAccountById(accountNumber);
		if(account!=null) {
			return account.getBalance();
		}else
			return 0;
	}


}
