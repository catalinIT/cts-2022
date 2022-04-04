package ro.ase.cts.gr1098.design.patterns.models;

import ro.ase.cts.gr1098.design.patterns.exceptions.MissingArgException;
import ro.ase.cts.gr1098.design.patterns.interfaces.ILogging;

import java.io.IOException;
import java.util.HashMap;

public class LoggerGenerator {
    private static HashMap<LoggerType, ILogging> loggers;

    public static ILogging getLogger(LoggerType type) throws IOException {
        ILogging logger = loggers.get(type);
        if(logger == null) {
            try {
                logger = Logger.getInstance(type.getFileName(), type.getLogPattern());
                loggers.put(type,logger);
            } catch (MissingArgException e) {
                e.printStackTrace();
            }
        }
        return  logger;
    }
}
