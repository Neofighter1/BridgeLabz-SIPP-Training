package Level_2;
import java.util.Scanner;

public class BankAccount {

	    String accountHolder;
	    String accountNumber;
	    double balance;

	    BankAccount(String holder, String number, double balance) {
	        this.accountHolder = holder;
	        this.accountNumber = number;
	        this.balance = balance;
	    }

	    void deposit(double amount) {
	        balance += amount;
	        System.out.println("Deposited: " + amount);
	    }

	    void withdraw(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawn: " + amount);
	        } else {
	            System.out.println("Insufficient balance.");
	        }
	    }

	    void displayBalance() {
	        System.out.println("Current Balance: " + balance);
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        System.out.print("Enter account holder name: ");
	        String name = sc.nextLine();
	        System.out.print("Enter account number: ");
	        String accNo = sc.nextLine();
	        System.out.print("Enter initial balance: ");
	        double balance = sc.nextDouble();

	        BankAccount acc = new BankAccount(name, accNo, balance);
	        System.out.print("Enter the amount of deposit: " );
	        acc.deposit(sc.nextInt());
	        System.out.print("Enter the amount of withdraw: " );

	        acc.withdraw(sc.nextInt());
	        acc.displayBalance();
	        sc.close();
	    }
	}

