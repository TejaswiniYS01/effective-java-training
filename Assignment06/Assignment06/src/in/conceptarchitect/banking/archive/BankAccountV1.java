//package in.conceptarchitect.banking.archive;
//
//public class BankAccountV1 {
//	
//	int accountNumber;
//	String name;
//	String password;
//	double balance;
//	double interestRate;
//	
//	
//	public void createAccount(int accountNumber, String name, String password, double amount, double rate) {
//
//		this.accountNumber=accountNumber;
//		this.name=name;  //this.name is class field, name is argument
//		this.password=password;
//		
//		this.balance=amount; //this is not required as balance has no conflict
//		interestRate=rate;   //this is not required
//	}
//	
//	public void show() {
//		System.out.println("Account Number\t"+this.accountNumber);//this is not required 
//		System.out.println("Name\t"+name); //this is not required
//		System.out.println("Password\t"+password); //this is not required
//		System.out.println("Balance\t"+balance); //this is not required
//		System.out.println("Interest Rate\t"+interestRate); //this is not required
//	}
//	
//	public void deposit() {
//		//TODO: write the deposit logic
//	}
//
//}
