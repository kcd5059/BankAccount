package ssa;

public class Savings extends Account {

	private double interestRate = .015;

	public Savings() {
	}
	
	public Savings(double initialBalance) {
		super(initialBalance);
	}
	
	public double calcDepositInterest(int months) {
		
		//Calculate total interest rate for desired months
		double totalInterest = (getInterestRate() / 12) * months;
		//Calculate total amount to be deposited
		double accruedInterest = totalInterest * this.getBalance();
	    //Use Account.deposit method to deposit amount into the account
		super.deposit(accruedInterest);
		
		return accruedInterest;
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public String print() {
		return super.print() + " (" + getInterestRate() * 100 + "% interest rate)";
	}
}
