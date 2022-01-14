package Gui;
/**
 * @author Daniel Wassmer
 */
public class ServicePanelReq {
    private String type = "ServPReq";
    private String request;

    public ServicePanelReq(String request) {
        this.request = request;
    }

    public String getRequest() {
        return request;
    }
}
