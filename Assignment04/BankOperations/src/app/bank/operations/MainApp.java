package app.bank.operations;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		BankOperations operations = new BankOperations();
		BankAccount account = null;
		while(true) {
			System.out.println("Enter the choice 1. Create Account 2. Deposit Money 3. Withdraw Money 4. Credit Interest");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice){
			case 1:
				System.out.println("Enter the name");
				String name = sc.nextLine();
				System.out.println("Enter the password");
				String password = sc.nextLine();
				System.out.println("Enter the amount ");
				Double balance = Double.parseDouble(sc.nextLine());
				account = operations.createAccount(name, password, balance);
				System.out.println("Your account has been created successfully");
				break;
			case 2:
				System.out.println("Enter the amount to be deposited");
				Double amount = Double.parseDouble(sc.nextLine());
				account = operations.depositMoney(account, amount);
				break;
			case 3:
				System.out.println("Enter your password");
				String enteredPassword = sc.nextLine();
				System.out.println("Enter the amount to be withdrawn");
				Double withdrawlAmount = Double.parseDouble(sc.nextLine());
				account = operations.withdrawMoney(account, withdrawlAmount, enteredPassword);
				break;
			case 4:
				account = operations.creditInterest(account);
				System.out.println("The balance after interest credited is Rs. "+account.getBalance());
				break;
			default:
				System.exit(0);
				break;

			}
		}

	}

}
