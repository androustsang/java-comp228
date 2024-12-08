import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AccountTest {
    public static void main(String[] args) {
        // Create a thread pool of 2
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);


        // Create an ArrayList to hold all transcation objects
        int numOfTransactions = 3;
        ArrayList<Transcation> transArrayList = new ArrayList<Transcation>(numOfTransactions);

        // Create the Account object to prepare for the transcation
        Account account = new Account(1000);

        // Create all the transcation objects and store in the ArrayList
        for (int i = 0; i < numOfTransactions; i++) {
            transArrayList.add(new Transcation("Thread_" + i, account));
        }

        // Now put all the transcations into the threads
        for (Transcation transcation : transArrayList) {
            System.out.println("Created Thread: " + transcation.getThreadName());
            executor.execute(transcation);
        }

        executor.shutdown();

    }
}
