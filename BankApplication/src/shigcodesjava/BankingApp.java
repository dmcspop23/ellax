package shigcodesjava;

import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {
		BankAccount obj = new BankAccount("Shigcodes", "SC0001");
		obj.showMenu();
	}

}

class BankAccount { 
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	public BankAccount(String cname, String cid) {
		customerName = cname;
		customerID = cid;
	}
	
	void deposit(int amount) {
		if(amount !=0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount !=0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdraw: " +Math.abs(previousTransaction));
		}
		else {
			System.out.println("No Transaction Occured");
		}
	}
	
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome " + customerName);
		System.out.println("Your ID is " + customerID);
		System.out.println("\n");
		
		
		do {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Enter Your Option:");
			System.out.println("A : Check Your Balance");
			System.out.println("B : Deposit");
			System.out.println("C : Withdraw");
			System.out.println("D : Previous Transaction");
			System.out.println("E : Exit");
			System.out.println("--------------------------------------------------------------------");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch (option) {
			
			case 'A':
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Balance = " +balance);
			System.out.println("--------------------------------------------------------------------");
			System.out.println("\n");
			
			case 'B':
				System.out.println("--------------------------------------------------------------------");
				System.out.println("Enter an amount to deposit");
				System.out.println("--------------------------------------------------------------------");
				System.out.println("\n");
				
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("--------------------------------------------------------------------");
				System.out.println("Enter an amount to withdraw");
				System.out.println("--------------------------------------------------------------------");
				System.out.println("\n");
				
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("--------------------------------------------------------------------");
				getPreviousTransaction();
				System.out.println("--------------------------------------------------------------------");
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("--------------------------------------------------------------------");
				break;
			
			default:
				System.out.println("Invalid Option! Please Enter Correct Option");
				break;
			}
		}
		while(option != 'E');
		System.out.println("Thank you for using!");
	}
}
