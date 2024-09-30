package lab2;

// This class is to perform system logging and return the different types of log messages.
// To demonstrate for static overloaded methods

public class SysLogger {

    // To log down informational messages
    public static String logSysMsg(String normalMsg) {

        return String.format("INFO: %s",normalMsg);

    }

    // To log down warning or error message with LogType being Warning or Error
    public static String logSysMsg(String logType, String problemMsg) {
        ;
        return String.format("%s: %s",logType.toUpperCase(), problemMsg);

    }

    // To log down Debug messages with Debugging level
    public static String logSysMsg(int debugLevel, String logModule, String debugMsg) {

        return String.format("DEBUG %d: Module: %s: %s;",debugLevel, logModule.toUpperCase(), debugMsg);

    }



}
