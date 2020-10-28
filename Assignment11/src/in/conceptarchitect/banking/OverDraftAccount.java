package in.conceptarchitect.banking;

public class OverDraftAccount extends BankAccount {
	
	public static int odLimitRate = 10;
	double highestBalance=0;

	
	public OverDraftAccount(String name, String password, double amount) {
		super(name, password, amount);
		updateOdLimit(getBalance());
		// TODO Auto-generated constructor stub
	}
	
	public double getOdLimit() {
		return highestBalance/odLimitRate;
	}
	
	public double getHighestBalance() {
		return highestBalance;
	}
	
	private void updateOdLimit(double amount) {
		if(amount > highestBalance)
			highestBalance = amount;
	}
	
	
	@Override
	public boolean deposit(double amount) {
		boolean result = super.deposit(amount);
		
		updateOdLimit(getBalance());
		return result;
	}
	
	@Override 
	public void creditInterest(double interestRate) {
		super.creditInterest(interestRate);
		updateOdLimit(getBalance());
	}
	
//	@Override
//	public boolean withdraw(double amount, String password) {
//		if(amount > getBalance()+getOdLimit()) {
//			return false;
//		}else if(amount > getBalance()){
//			double oldBal = getBalance();
//			//super.deposit(getOdLimit());
//			super.withdraw(amount, password);
//			double odCharge = (oldBal - amount)/100;//calculate od charge
//			balance = odCharge + (oldBal - amount);
//			//deposit(odCharge + (oldBal - amount));//calculate new bal after od
//			System.out.println("new Bal"+getBalance());
//			return true;
//		}else {
//			return super.withdraw(amount, password);
//		}
//	}
	
	@Override
	public boolean withdraw(double amount, String password) {
		// TODO Auto-generated method stub
		
		if(!authenticate(password)) {			
			return false;
		}else if(amount<=0) {
			
			return false;
			
		} else if(amount > getBalance()+getOdLimit()) {
			
			return false;
			
		}else if(amount > getBalance()){
			double oldBal = getBalance();
			//super.deposit(getOdLimit());
			//super.withdraw(amount, password);
			double odCharge = (oldBal - amount)/100;//calculate od charge
			balance = odCharge + (oldBal - amount);
			//deposit(odCharge + (oldBal - amount));//calculate new bal after od
			System.out.println("new Bal"+getBalance());
			return true;
		}else {
			
			balance-=amount;
			return true;
			
		}
	}
	
	
	
	

}
