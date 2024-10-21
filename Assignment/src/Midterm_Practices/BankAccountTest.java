package Midterm_Practices;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("John");

        bankAccount.deposit(500.0);
        bankAccount.withdraw(200.0);
    }
}
