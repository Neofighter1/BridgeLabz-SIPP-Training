class BankAccount{
	String accountNumber;
	int balance;
	BankAccount(String accountNumber , int balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
}

class SavingAccount extends BankAccount{
	double intrestRate;
	SavingAccount(String accountNumber , int balance,double intrestRate){
		super(accountNumber, balance);
		this.intrestRate = intrestRate;
	}
	void displayAccountType() {
		System.out.println("AccountType : SavingAccount");
	}
}

class CheckingAccount extends BankAccount{
	int withdrawalLimit;
	CheckingAccount(String accountNumber , int balance,int withdrawalLimit){
		super(accountNumber,balance);
		this.withdrawalLimit = withdrawalLimit;
	}
	void displayAccountType() {
		System.out.println("AccountType : CheckingAccount");
	}
}

class FixedDepositAccount extends BankAccount{
	FixedDepositAccount(String accountNumber,int balance){
		super(accountNumber,balance);
	}
	void displayAccountType() {
		System.out.println("AccountType : FixedDepositAccount");
	}
}

public class BankAccountTypes {
	public static void main(String[] args) {
		SavingAccount obj1 = new SavingAccount("1232SBI233",10000,7.5);
		CheckingAccount obj2 = new CheckingAccount("1232SBI233",10000,5000);
		FixedDepositAccount obj3 = new FixedDepositAccount("1232SBI233",10000);
		obj1.displayAccountType();
		obj2.displayAccountType();
		obj3.displayAccountType();
	}
}