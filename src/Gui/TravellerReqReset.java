package Gui;
/**
 * @author Daniel Wassmer
 */
public class TravellerReqReset {
    private String type = "TravReqRes";
    private String reset;

    public TravellerReqReset(TravellerReqResetEnum.reset reset) {
        setReset(reset);
    }

    public void setReset(TravellerReqResetEnum.reset reset) {
        this.reset = reset.toString();
    }

    public String getReset() {
        return reset;
    }
}
