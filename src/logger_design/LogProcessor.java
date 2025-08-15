package logger_design;

public abstract class LogProcessor {

    public static int INFO = 1, DEBUG = 2, ERROR = 3;

    LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor logProcessor) {
        this.nextLogProcessor = logProcessor;
    }

    public void log(int logLevel, String message) {
        if(nextLogProcessor != null) {
            nextLogProcessor.log(logLevel, message);
        }
    }

}
