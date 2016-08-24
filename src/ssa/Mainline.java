package ssa;

public class Mainline {

	public static void main(String[] args) {

		Savings savings = new Savings(1);
		savings.setInterestRate(.05);
		System.out.println(savings.print());
		System.out.println("Depositing " + savings.calcDepositInterest(12));
		System.out.println(savings.print());

	}

}
