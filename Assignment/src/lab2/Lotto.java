package lab2;

import javax.swing.JOptionPane;
import java.security.SecureRandom;

// Lotto class is for Exercise 2
public class Lotto {

    // create secure random number generator for use in method
    private static final SecureRandom randomNumbers = new SecureRandom();
    // enum type with constants that represent the game status
    private enum Status {CONTINUE, WON, LOST};
    private int[] lottoArray;

        // Constructor methods
    public Lotto() {
        this.lottoArray = new int[3]; // initialize the array of 3 integers for a lotto object

        for (int i = 0; i < 3; i++) { // populate the values into the array
            this.lottoArray[i] = 1 + randomNumbers.nextInt(9);
        }
    }

    public int[] getLottoArray(){
            return this.lottoArray;
    }

    // Run the game
    public static void main(String[] args) {
        Object[] userOptions = {3,4,5,6,7,8,9,10,
                11,12,13,14,15,16,17,18,19,20,
                21,22,23,24,25,26,27}; //Allowed choices for user


        for (int i = 0; i < 5; i++) {   // Runs the lotto up to 5 times
            Lotto gameLotto = new Lotto();  // Get a new lotto each time

            int[] gameLottoArray = gamelotto.getLottoArray();
            for (int j = 0; j < lottosum.length; j++) {

            }

            Object userSelection = JOptionPane.showInputDialog(null,
                    "Please choose between 3 and 27",
                    "Lotto Game",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    userOptions,
                    userOptions[0]);
            if (userSelection != null) {
                System.out.println("User selection " + (int) userSelection);

            }


        }
    }


}
