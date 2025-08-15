package logger_design;

public class ErrorLogProcessor extends LogProcessor {

    public ErrorLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(int logLevel, String message) {
        if(logLevel == LogProcessor.ERROR) System.out.println("ERROR: " + message);
        else super.log(logLevel, message);
    }

}
