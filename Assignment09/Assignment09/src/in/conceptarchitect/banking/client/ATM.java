package in.conceptarchitect.banking.client;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.utils.Input;

public class ATM {
	
	
	Bank bank ;
	Input keyboard=new Input();
	private int accountNumber;
	
	public void connectTo(Bank bank) {
		this.bank=bank;
	}
	
	
	public void start() {
		displayWelcomeScreen();		
	}


	private void displayWelcomeScreen() {
		while(true) {
			accountNumber=keyboard.readInt("accountNumber?");
			if(accountNumber==-999) {		//hidden admin menu
				if(keyboard.readString("error:").equals("NIMDA"))
					if(displayAdminMenu().equals("QUIT"))
						return;
			}else
				displayUserMenu();
		
		}
	}


	private void displayUserMenu() {
		System.out.println("Welcome "+accountNumber);
		
		int choice;
		do {
			choice=keyboard.readInt("1. Deposit  2. Widthraw  3. Transfer  4. Show 5. Close Account  0. Exit: ");
			switch(choice) {
			case 1:
				doDeposit(); break;
			case 2:
				doWithdraw(); break;
			case 3:
				doTransfer(); break;
			case 4:
				doShow(); break;
			case 5:
				doCloseAccount(); break;
			case 0: break;
			default:
				System.out.println("invalid input. retry");
				
			}
			System.out.println();
		}while(choice==0);
		
		
	}


	private void doCloseAccount() {
		// TODO Auto-generated method stub
		String password = keyboard.readString("Enter password");
		if(bank.close(accountNumber, password)) {
			System.out.println("Your account has been closed successfully");
		}else {
			System.out.println("Not able to close the account");
		}
		
	}


	private void doShow() {
		bank.show(accountNumber);
	}


	private void doTransfer() {
		// TODO Auto-generated method stub
		int targetAccountNumber = keyboard.readInt("Enter the account number for tranfer");
		int amount = keyboard.readInt("Enter the amount to be transferred");
		String password = keyboard.readString("Enter your password");
		if(bank.transfer(accountNumber, amount, password, targetAccountNumber)) {
			System.out.println("Your amount has been transferred successfully and the balance is "+bank.getBalance(accountNumber));
		}else {
			System.out.println("Please try again");
		}
	}


	private void doWithdraw() {
		// TODO Auto-generated method stub
		int amount = keyboard.readInt("Enter the amount to be withdrawn");
		String password = keyboard.readString("Enter your password");
		if(bank.withdraw(accountNumber, amount, password)) {
			System.out.println("Please collect your cash and the balance is "+bank.getBalance(accountNumber));
		}else {
			System.out.println("Please try again");
		}
	}


	private void doDeposit() {
		int amount = keyboard.readInt("Enter the amount to be deposited");
		if(bank.deposit(accountNumber, amount)) {
			System.out.println("Your amount has been deposited successfully and the balance is "+bank.getBalance(accountNumber));
		}else {
			System.out.println("Please try again");
		}
	}


	private String displayAdminMenu() {
		int choice;
		do {
			choice=keyboard.readInt("1. Open Account  2. Credit Interest  3. Print Accounts  4. Shutdown  0. Exit: ");
			switch(choice) {
			case 1:
				doOpenAccount(); break;
			case 2:
				doCreditInterest(); break;
			case 3:
				doPrintAccounts(); break;
			case 4:
				return "QUIT";
			case 0: break;
			default:
				System.out.println("invalid input. retry");
				break;
			}
			System.out.println();
		}while(choice==0);
		return "";
	}


	private void doPrintAccounts() {
		bank.printAccountList();
	}


	private void doCreditInterest() {
		bank.creditInterests();
	}


	private void doOpenAccount() {
		String name = keyboard.readString("Name ?");
		String password = keyboard.readString("Password ?");
		String renteredPass = keyboard.readString("Re Enter Password ?");
		if(password.equals(renteredPass)) {
			Double amount = Double.parseDouble(keyboard.readString("Amount ?"));
			int accNumber = bank.openAccount(name, password, amount);
			System.out.println("Account has been created successfully for "+name+" with account number "+accNumber);
		}else {
			System.out.println("Reentered password does not match, try again");
		}
	}	
	
	
	
	
	
}
