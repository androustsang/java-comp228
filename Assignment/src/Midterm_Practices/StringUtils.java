package Midterm_Practices;

import java.lang.String;
import java.util.Scanner;

public class StringUtils {

    public static boolean isPalindromeString(String s) {

        String s_reversed = new StringBuffer(s).reverse().toString();
//        String s_reversed = reverse(s)
        return (s_reversed.equals(s));
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
//        char[] s1 = s.toCharArray();
//        char[] s2 = new char[s1.length];
//
//        for (int i = 0; i < s1.length; i++) {
//            s2[i] = s1[s1.length - 1 - i];
//        }
//        return new String(s2);

    }

    public static void main(String[] args) {
        System.out.printf("Enter a string: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        if (isPalindromeString(s)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        System.out.printf("Reversed string: %s\n", reverse(s));
    }
}
