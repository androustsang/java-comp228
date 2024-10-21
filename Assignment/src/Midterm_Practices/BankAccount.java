package Midterm_Practices;

public class BankAccount {
    private String accountHolderName;
    private double balance;


    public BankAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit (double depositAmount) {
        this.balance += depositAmount;
        System.out.printf("Deposit: %.1f%n", depositAmount);
        System.out.printf("Current Balance: %.1f%n", this.getBalance());

    }

    public void withdraw (double withdrawAmount) {
        if (this.balance >= withdrawAmount) {
        this.balance -= withdrawAmount;
        System.out.printf("Withdraw: %.1f%n", withdrawAmount);
        System.out.printf("Current Balance: %.1f%n", this.getBalance());
        } else {
            System.out.println("Insufficient Funds");
        }
    }
}
