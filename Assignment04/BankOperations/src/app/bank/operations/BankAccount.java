package app.bank.operations;

public class BankAccount {
	
	private String accountNumber;
	private String name;
	private String password;
	private Double balance;
	private Integer interestRate;
	
	public BankAccount(String accountNumber, String name, String password, Double balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.interestRate = 10;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
//	public void setAccountNumber(String accountNumber) {
//		this.accountNumber = accountNumber;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Integer getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Integer interestRate) {
		this.interestRate = interestRate;
	}
	
}
