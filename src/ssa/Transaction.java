package ssa;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Transaction {

	private final Random rnd = new Random();

	private int transactionID = rnd.nextInt(1000000);
	private Date date;
	private TranType type;
	private double balanceChange = 0f;
	private String note = "";

	public Transaction(Date date, TranType type, double balanceChange) {
		this.date = date;
		this.type = type;
		this.balanceChange = balanceChange;
	}

	public enum TranType {
		WITHDRAWAL, DEPOSIT, TRANSFER;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public void setBalanceChange(float balanceChange) {
		this.balanceChange = balanceChange;
	}

	public void print() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");
		String formattedDate = sdf.format(date);
		DecimalFormat df = new DecimalFormat("0.00");
		
		//Add leading zeroes to transaction ID to create consistency in output format
		String formattedID = transactionID + "";
		while (formattedID.length() < 6) {
			formattedID = "0" + formattedID;
		}

		//Print output based on TranType (for consistency in alignment)
		if (type.equals(TranType.DEPOSIT)) {
			System.out.println("Trans ID          Date/Time              Type      Amount            Note");
			System.out.println(
					formattedID + "   " + formattedDate + "     " + type + "    " + df.format(balanceChange) + "     " + note);
		} else if (type.equals(TranType.WITHDRAWAL)) {
			System.out.println("Trans ID          Date/Time              Type      Amount            Note");
			System.out.println(
					formattedID + "   " + formattedDate + "   " + type + "   " + df.format(balanceChange) + "     " + note);
		} else {
			System.out.println("Trans ID          Date/Time              Type      Amount            Note");
			System.out.println(
					formattedID + "   " + formattedDate + "    " + type + "    " + df.format(balanceChange) + "     " + note);
		}

	}
}
