package ssa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ssa.Transaction.TranType;

import java.util.Date;

public class Account {

	Random rnd = new Random();
	
	private final int accountID = rnd.nextInt(1000);
	private String description;
	private float balance = 0.0f;
	private List<Transaction> transactionHistory = new ArrayList<>();
	
	public Account() {
		
	}
	
	public Account(float initialBalance) {
		balance = initialBalance;
	}
	
	public void printBalance() {
		System.out.printf("The current balance is %.2f.\n", balance);
	}
	
	public float withdraw(float withdrawalAmount) {
		if ((balance - withdrawalAmount) >= 0) {
			balance -= withdrawalAmount;
			Transaction transaction = new Transaction(new Date(), TranType.WITHDRAWAL, -withdrawalAmount);
			transactionHistory.add(transaction);
			System.out.printf("Withdrew %.2f. ", withdrawalAmount);
			System.out.printf("Transaction ID: %d.\n", transaction.getTransactionID());
		} else {
			System.out.println("Insufficient funds!");
			printBalance();
		}
		
		return balance;
	}
	
	public float deposit(float depositAmount) {
		balance += depositAmount;
		Transaction transaction = new Transaction(new Date(), TranType.DEPOSIT, depositAmount);
		transactionHistory.add(transaction);
		System.out.printf("Deposited %.2f. ", depositAmount);
		System.out.printf("Transaction ID: %d.\n", transaction.getTransactionID());
		return balance;
	}
	
	public Account transferTo(float transferAmount, Account destinationAccount) {
		
		if ((balance - transferAmount) >= 0) {
			balance -= transferAmount;
			Transaction transaction = new Transaction(new Date(), TranType.TRANSFER, -transferAmount);
			System.out.printf("Transferred %.2f. ", transferAmount);
			System.out.printf("Transaction ID: %d.\n", transaction.getTransactionID());
			transaction.setNote("Transfer to AcctID: " + destinationAccount.accountID);
			destinationAccount.transferFrom(transferAmount, accountID);
			transactionHistory.add(transaction);
		} else {
			System.out.println("Insufficient funds!");
			printBalance();
		}
		
		return destinationAccount;
	}
	
	private void transferFrom(float transferAmount, int originAccountID) {
		balance += transferAmount;
		
		Transaction transaction = new Transaction(new Date(), TranType.TRANSFER, transferAmount);
		System.out.printf("Transferred %.2f. ", transferAmount);
		System.out.printf("Transaction ID: %d.\n", transaction.getTransactionID());
		transaction.setNote("Transfer From AcctID: " + originAccountID);
		transactionHistory.add(transaction);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAccountID() {
		return accountID;
	}
	
//	public void setAccountID(int accountID) {
//		this.accountID = accountID;
//	}

	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public void printTransactionHistory() {
		System.out.println("Transaction History for Account: " + accountID);
		for (Transaction transaction : transactionHistory) {
			transaction.print();
		}
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + "]";
	}
	
	
}


