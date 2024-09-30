package lab2;

import javax.swing.JOptionPane;
import java.security.SecureRandom;

// Lotto class is for Exercise 2
public class Lotto {

    // create secure random number generator for use in method
    private static final SecureRandom randomNumbers = new SecureRandom();

    // enum type with constants that represent the game status
    //WON represent User Win, Lost represent Computer Win
    private enum Status {CONTINUE, USERWON, USERLOST};

    // internal integer array to store the lotto number
    private int[] lottoArray;

        // Constructor methods
    public Lotto() {
        this.lottoArray = new int[3]; // initialize the array of 3 integers for a lotto object

        for (int i = 0; i < 3; i++) { // populate the values into the array
            this.lottoArray[i] = 1 + randomNumbers.nextInt(9); // Each number is bound by 9
        }
    }

    public int[] getLottoArray(){
            return this.lottoArray; // To return the integer array
    }

    // Run the game
    public static void main(String[] args) {
        Object[] userOptions = {3,4,5,6,7,8,9,10,
                11,12,13,14,15,16,17,18,19,20,
                21,22,23,24,25,26,27}; // This integer array stores the allowed choices for user

        Status gameStatus; // Can continue CONTINUE, USERWON, USERLOST

        for (int i = 0; i < 5; i++) {   // Runs the lotto up to 5 times
            Lotto gameLotto = new Lotto();  // Get a new lotto each time
            int[] gameLottoArray = gameLotto.getLottoArray();   // Get the array
            int gameLottoSum = 0;   //initialize for each round to calcuate the Lotto sum

            // For-loop to calcuation the sum of lotto
            for (int j = 0; j < gameLottoArray.length; j++) {
                gameLottoSum += gameLottoArray[j];
            }

            System.out.println("The Lotto Sum is: " + gameLottoSum);

            Object userSelection = JOptionPane.showInputDialog(null,
                    "Please choose between 3 and 27",
                    "Lotto Game",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    userOptions,
                    userOptions[0]);
            if (userSelection != null) { // Check if the user click the Cancel button
                    if ((int) userSelection == gameLottoSum) {
                        gameStatus = Status.USERWON;
                        JOptionPane.showMessageDialog(null, "Congratulation! You win the game!");
                        break;
                    } else {
                        gameStatus = Status.CONTINUE;
                    }
                System.out.println("User selection " + (int) userSelection);
            }
        } // End of for-loop
        gameStatus = Status.USERLOST;

    }



}