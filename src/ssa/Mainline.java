package ssa;

public class Mainline {

	public static void main(String[] args) {

		Savings savings = new Savings(.50);
		System.out.println(savings.print());
		System.out.println("Depositing " + savings.calcDepositInterest(4));
		System.out.println(savings.print());

	}

}
