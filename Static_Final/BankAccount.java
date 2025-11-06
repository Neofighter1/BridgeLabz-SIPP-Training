public class BankAccount {
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;
    private final String accountNumber;
    private String accountHolderName;

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String getBankName() {
        return bankName;
    }

    public void displayAccountDetails(Object obj) {
        if (obj instanceof BankAccount) {
            BankAccount account = (BankAccount) obj;
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + account.accountHolderName);
            System.out.println("Account Number: " + account.accountNumber);
        } else {
            System.out.println("Invalid account object.");
        }
    }
    
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", "A123");
        BankAccount acc2 = new BankAccount("Bob", "B456");
        acc1.displayAccountDetails(acc1);
        System.out.println();
        acc2.displayAccountDetails(acc2);
        System.out.println();
        System.out.println("Total accounts: " + BankAccount.getTotalAccounts());
    }
}
