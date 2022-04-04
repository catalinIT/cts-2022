package ro.ase.cts.gr1098.design.patterns.models;

public class LoggerType {


    private String fileName;
    private String logPattern;

    private LoggerType(String fileName, String logPattern) {
        this.fileName = fileName;
        this.logPattern = logPattern;
    }

    public String getFileName() {
        return fileName;
    }

    public String getLogPattern() {
        return logPattern;
    }
}
