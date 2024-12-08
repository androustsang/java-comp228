
public class Transaction implements Runnable {

    private String threadName;
    private Account account;

    public Transaction(String threadName, Account account) {
        this.threadName = threadName;
        this.account = account;
    }

    @Override
    public void run() {
        // Performing deposit and withdraw operations to the Account object in the try-catch block

        System.out.println(String.format("%s begin ALL transaction operations%n", threadName));
        try {
            for (int i = 0; i < 3; i++) {   // Loop for 3 times
                this.operations();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s finish ALL transaction operations%n", threadName));


    }

    private void operations() throws InterruptedException {
        // Operations of one deposit and one withdraw of 100 each
        // Print statement to show the thread operation before and after
        System.out.println(String.format("%s start transaction deposit%n", threadName));
        account.deposit(100);
        System.out.println(String.format("%s complete transaction deposit%n", threadName));

        Thread.sleep(1000);  // To pause for a while

        System.out.println(String.format("%s start transaction withdraw%n", threadName));
        account.withdraw(100);
        System.out.println(String.format("%s complete transaction withdraw%n", threadName));

        Thread.sleep(1000);  // To pause for a while
    }

    public String getThreadName() {
        return threadName;
    }
}
