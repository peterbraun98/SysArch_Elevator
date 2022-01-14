import Communication.*;
import ElevatorSps.SensorState;
import Gui.*;

import java.util.Date;

public class Main {
    public static void main(String[] args){
        /*
        CommGUIProtocol comm = new MQTT(new CommGUICallback() {
            @Override
            public void onConnected() {
                System.out.println("Connected");
            }

            @Override
            public void onDisconnected() {
                System.out.println("Disconnected");
            }

            @Override
            public void onTravellerReqReceived(TravellerReq travellerReq) {
                System.out.println("Traveller Req Received");
            }

            @Override
            public void onServicePanelReq(ServicePanelReq servicePanelReq) {
                System.out.println("Service Panel Req Received");
            }
        });
        comm.connect();
        while(true){
            try {
                Thread.sleep(2000);
                comm.sendTravellerReqReset(new TravellerReqReset(TravellerReqResetEnum.reset.RESET));
                Thread.sleep(2000);
                comm.sendServicePanelAnswer(new ServicePanelAnswer("TestAnswer", new Date()));
                Thread.sleep(2000);
                comm.sendServiceState(new ServiceState(ServiceStateEnum.state.IN_SERVICE, new Date()));
                Thread.sleep(2000);
                comm.sendCurrentLevel(new CurrentLevel(CurrentLevelEnum.level.ONE));
                Thread.sleep(2000);
                comm.sendDirectionIndication(new DirectionIndication(DirectionIndicationEnum.direction.UP, DirectionIndicationEnum.active.ACTIVE));
                Thread.sleep(2000);
                comm.sendDoorState(new DoorState(DoorStateEnum.state.CLOSED));
                Thread.sleep(2000);
                comm.sendLogErrorMsgs(new LogErrorMsgs("Error Message", "Testerle Source", new Date(), LogErrorMsgsEnum.severity.DEBUG));
            }catch (Exception e){

            }
        }*/
        CommElevatorProtocol spsConnect = new Modbus("ea-pc190.ei.htwg-konstanz.de",507, new CommElevatorCallback() {
            @Override
            public void onConnected() {
                System.out.println("connected");
            }

            @Override
            public void onDisconnected() {
                System.out.println("disconnected");
            }

            @Override
            public void onSensorStateChanged(SensorState state) {
                System.out.println("Sensor Changed: Level: " + state.getSensor().getLevel().name() + " Sensor: " + state.getSensor().getSensorType().name() + " State: " + state.isPressed());
            }

            @Override
            public void onDoorOpened() {
                System.out.println("Door opened");
            }

            @Override
            public void onDoorClosed() {
                System.out.println("Door closed");
            }

            @Override
            public void onError() {
                System.out.println("Error");
            }

            @Override
            public void onMotorReadyChanged(boolean ready) {
                System.out.println("Motor ready state: " + ready);
            }

            @Override
            public void onMotorOnChanged(boolean on) {
                System.out.println("Motor on changed: " + on);
            }

            @Override
            public void onSpeedChanged(int speed) {
                System.out.println("Current speed: " + speed);
            }
        });
        spsConnect.connect();
        while(true){

        }
    }
}
