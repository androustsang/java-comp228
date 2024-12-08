public class Account {
// The Account class to implement the withdrawal and deposit operations

    private double balance;
    // ANSI escape codes for colors
    String red = "\u001B[31m";
    String green = "\u001B[32m";
    String yellow = "\u001B[33m";
    String reset = "\u001B[0m";

    // Constructor to set the initial balance
    public Account(double balance) {
        this.balance = balance;
    }

    // With the method synchronized, the lock is at the object level so both
    // deposit and withdraw methods are thread-safe

    // Using synchronized to ensure the update by deposit is thread safe
    public synchronized void deposit(double amount) {
        // Using print statement to show that the operation is in progress
        System.out.println(red + "Deposit " + amount + " to account " + this + reset);
        System.out.println(red + "Balance Before Deposit: " + balance + reset);
        this.balance += amount;
        System.out.println(red + "Balance After Deposit: " + balance + reset);
    }

    // Using synchronized to ensure the update by withdraw is thread safe
    public synchronized void withdraw(double amount) {
        // Using print statement to show that the operation is in progress
        System.out.println(green + "Withdraw " + amount + " from account " + this + reset);
        System.out.println(green + "Balance Before Withdraw: " + balance + reset);
        this.balance -= amount;
        System.out.println(green + "Balance After Withdraw: " + balance + reset);
    }

    public double getBalance() {
        return balance;
    }

}
