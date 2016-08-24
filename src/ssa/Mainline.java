package ssa;

public class Mainline {

	public static void main(String[] args) {

		Savings savings = new Savings(500);
		savings.setInterestRate(1.5);
		savings.setMinimumBalance(100);
		System.out.println(savings.print());
		savings.calcDepositInterest(4);
		System.out.println(savings.print());
		savings.calcDepositInterest(4);
		System.out.println(savings.print());
		

	}

}
