package Communication;

import Gui.*;
import Utils.UtilsJson;
import org.eclipse.paho.client.mqttv3.*;

import java.nio.charset.StandardCharsets;
/**
 * @author Daniel Wassmer
 */
public class MQTT implements CommGUIProtocol{
    private MqttConnectOptions options;
    //MQTT Callback that get's called when something happens
    private MqttCallbackExtended mqttCallback = new MqttCallbackExtended() {
        @Override
        public void connectComplete(boolean b, String s) {
            try {
                //after connecting to the broker we want to subscribe to the topic
                client.subscribe(mqttTopic);
                //call the Guicallback that the connection is successful
                answerCallback.onConnected();
            }catch (Exception e){

            }
        }

        @Override
        public void connectionLost(Throwable throwable) {
            //call the gui callback that the connection is disconnected
            answerCallback.onDisconnected();
        }

        @Override
        public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
            System.out.println("New Message arrived String is: " + s + " Message is: " + mqttMessage.toString());
            //Grab the message, convert it to the object and call the callback
            parseObjectAndCallCallback(mqttMessage.toString());
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
            //gets called when a message get's delivered
            System.out.println("Delivery Complete. ");
        }
    };

    private MqttClient client;

    private String mqttTopic = "/21WS-SysArch/C2";

    private CommGUICallback answerCallback;

    private String ipAddress = "localhost";


    public MQTT(String ipAddress, CommGUICallback callback) {
        this.answerCallback = callback;
        this.ipAddress = ipAddress;

        try {
            //Configure the MQTT client to connect to localhost and setup the options
            client = new MqttClient(" + ipAddress + :1883", MqttClient.generateClientId(), null);
            options = new MqttConnectOptions();
            options.setUserName("C2");
            options.setPassword("DF7".toCharArray());
            options.setCleanSession(true);
            options.setAutomaticReconnect(true);
            client.setCallback(mqttCallback);
        }catch (Exception e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }


    @Override
    public void connect() {
        try {
            client.connect(options);
        } catch (Exception e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void disconnect() {
        try {
            client.disconnect();
        }catch (Exception e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }

    /**
     * Publishes the String message to the broker
     * @param message content that should be sent to the broker
     */
    private void sendString(String message){
        try {
            client.publish(mqttTopic, new MqttMessage(message.getBytes(StandardCharsets.UTF_8)));
        }catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }
    private void sendObject(Object object){
        sendString(UtilsJson.getJson(object));
    }

    @Override
    public void sendTravellerReqReset(TravellerReqReset travellerReqReset) {
        sendObject(travellerReqReset);
    }

    @Override
    public void sendServicePanelAnswer(ServicePanelAnswer servicePanelAnswer) {
        sendObject(servicePanelAnswer);
    }

    @Override
    public void sendServiceState(ServiceState serviceState) {
        sendObject(serviceState);
    }

    @Override
    public void sendCurrentLevel(CurrentLevel currentLevel) {
        sendObject(currentLevel);
    }

    @Override
    public void sendDirectionIndication(DirectionIndication directionIndication) {
        sendObject(directionIndication);
    }

    @Override
    public void sendDoorState(DoorState doorState) {
        sendObject(doorState);
    }

    @Override
    public void sendLogErrorMsgs(LogErrorMsgs logErrorMsgs) {
        sendObject(logErrorMsgs);
    }


    /**
     * This function converts a received json into the correct object type and calls the fitting callback
     * This function is called, when a mqtt message get's received
     * @param receivedJson json that should be decoded from the gui
     */
    private void parseObjectAndCallCallback(String receivedJson) {
        Object type = UtilsJson.getClassTypeFromJson(receivedJson);
        if (type == TravellerReq.class) {
            answerCallback.onTravellerReqReceived(UtilsJson.getTravellerReqFromJson(receivedJson));
        } else if(type == ServicePanelReq.class){
            answerCallback.onServicePanelReq(UtilsJson.getServicePanelReqFromJson(receivedJson));
        }
    }
}
