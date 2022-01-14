package Gui;

import Utils.UtilsDateTime;

import java.util.Date;
/**
 * @author Daniel Wassmer
 */
public class ServicePanelAnswer {
    private String type = "ServPaAns";
    private String answer;
    private String time;

    public ServicePanelAnswer(String answer, Date time) {
        setAnswer(answer);
        setTime(time);
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setTime(Date time) {
        this.time = UtilsDateTime.getDateString(time);
    }

    public String getAnswer() {
        return answer;
    }

    public String getTime() {
        return time;
    }
}
