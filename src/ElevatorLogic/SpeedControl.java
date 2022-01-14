package ElevatorLogic;

import Communication.*;
import ElevatorSps.Sensor;
import ElevatorSps.MotorSpeedDir;
import ElevatorSps.SensorState;
import Gui.LogErrorMsgs;
import Gui.ServicePanelReq;
import Gui.TravellerReq;
import Gui.TravellerReqEnum;

/**
 * @author Peter Braun
 */
public class SpeedControl() {
    public CommElevatorProtocol newModbusProtocol = new Modbus("ea-pc190.ei.htwg-konstanz.de", 507, new CommElevatorCallback() {
        @Override
        public void onConnected() {

        }

        @Override
        public void onDisconnected() {

        }

        @Override
        public void onSensorStateChanged(SensorState state) {
            if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.FOUR, Sensor.sensorType.APPROACH_LOWER)) && (targetFloor.getTargetFloor() == Level.valueOf("FOUR"))){ //if the sensor L4AL is active and the anticipated Level is four, the speed is limited to V1
                MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.V1, MotorSpeedDir.direction.UP);
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


    CommGUIProtocol newGuiProtocol = new MQTT("localhost", new CommGUICallback() {
        @Override
        public void onConnected() {

        }

        @Override
        public void onDisconnected() {

        }

        @Override
        public void onTravellerReqReceived(TravellerReq travellerReq) {
            TravellerReq travellerReq1 = new TravellerReq(travellerReq.getLocation().toString(),travellerReq.getRequest());
            if(onTravellerReqReceived(travellerReq1);)
        controlledSpeed();
        }

        @Override
        public void onServicePanelReq(ServicePanelReq servicePanelReq) {

        }
    });

    public enum Level {         //initializing the compare values for the floor level
        ONE,
        TWO,
        THREE,
        FOUR,
        IN_TRANSITION;}
// new way: react to every sensorCallback controlledSpeed method changes speed by reaching the sensor
    public void controlledSpeed(){
        TargetFloor targetFloor = new TargetFloor();
        //speed control for direction UP
        //speed control for level Four
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.FOUR, Sensor.sensorType.APPROACH_LOWER)) && (targetFloor.getTargetFloor() == Level.valueOf("FOUR"))){ //if the sensor L4AL is active and the anticipated Level is four, the speed is limited to V1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.V1, MotorSpeedDir.direction.UP);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.FOUR, Sensor.sensorType.SAFETY_LOWER)) && (targetFloor.getTargetFloor() == Level.valueOf("FOUR"))){ //if the sensor L4SL is active and the anticipated Level is four, the speed is limited to CRAWL1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.CRAWL1, MotorSpeedDir.direction.UP);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.FOUR, Sensor.sensorType.LEVEL_REACH)).getSensor() && (targetFloor.getTargetFloor() == Level.valueOf("FOUR"))){ //if the sensor L4R is active and the anticipated Level is four, the speed is limited to NONE
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.ZERO, MotorSpeedDir.direction.NONE);
        }
        //speed control for level THREE
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.THREE, Sensor.sensorType.APPROACH_LOWER) && (targetFloor.getTargetFloor() == Level.valueOf("THREE"))){ //if the sensor L3AL is active and the anticipated Level is three, the speed is limited to V1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.V1, MotorSpeedDir.direction.UP);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.THREE, Sensor.sensorType.SAFETY_LOWER)) && (targetFloor.getTargetFloor() == Level.valueOf("THREE"))){ //if the sensor L3SL is active and the anticipated Level is three, the speed is limited to CRAWL1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.CRAWL1, MotorSpeedDir.direction.UP);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.THREE, Sensor.sensorType.LEVEL_REACH)) && (targetFloor.getTargetFloor() == Level.valueOf("THREE"))){ //if the sensor L3R is active and the anticipated Level is three, the speed is limited to NONE
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.ZERO, MotorSpeedDir.direction.NONE);
        }
        //speed control for level TWO
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.TWO, Sensor.sensorType.APPROACH_LOWER)) && (targetFloor.getTargetFloor() == Level.valueOf("TWO"))){ //if the sensor L2AL is active and the anticipated Level is two, the speed is limited to V1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.V1, MotorSpeedDir.direction.UP);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.TWO, Sensor.sensorType.SAFETY_LOWER)) && (targetFloor.getTargetFloor() == Level.valueOf("TWO"))){ //if the sensor L2SL is active and the anticipated Level is two, the speed is limited to CRAWL1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.CRAWL1, MotorSpeedDir.direction.UP);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.TWO, Sensor.sensorType.LEVEL_REACH)) && (targetFloor.getTargetFloor() == Level.valueOf("TWO"))){ //if the sensor L2R is active and the anticipated Level is two, the speed is limited to NONE
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.ZERO, MotorSpeedDir.direction.NONE);
        }
        //speed control for level ONE
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.ONE, Sensor.sensorType.SAFETY_LOWER)) && (targetFloor.getTargetFloor() == Level.valueOf("ONE"))){ //if the sensor L1SL is active and the anticipated Level is one, the speed is limited to NONE
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.CRAWL1, MotorSpeedDir.direction.UP);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.ONE, Sensor.sensorType.LEVEL_REACH)) && (targetFloor.getTargetFloor() == Level.valueOf("ONE"))){ //if the sensor L1R is active and the anticipated Level is one, the speed is limited to NONE
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.ZERO, MotorSpeedDir.direction.NONE);
        }

        //speed control for direction DOWN
        //speed control for level ONE
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.ONE, Sensor.sensorType.APPROACH_UPPER)) && (targetFloor.getTargetFloor() == Level.valueOf("ONE"))){ //if the sensor L1AU is active and the anticipated Level is one, the speed is limited to V1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.V1, MotorSpeedDir.direction.DOWN);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.FOUR, Sensor.sensorType.SAFETY_UPPER)) && (targetFloor.getTargetFloor() == Level.valueOf("ONE"))){ //if the sensor L1SU is active and the anticipated Level is one, the speed is limited to CRAWL1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.CRAWL1, MotorSpeedDir.direction.DOWN);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.FOUR, Sensor.sensorType.LEVEL_REACH)) && (targetFloor.getTargetFloor() == Level.valueOf("ONE"))){ //if the sensor L1R is active and the anticipated Level is one, the speed is limited to NONE
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.ZERO, MotorSpeedDir.direction.NONE);
        }
        //speed control for level TWO
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.TWO, Sensor.sensorType.APPROACH_UPPER)) && (targetFloor.getTargetFloor() == Level.valueOf("TWO"))){ //if the sensor L2AU is active and the anticipated Level is two, the speed is limited to V1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.V1, MotorSpeedDir.direction.DOWN);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.TWO, Sensor.sensorType.SAFETY_UPPER)) && (targetFloor.getTargetFloor() == Level.valueOf("TWO"))){ //if the sensor L2SU is active and the anticipated Level is two, the speed is limited to CRAWL1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.CRAWL1, MotorSpeedDir.direction.DOWN);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.TWO, Sensor.sensorType.LEVEL_REACH)) && (targetFloor.getTargetFloor() == Level.valueOf("TWO"))){ //if the sensor L2R is active and the anticipated Level is two, the speed is limited to NONE
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.ZERO, MotorSpeedDir.direction.NONE);
        }
        //speed control for level THREE
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.THREE, Sensor.sensorType.APPROACH_UPPER)) && (targetFloor.getTargetFloor() == Level.valueOf("THREE")){ //if the sensor L3AU is active and the anticipated Level is three, the speed is limited to V1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.V1, MotorSpeedDir.direction.DOWN);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.THREE, Sensor.sensorType.SAFETY_UPPER)) && (targetFloor.getTargetFloor() == Level.valueOf("THREE"))){ //if the sensor L3SU is active and the anticipated Level is three, the speed is limited to CRAWL1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.CRAWL1, MotorSpeedDir.direction.DOWN);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.THREE, Sensor.sensorType.LEVEL_REACH)) && (targetFloor.getTargetFloor() == Level.valueOf("THREE"))){ //if the sensor L3R is active and the anticipated Level is three, the speed is limited to NONE
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.ZERO, MotorSpeedDir.direction.NONE);
        }
        //speed control for level FOUR
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.FOUR, Sensor.sensorType.SAFETY_UPPER)) && (targetFloor.getTargetFloor() == Level.valueOf("FOUR"))){ //if the sensor L4SU is active and the anticipated Level is four, the speed is limited to CRAWL1
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.CRAWL1, MotorSpeedDir.direction.DOWN);
        }
        if(newModbusProtocol.getSensorState(new Sensor(Sensor.level.FOUR, Sensor.sensorType.LEVEL_REACH)) && (targetFloor.getTargetFloor() == Level.valueOf("FOUR"))){ //if the sensor L4R is active and the anticipated Level is four, the speed is limited to NONE
            MotorSpeedDir speedDir = new MotorSpeedDir(MotorSpeedDir.speed.ZERO, MotorSpeedDir.direction.NONE);
        }
    }/*
}


