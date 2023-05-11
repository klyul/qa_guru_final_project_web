package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@SuppressWarnings("all")
public class TestLoggerHelper {

    static final Logger logger = LoggerFactory.getLogger(TestLoggerHelper.class);

    static StringBuilder myCustomLog = new StringBuilder();

    public static void logToLoggerAndToCustomLog(String message) {
        logger.info(message);
        myCustomLog.append(message).append("\n");
    }

    public static String logAndPassSystemProperty(String parameter, String defaultValue) {
        String value = System.getProperty(parameter);
        logToLoggerAndToCustomLog("System property " + parameter + ": " + value);
        String result = Objects.isNull(value) ? defaultValue : value;
        logToLoggerAndToCustomLog("Set " + parameter + " value: " + result);
        return result;
    }

    public static String logAndPassNamedString(String name, String parameter) {
        logToLoggerAndToCustomLog("Passed " + name + ": " + parameter + "\n");
        return parameter;
    }

    public static String getCustomLogs() {
        return myCustomLog.toString();
    }

}