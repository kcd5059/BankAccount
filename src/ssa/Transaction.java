package ssa;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Transaction {

	private final Random rnd = new Random();

	int transactionID = rnd.nextInt(1000000);
	final Date date;
	final TranType type;
	float balanceChange = 0f;
	String note = "";

	public Transaction(Date date, TranType type, float balanceChange) {
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
		DecimalFormat df = new DecimalFormat("#.00");
		
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(balanceChange);
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + transactionID;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Float.floatToIntBits(balanceChange) != Float.floatToIntBits(other.balanceChange))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (transactionID != other.transactionID)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
