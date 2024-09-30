package lab2;

import javax.swing.JOptionPane;
import java.security.SecureRandom;

public class Test {

    // Create a prviate class of Questions, Choices of Answers and Correct Answer.
    // Getters methods are also implemented.
    private class QnA {
        private String question; // Question
        private String[] choices; // Choices of answers
        private int answer; // Index to the correct answer of the choices array

        //Constructor for creating each question along with answer
        public QnA(String question, String[] choices, int answer) {

            this.question = question; // The question itself
            this.choices = choices; // The String array of choices
            this.answer = answer; // The index of correct answer in the choices array
        }

        // Getter function to return the question
        public String getQuestion() {
            return this.question;
        }

        // Getter function to return the  choices
        public String[] getChoices() {
            return this.choices;
        }

        // Getter function to return the correct answer as the index to the choices array
        public int getAnswer() {
            return this.answer;
        }

    } // end of class QnA

    private QnA[] questionbank;
    private QnA eachquestion;
/*    private String[] correctmsg;
    private String[] incorrectmsg; */   // Originally two arrays are used to store the response. But it's not used after using switch statement.
    private SecureRandom randomNumbers ;// randomNumbers object will produce secure random numbers
    private int numCorrectAns; // store the total number of questions correctly answered

    // Constructor method to initialize all required .
    public Test () {
        simulateQuestion(); // Store the questions and answers into an array

        // Originally initialize the responses to store in these two string arrays.
        /*
        this.correctmsg = new String[]{"Excellent!","Good!","Keep up the good work!", "Nice work!"}; // Store the list of responses to correct answers
        this.incorrectmsg = new String[]{"No. Please try again","Wrong. Try once more","Don't give up!","No. Keep trying."}; // Store the list of responses to incorrect answers.
        */

        this.randomNumbers = new SecureRandom(); // For random number generation

    }

    // method to simulate and store all the questions and answers
    public void simulateQuestion() {

        this.questionbank = new QnA[5];

        // Question 1
        this.eachquestion = new QnA("Which of the following typically groups related classes so that they could be imported into programs and reused?", new String[]{"Function", "IDE", "Package", "Method"}, 2);
        questionbank[0] = this.eachquestion;

        // Question 2
        this.eachquestion = new QnA("There are variables for which each object of a class does not need its own separate copy. They are called_______________.", new String[]{"local variables", "constants", "class variables", "instance variables"}, 2);
        questionbank[1] = this.eachquestion;

        // Question 3
        this.eachquestion = new QnA("Which of the following Java program units defines a group of related objects?", new String[]{"Java", "Java Class", "Java default constructor", "Java method"}, 1);
        questionbank[2] = this.eachquestion;

        // Question 4
        this.eachquestion = new QnA("What does an instance variable describe?", new String[]{"Measurement of an object", "Height of an object.", "Properties of an object", "Behaviour of an object"}, 2);
        questionbank[3] = this.eachquestion;

        // Question 5
        this.eachquestion = new QnA("How many significant digits does a double precision number have?", new String[]{"16", "15", "8", "5"}, 1);
        questionbank[4] = this.eachquestion;
    }

    public String generateMessage(boolean type){
        int response = randomNumbers.nextInt(4);

        // Originally use the random number to access the array but changing to switch statement.
        /*
        if (type) {     //type is True means the question is correctly answered
                return correctmsg[response];
        } else {        //type is False means the question is incorrectly answered
                return incorrectmsg[response];
        }
        */

        if (type) {     // response for correct answers
            switch (response) {
                case 0: return "Excellent!" ;
                case 1: return "Good!" ;
                case 2: return "Keep up the good work!" ;
                case 3: return "Nice work!" ;
            }
        } else {        // response for incorrect answers
            switch (response) {
                case 0: return "No. Please try again!" ;
                case 1: return "Wrong. Try once more!" ;
                case 2: return "Don't give up!" ;
                case 3: return "No. Keep trying!" ;
            }
        }
        return "Unexpected Response";
    }

    public boolean checkAnswer(QnA qb, int selectedChoice) {
            if (qb.getAnswer() == selectedChoice) {
                return true;
            } else {
                return false;
            }
    }

    public void inputAnswer() {
        int numCorrectAns = 0; //Default to zero for the number of correctly answered questions
        boolean chkAns = false; //To store the current answer status temporarily

        // Loop through all the questions
        for (QnA qb: questionbank) {
            if (qb != null){
                int selectedChoice = JOptionPane.showOptionDialog(
                        null,
                        qb.getQuestion(), //Question to display
                        "Please make a choice.", //Title
                        JOptionPane.DEFAULT_OPTION, // Option type
                        JOptionPane.QUESTION_MESSAGE, //Message type
                        null, //
                        qb.getChoices(), //List of choices,
                        null // no default choice
                );

                // Display the message back to the user
                // By calling checkAnswer() method first to see if it is answered correctly
                // Then calling generateMesage() method back to the user
                chkAns = checkAnswer(qb, selectedChoice);
                JOptionPane.showMessageDialog(null, generateMessage(chkAns) );

                if (chkAns) { numCorrectAns++;}
                //System.out.println("Choice is "+selectedChoice);
            }
        }

        // After all questions are looped through.
        // Prepare the message and display using JOptionPane
        String msgToUser = String.format("Correctly answered: %d%nIncorrectly answered: %d%nOverall score is: %.2f%%", numCorrectAns, questionbank.length - numCorrectAns, (float) numCorrectAns / questionbank.length * 100.0);

        //System.out.println(msgToUser);
        JOptionPane.showMessageDialog(null, msgToUser );


    }

} // End of class Test
