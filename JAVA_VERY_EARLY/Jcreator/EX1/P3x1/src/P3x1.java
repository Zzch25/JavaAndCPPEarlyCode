/**
 * @(#)P3x1.java
 *
 * P3x1 application
 *
 * @author
 * @version 1.00 2011/10/19
 */

public class P3x1 {

    public static void main(String[] args) {
		BankAccount Bob = new BankAccount(25);
		System.out.println("New Bank Account Created");
		Bob.deposit(2500);
		System.out.println("Money Deposited, $2525 balance expected");
		System.out.print("Current Balance: ");
		System.out.println(Bob.getBalance());
		Bob.withdraw(25);
		System.out.println("Money Withdrawn, $2500 balance expected");
		System.out.print("Current Balance: ");
		System.out.println(Bob.getBalance());
		Bob.yearlyinterest(100);
		System.out.println("Interest input, hurray 100% interest!!! Estimated Balance, $5000");
		System.out.print("Current Balance: ");
		System.out.println(Bob.getBalance());
    }
}
