public class Account {
// The Account class to implement the withdrawal and deposit operations

    private double balance;

    // Constructor to set the initial balance
    public Account(double balance) {
        this.balance = balance;
    }

    // With the method synchronized, the lock is at the object level so both
    // deposit and withdraw methods are thread-safe

    // Using synchronized to ensure the update by deposit is thread safe
    public synchronized void deposit(double amount) {
        // Using print statement to show that the operation is in progress
        System.out.println("Deposit " + amount + " to account " + this);
        System.out.println("Balance Before Deposit: " + balance);
        this.balance += amount;
        System.out.println("Balance After Deposit: " + balance);
    }

    // Using synchronized to ensure the update by withdraw is thread safe
    public synchronized void withdraw(double amount) {
        // Using print statement to show that the operation is in progress
        System.out.println("Withdraw " + amount + " from account " + this);
        System.out.println("Balance Before Withdraw: " + balance);
        this.balance -= amount;
        System.out.println("Balance After Withdraw: " + balance);
    }

    public double getBalance() {
        return balance;
    }

}
