package Gui;
/**
 * @author Daniel Wassmer
 */
public class TravellerReq {
    private String type = "TravReq";
    private String location;
    private String request;

    public TravellerReq(String location, String request) {
        this.location = location;
        this.request = request;
    }

    public TravellerReqEnum.location getLocation() {
        return TravellerReqEnum.location.get(location);
    }

    public String getRequest() {
        return request;
    }
}
