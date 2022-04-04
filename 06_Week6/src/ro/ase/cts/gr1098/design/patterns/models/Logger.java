package ro.ase.cts.gr1098.design.patterns.models;

import ro.ase.cts.gr1098.design.patterns.exceptions.MissingArgException;
import ro.ase.cts.gr1098.design.patterns.interfaces.ILogging;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger implements ILogging {

    private static Logger logger;

    private String filename;
    // making this attribute optional
    private String messagePattern;
    private File logFile;

    private Logger(String filename, String messagePattern) throws MissingArgException, IOException {

        if(filename == null || filename.length() < 4)
        {
            throw new MissingArgException();
        }

        this.filename = filename;
        this.messagePattern = messagePattern != null ? messagePattern : "";

        this.logFile = new File(this.filename);
        if(this.logFile.exists()) {
            this.logFile.createNewFile();
        }
    }

    @Override
    public void log(String msg)  {
        String log = String.format("%s (%s) - %s",
                this.messagePattern,
                LocalDateTime.now().toString(),
                msg);

        try {
            FileWriter fileWriter = new FileWriter(logFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(log);
            fileWriter.close();
        } catch (IOException ex) {

        }
    }

    public static ILogging getInstance(String filename, String messagePatterns) throws MissingArgException, IOException {
        if(logger == null) {
            logger = new Logger(filename, messagePatterns);
        }

        return logger;
    }
}
