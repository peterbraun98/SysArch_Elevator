package Communication;

import Gui.*;
/**
 * @author Daniel Wassmer
 */
public interface CommGUICallback {

    /**
     * This function get's called if the gui communication is connected
     */
    void onConnected();

    /**
     * This function get's called if the gui communication is disconnected
     */
    void onDisconnected();

    /**
     * This function get's called if the communication class received a traveller request
     * @param travellerReq traveller request from the gui
     */
    void onTravellerReqReceived(TravellerReq travellerReq);

    /**
     * This function get's called if the communication class received a service panel request
     * @param servicePanelReq service panel request from the gui
     */
    void onServicePanelReq(ServicePanelReq servicePanelReq);
}
