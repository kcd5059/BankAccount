package ssa;

public class Mainline {

	public static void main(String[] args) {

		Account savings = new Account();
		Account checking = new Account();
		
		/*
		 * CHECKING STEPS
		 */
		System.out.println("--------CHECKING--------");
		//checking.setAccountID(100); <-- Set to generate random ID which is also final, so this will not run
		//Set description
		checking.setDescription("My personal checking account");
		//Set initial balance
		checking.setBalance(500f);
		// Print details of checking account
		System.out.println("Account ID: " + checking.getAccountID() + "\n" + 
		"Description: " + checking.getDescription());
		checking.printBalance();
		//Deposit 200 and print balance
		System.out.printf("The new balance is: %.2f.\n", checking.deposit(200f));
		//Withdraw 600 and print new balance
		System.out.printf("The new balance is: %.2f.\n", checking.withdraw(600f));
		//Deposit 100 and print balance
		System.out.printf("The new balance is: %.2f.\n", checking.deposit(100f));
		//Try to withdraw 300, but fail
		checking.withdraw(300f);
		//Withdraw 200 and print new balance
		System.out.printf("The new balance is: %.2f.\n", checking.withdraw(200f));
		System.out.println("");
		
		/*
		 * SAVINGS STEPS
		 */
		System.out.println("--------SAVINGS--------");
		//savings.setAccountID(200); <-- will not run
		//Set description
		savings.setDescription("My personal savings account");
		savings.setBalance(1000f);
		// Print details of savings account
		System.out.println("Account ID: " + savings.getAccountID() + "\n" + 
		"Description: " + savings.getDescription());
		savings.printBalance();
		//Withdraw 750 and print balance
		System.out.printf("The new balance is: %.2f.\n", savings.withdraw(750f));
		//Withdraw 250 and print balance
		System.out.printf("The new balance is: %.2f.\n", savings.withdraw(250f));
		//Deposit 200 and print balance
		System.out.printf("The new balance is: %.2f.\n", savings.deposit(200f));
		System.out.println("");
		
		System.out.println("--------BOTH ACCOUNTS--------");
		//Print details of both accounts:
		System.out.println("Account ID: " + checking.getAccountID() + "\n" + 
		"Description: " + checking.getDescription());
		checking.printBalance();
		System.out.println("");
		System.out.println("Account ID: " + savings.getAccountID() + "\n" + 
		"Description: " + savings.getDescription());
		savings.printBalance();
		System.out.println("");
		
		
		/*
		 * ADVANCED STEPS
		 */
		System.out.println("--------ADVANCED--------");
		//Transfer 100 from savings to checking
		checking = savings.transferTo(100f, checking);
		System.out.print("Savings: ");
		savings.printBalance();
		System.out.print("Checking: ");
		checking.printBalance();
		
		/*
		 * PRO STEPS
		 */
		 //Print Transaction Histories
		checking.printTransactionHistory();
		savings.printTransactionHistory();
		
	}

}
