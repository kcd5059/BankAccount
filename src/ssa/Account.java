package ssa;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//import ssa.Transaction.TranType;

public class Account {

	Random rnd = new Random();
	
	private int id = rnd.nextInt(1000);
	private String description;
	private double balance = 0;
	//private List<Transaction> transactionHistory = new ArrayList<>();
	
	public Account() {
	}
	
	public Account(double initialBalance) {
		setBalance(initialBalance);
	}
	
	public Account(String description) {
		this.description = description;
	}
	
	public Account(int id, String description) {
		setId(id);
		this.description = description;
	}
		
	public double withdraw(double withdrawalAmount) {
		//Check for and prevent overdraft
		if ((balance - withdrawalAmount) >= 0) {
			//No overdraft detected, perform withdrawal
			balance -= withdrawalAmount;
			//Create new Transaction and add to transactionHistory
			//transactionHistory.add(new Transaction(new Date(), TranType.WITHDRAWAL, -withdrawalAmount));
		} else {
			System.out.println("Insufficient funds!");
		}
		
		return balance;
	}
	
	public double deposit(double depositAmount) {
		//Deposit amount
		balance += depositAmount;
		//Create new Transaction and add to transactionHistory
		//transactionHistory.add(new Transaction(new Date(), TranType.DEPOSIT, depositAmount));
		return balance;
	}
	
	public void transferFrom(Account account, double amount) {
		
		double initialBalance = account.getBalance(); //initial balance of "from" account
		account.withdraw(amount);
		//Check if withdrawal was successful before depositing amount
		if ( (initialBalance - amount) == account.getBalance() ) {
			this.deposit(amount);
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}
	
	private void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String print() {
		DecimalFormat df = new DecimalFormat("0.00");
		return "Account " + id + " balance is $" + df.format(balance);
	}
	
//	public void printTransactionHistory() {
//		System.out.println("Transaction History for Account: " + id + " '" + description + "'");
//		for (Transaction transaction : transactionHistory) {
//			transaction.print();
//		}
//	}
	
}


