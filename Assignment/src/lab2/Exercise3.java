package lab2;

// For exercise 3
// Three static overloaded messages are defined in SysLogger class.

public class Exercise3 {

    public static void main(String[] args) {

        System.out.println();

        // First static method to be called
        // Logging normal message
        System.out.println(SysLogger.logSysMsg("System is running normal."));

        // Second static method to be called
        // Loggin warning or error message
        System.out.println(SysLogger.logSysMsg("Warning","System has 5 connections dropped out"));

        // Third static method to be called
        System.out.println(SysLogger.logSysMsg(10,"Network","Network stack is empty"));

    }


}
