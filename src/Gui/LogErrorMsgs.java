package Gui;

import Utils.UtilsDateTime;

import java.util.Date;
/**
 * @author Daniel Wassmer
 */
public class LogErrorMsgs {
    private String type = "LogMsg";
    private String message;
    private String source;
    private String time;
    private String severity;

    public LogErrorMsgs(String message, String source, Date time, LogErrorMsgsEnum.severity severity) {
        setMessage(message);
        setSource(source);
        setTime(time);
        setSeverity(severity);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTime(Date time) {
        this.time = UtilsDateTime.getDateString(time);
    }

    public void setSeverity(LogErrorMsgsEnum.severity severity) {
        this.severity = severity.toString();
    }

    public String getMessage() {
        return message;
    }

    public String getSource() {
        return source;
    }

    public String getTime() {
        return time;
    }

    public String getSeverity() {
        return severity;
    }
}
