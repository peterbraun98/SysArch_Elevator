package Gui;

import Utils.UtilsDateTime;


import java.util.Date;
/**
 * @author Daniel Wassmer
 */
public class ServiceState {
    private String type = "ServState";
    private String state;
    private String time;

    public ServiceState(ServiceStateEnum.state state, Date time) {
        setState(state);
        setTime(time);
    }

    public void setState(ServiceStateEnum.state state) {
        this.state = state.toString();
    }

    public void setTime(Date time) {
        this.time = UtilsDateTime.getDateString(time);
    }

    public String getState() {
        return state;
    }

    public String getTime() {
        return time;
    }
}
