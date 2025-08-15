package logger_design;


// Chain of Responsibility Design Pattern.


public class Main {

    public static void main(String[] args) {

        LogProcessor logObject = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logObject.log(LogProcessor.INFO, "info");
        logObject.log(LogProcessor.ERROR, "error");
        logObject.log(LogProcessor.DEBUG, "debug");

    }

}
