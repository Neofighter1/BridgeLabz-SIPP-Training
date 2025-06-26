package Access_Modifiers;

import java.util.Scanner;
public class BankAccount {
	static Scanner input = new Scanner(System.in);
	
	public int accountNumber;
	protected String accountHolder;
	private static int balance=10000;
	
	BankAccount(int accountNumber,String accountHolder){
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;

	}
	
	public int balanceModify(int code ,int modificationAmount){
		if(code == 1) {//When user withdraw money from his bankAccount
			balance -= modificationAmount;
			return balance;
		}
		else if(code == 2) {//When user deposit money to his bankAccount
			balance += modificationAmount;
			return balance;
		}
		else {//To check or access user's balance 
			return balance;
		}
	}
	
	class SavingAccount{
		BankAccount obj = new BankAccount(12989290,"Anuj Chaturvedi");
		SavingAccount(){
			this.obj.accountNumber = accountNumber;
			this.obj.accountHolder = accountHolder;
		}
		public int updateBalance(int code, int modificationAmount) {
			int res = obj.balanceModify(code,modificationAmount);
			return res;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		//cases for choosing between current and saving account
		//current account is accessed by BankAccount class object
		//Saving account is accessed by SavingAccount class object
		System.out.println("Enter current for Current Account And saving for Saving Account:");
		String typeOfAccount = input.next();
		typeOfAccount = typeOfAccount.toLowerCase();
		switch (typeOfAccount) {
		case "current":
			BankAccount obj = new BankAccount(12899883,"Hemant kaushik");
			System.out.print("Do you want to Deposit or Withdraw from your Account (y/N) :");
			char choice = input.next().toLowerCase().charAt(0);
			if(choice == 'y') {
				System.out.print("Enter 1 for withdraw And Enter 2 for Deposit:");
				int code = input.nextInt();
				System.out.print("Amount:");//deposit or withdraw amount
				int amount = input.nextInt();
				int balance = obj.balanceModify(code,amount);
				System.out.println("Current balance After updation is "+balance);
			}
			break;
		case "saving":
			BankAccount dObj = new BankAccount(1938813,"xyz");
			SavingAccount sObj = dObj.new SavingAccount();
			System.out.print("Do you want to Deposit or Withdraw from your Account (y/N) :");
			char sChoice = input.next().toLowerCase().charAt(0);
			if(sChoice == 'y') {
				System.out.print("Enter 1 for withdraw And Enter 2 for Deposit:");
				int code = input.nextInt();
				System.out.print("Amount:");//deposit or withdraw amount
				int amount = input.nextInt();
				int balance = sObj.updateBalance(code,amount);
				System.out.println("Current balance After updation is "+ balance);
			}
			break;
		default:
			System.out.println("Invalid Choice");
		}

	}

}