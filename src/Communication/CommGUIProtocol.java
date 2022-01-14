package Communication;

import Gui.*;
/**
 * @author Daniel Wassmer
 */
public interface CommGUIProtocol {
    /**
     * Connects to the gui
     */
    void connect();

    /**
     * Disconnects from the gui
     */
    void disconnect();

    /**
     * Sends the traveller request reset to the gui
     * @param travellerReqReset traveller request reset that should be sent
     */
    void sendTravellerReqReset(TravellerReqReset travellerReqReset);

    /**
     * Sends the service panel answer to the gui
     * @param servicePanelAnswer service panel answer that sould be sent
     */
    void sendServicePanelAnswer(ServicePanelAnswer servicePanelAnswer);

    /**
     * Sends the service state to the gui
     * @param serviceState service state that should be sent
     */
    void sendServiceState(ServiceState serviceState);

    /**
     * Sends the current level to the gui
     * @param currentLevel current level that should be sent
     */
    void sendCurrentLevel(CurrentLevel currentLevel);

    /**
     * Sends the direction indication to the gui
     * @param directionIndication direction indication that should be sent
     */
    void sendDirectionIndication(DirectionIndication directionIndication);

    /**
     * Sends the door state to the gui
     * @param doorState door state that should be sent
     */
    void sendDoorState(DoorState doorState);

    /**
     * Sends the error msgs to the gui
     * @param logErrorMsgs error message that should be sent
     */
    void sendLogErrorMsgs(LogErrorMsgs logErrorMsgs);
}
