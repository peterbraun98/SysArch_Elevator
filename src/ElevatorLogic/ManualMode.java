package ElevatorLogic;

import Communication.CommElevatorCallback;
import Communication.CommElevatorProtocol;
import Communication.CommGUIProtocol;
import Communication.Modbus;
import ElevatorSps.SensorState;
import Gui.*;

/**
 * @author Peter Braun
 */

public class ManualMode {
    public CommElevatorProtocol newModbusForManual = new Modbus("ea-pc190.ei.htwg-konstanz.de", 507, new CommElevatorCallback() {
        @Override
        public void onConnected() {

        }

        @Override
        public void onDisconnected() {

        }

        @Override
        public void onSensorStateChanged(SensorState state) {

        }

        @Override
        public void onDoorOpened() {

        }

        @Override
        public void onDoorClosed() {

        }

        @Override
        public void onError() {

        }

        @Override
        public void onMotorReadyChanged(boolean ready) {

        }

        @Override
        public void onMotorOnChanged(boolean on) {

        }

        @Override
        public void onSpeedChanged(int speed) {

        }
    });
    public CommGUIProtocol newGuiProtocolForManual = new CommGUIProtocol() {
        @Override
        public void connect() {

        }

        @Override
        public void disconnect() {

        }

        @Override
        public void sendTravellerReqReset(TravellerReqReset travellerReqReset) {

        }

        @Override
        public void sendServicePanelAnswer(ServicePanelAnswer servicePanelAnswer) {

        }

        @Override
        public void sendServiceState(ServiceState serviceState) {

        }

        @Override
        public void sendCurrentLevel(CurrentLevel currentLevel) {

        }

        @Override
        public void sendDirectionIndication(DirectionIndication directionIndication) {

        }

        @Override
        public void sendDoorState(DoorState doorState) {

        }

        @Override
        public void sendLogErrorMsgs(LogErrorMsgs logErrorMsgs) {

        }
    };
}
