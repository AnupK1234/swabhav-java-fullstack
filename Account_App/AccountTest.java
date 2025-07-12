package acc_app;

import java.util.Scanner;

public class AccountTest {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Account acc = new Account(1, "Anup", "Badlapur", 100000, 1234567890l);
		boolean operationRequired = true;

		while (operationRequired) {
			System.out.println("Enter the operation ->\n1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				System.out.println("How much amount to withdraw?");
				int withdrawAmt = sc.nextInt();
				double currBalance = acc.getBalance();
				if (currBalance < withdrawAmt) {
					throw new CustomExceptions.InsufficientFundsException("INSUFFIENT BALANCE!!!");
				} else {
					acc.setBalance(acc.getBalance() - Math.abs(withdrawAmt));
					System.out.println("Amount withdrawn success");
				}
				break;

			case 2:
				System.out.println("How much amount to deposit?");
				int depositAmt = sc.nextInt();
				if (depositAmt < 1) {
					throw new CustomExceptions.NegativeAmountException(
							"Amount should be greater than 0 and Non-negative");
				}
				acc.setBalance(acc.getBalance() + depositAmt);
				System.out.println("Amount Deposit success");
				break;

			case 3:
				System.out.println("Your account Balance is : " + acc.getBalance());
				break;

			case 4:
				operationRequired = false;
				break;
			}

			if (operationRequired == false)
				break;

		}

		sc.close();

	}

}
