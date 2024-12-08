import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AccountTest {
    public static void main(String[] args) {
        // Create a thread pool of 2
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        // Create an ArrayList to hold all transaction objects
        int numOfTransactions = 3;
        ArrayList<Transaction> transArrayList = new ArrayList<Transaction>(numOfTransactions);

        // Create the Account object to prepare for the transaction
        Account account = new Account(1000);

        // Create all the transaction objects and store in the ArrayList
        for (int i = 0; i < numOfTransactions; i++) {
            transArrayList.add(new Transaction("Thread_" + i, account));
        }

        System.out.println("Initial Account Balance: " + account.getBalance());
        System.out.println();
        // Now put all the transactions into the threads
        for (Transaction transaction : transArrayList) {
            System.out.println("Created Thread: " + transaction.getThreadName());
            executor.execute(transaction);
        }

        executor.shutdown();
    }
}
