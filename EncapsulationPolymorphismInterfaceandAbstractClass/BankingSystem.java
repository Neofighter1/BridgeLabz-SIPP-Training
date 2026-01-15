import java.util.*;

// Interface
interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}


abstract class BankAccounts implements Loanable {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccounts(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Abstract method
    public abstract double calculateInterest();

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited to " + accountNumber);
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn from " + accountNumber);
        } else {
            System.out.println("Insufficient balance in " + accountNumber);
        }
    }


    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
        System.out.println("Loan Eligibility: " + calculateLoanEligibility());
        System.out.println("------------------------------------");
    }

    // Encapsulation 
    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }
}


class SavingsAccount extends BankAccounts {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; 
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5;
    }

    @Override
    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }
}


class CurrentAccount extends BankAccounts {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02; 
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 3;
    }

    @Override
    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }
}


public class BankingSystem {
    public static void main(String[] args) {
        // Create accounts
        BankAccounts acc1 = new SavingsAccount("SB1001", "Anuj", 20000.0);
        BankAccounts acc2 = new CurrentAccount("SB2001", "Madhav", 50000.0);

        // Polymorphism
        List<BankAccounts> accountList = new ArrayList<>();
        accountList.add(acc1);
        accountList.add(acc2);

        
        System.out.println("Bank Account Details \n");
        for (BankAccounts acc : accountList) {
            acc.displayDetails();
        }

       
        System.out.println("\nLoan Application Status ");
        for (BankAccounts acc : accountList) {
            boolean approved = acc.applyForLoan(30000);
            System.out.println(acc.getHolderName() + " Loan 30000 Approved " + approved);
        }
    }
}
