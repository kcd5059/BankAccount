package ssa;

import java.text.DecimalFormat;

public class Savings extends Account {

	private double interestRate = .015;
	private double minimumBalance = 0;
	private double totalInterestPaid = 0;

	public Savings() {
	}

	public Savings(double initialBalance) {
		super(initialBalance);
	}

	public double calcDepositInterest(int months) {

		//Check the minimum balance is met
		if (this.getBalance() >= minimumBalance) {
			// Calculate total interest rate for desired months
			double totalInterest = (this.getInterestRate() / 12) * months;
			// Calculate total amount to be deposited
			double accruedInterest = totalInterest * this.getBalance();
			// Use Account.deposit method to deposit amount into the account
			super.deposit(accruedInterest);
			this.setTotalInterestPaid(this.getTotalInterestPaid() + accruedInterest);
			return accruedInterest;
		} else {
			return 0;
		}
		

		
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		
		//If input is a greater than one, convert to decimal--otherwise take interest rate as is
		if ( (interestRate > 0) && (interestRate < 1) ) {
			this.interestRate = interestRate;
		} else if (interestRate > 0) {
			this.interestRate = interestRate / 100;
		}
		
	}
	
	

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public double getTotalInterestPaid() {
		return totalInterestPaid;
	}

	public void setTotalInterestPaid(double totalInterestPaid) {
		this.totalInterestPaid = totalInterestPaid;
	}

	public String print() {
		DecimalFormat df = new DecimalFormat("0.00");
		return super.print() + " (" + this.getInterestRate() * 100 + "% interest rate) Total to date: $" + df.format(this.getTotalInterestPaid());
	}
}
