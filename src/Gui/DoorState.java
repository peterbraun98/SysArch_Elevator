package Gui;
/**
 * @author Daniel Wassmer
 */
public class DoorState {
    private String type = "DoorState";
    private String state;

    public DoorState(DoorStateEnum.state state) {
        setState(state);
    }

    public void setState(DoorStateEnum.state state) {
        this.state = state.toString();
    }

    public String getState() {
        return state;
    }
}
