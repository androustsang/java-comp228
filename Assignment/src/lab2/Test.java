package lab2;

import javax.swing.JOptionPane;
import java.security.SecureRandom;

public class Test {

    // Create a prviate class of Questions, Choices of Answers and Correct Answer.
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

    // Constructor method to initialize with all the questions and answers.
    public Test() {
        this.questionbank = new QnA[3];

        // Question 1
        this.eachquestion = new QnA("Which of the following typically groups related classes so that they could be imported into programs and reused?", new String[]{"Function", "IDE", "Package", "Method"}, 2);
        questionbank[0] = this.eachquestion;

        // Question 2
        this.eachquestion = new QnA("There are variables for which each object of a class does not need its own separate copy. They are called_______________.", new String[]{"local variables", "constants", "class variables", "instance variables"}, 2);
        questionbank[1] = this.eachquestion;

        // Question 3

        // Question 4

        // Question 5

    }

    public void inputAnswer() {

        for (QnA qb: questionbank) {
            if (qb != null){
            //    String name = JOptionPane.showInputDialog(qb.getQuestion());
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
                System.out.println("Choice is "+selectedChoice);
            }
        }

    }




} // End of class Test
