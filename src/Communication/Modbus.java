package Communication;

import ElevatorSps.MotorSpeedDir;
import ElevatorSps.PLCDataInput;
import ElevatorSps.Sensor;
import ElevatorSps.SensorState;
import de.re.easymodbus.modbusclient.ModbusClient;

import java.net.SocketException;

/**
 * @author Daniel Wassmer
 */
public class Modbus extends ModbusClient implements CommElevatorProtocol{

    private CommElevatorCallback callback;
    private boolean running = true;
    String errorTag = "Modbus Error: ";

    PLCDataInput polledData;
    PLCDataInput polledDataOld;

    private Runnable periodicCheck = new Runnable() {
        @Override
        public void run() {

            while (isConnected() && running) {
                try {
                    polledDataOld = polledData;
                    boolean[] sensors = ReadDiscreteInputs(0,4*8);
                    boolean[] doorMotorStates = ReadDiscreteInputs(80,4);
                    int id = ReadInputRegisters(4,1)[0];
                    int speed = ReadInputRegisters(6,1)[0];
                    boolean error = ReadDiscreteInputs(84,1)[0];
                    polledData = new PLCDataInput(sensors, doorMotorStates, id, speed, error);
                    if(polledDataOld != null) {
                        if (!polledData.equals(polledDataOld)) {
                            checkDifferencesAndCallCallbacks(polledDataOld, polledData, callback);
                        }
                    }

                    Thread.sleep(10);
                } catch (Exception e) {
                    if(e.getClass() == SocketException.class){
                        break;
                    }
                    System.out.println(errorTag + e.getMessage());
                }
            }
            callback.onDisconnected();
        }
    };

    private void checkDifferencesAndCallCallbacks(PLCDataInput polledDataOld, PLCDataInput polledDataNew, CommElevatorCallback callback) {
        //Check Sensors and call the callbacks
         if(polledDataOld.isL1SL() != polledDataNew.isL1SL()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.ONE, Sensor.sensorType.SAFETY_LOWER)));
         if(polledDataOld.isL1R() != polledDataNew.isL1R()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.ONE, Sensor.sensorType.LEVEL_REACH)));
         if(polledDataOld.isL1SU() != polledDataNew.isL1SU()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.ONE, Sensor.sensorType.SAFETY_UPPER)));
         if(polledDataOld.isL1AU() != polledDataNew.isL1AU()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.ONE, Sensor.sensorType.APPROACH_UPPER)));
         if(polledDataOld.isL2AL() != polledDataNew.isL2AL()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.TWO, Sensor.sensorType.APPROACH_LOWER)));
         if(polledDataOld.isL2SL() != polledDataNew.isL2SL()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.TWO, Sensor.sensorType.SAFETY_LOWER)));
         if(polledDataOld.isL2R() != polledDataNew.isL2R()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.TWO, Sensor.sensorType.LEVEL_REACH)));
         if(polledDataOld.isL2SU() != polledDataNew.isL2SU()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.TWO, Sensor.sensorType.SAFETY_UPPER)));
         if(polledDataOld.isL2AU() != polledDataNew.isL2AU()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.TWO, Sensor.sensorType.APPROACH_UPPER)));
         if(polledDataOld.isL3AL() != polledDataNew.isL3AL()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.THREE, Sensor.sensorType.APPROACH_LOWER)));
         if(polledDataOld.isL3SL() != polledDataNew.isL3SL()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.THREE, Sensor.sensorType.SAFETY_LOWER)));
         if(polledDataOld.isL3R() != polledDataNew.isL3R()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.THREE, Sensor.sensorType.LEVEL_REACH)));
         if(polledDataOld.isL3SU() != polledDataNew.isL3SU()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.THREE, Sensor.sensorType.SAFETY_UPPER)));
         if(polledDataOld.isL3AU() != polledDataNew.isL3AU()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.THREE, Sensor.sensorType.APPROACH_UPPER)));
         if(polledDataOld.isL4AL() != polledDataNew.isL4AL()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.FOUR, Sensor.sensorType.APPROACH_LOWER)));
         if(polledDataOld.isL4SL() != polledDataNew.isL4SL()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.FOUR, Sensor.sensorType.SAFETY_LOWER)));
         if(polledDataOld.isL4R() != polledDataNew.isL4R()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.FOUR, Sensor.sensorType.LEVEL_REACH)));
         if(polledDataOld.isL4SU() != polledDataNew.isL4SU()) callback.onSensorStateChanged(polledDataNew.getSensorState(new Sensor(Sensor.level.FOUR, Sensor.sensorType.SAFETY_UPPER)));

         //Check other data and call callback if changed
         if(polledDataOld.isdOpened() != polledDataNew.isdOpened() && polledDataNew.isdOpened()) {
             try {
                 WriteSingleCoil(5 + 8, false);
             }catch (Exception e){
                 System.out.println(errorTag + e.getMessage());
             }
             callback.onDoorOpened();
         }
         if(polledDataOld.isdClosed() != polledDataNew.isdClosed() && polledDataNew.isdClosed()){
             try {
                 WriteSingleCoil(4 + 8, false);
             }catch (Exception e){
                 System.out.println(errorTag + e.getMessage());
             }
             callback.onDoorClosed();
         }
         if(polledDataOld.ismReady() != polledDataNew.ismReady()) callback.onMotorReadyChanged(polledDataNew.ismReady());
         if(polledDataOld.ismOn() != polledDataNew.ismOn()) callback.onMotorOnChanged(polledDataNew.ismOn());
         if(polledDataOld.isError() != polledDataNew.isError() && polledDataNew.isError()) callback.onError();
         if(polledDataOld.getSpeed() != polledDataNew.getSpeed()) callback.onSpeedChanged(polledDataNew.getSpeed());
    }

    private Thread thread = new Thread(periodicCheck);

    public Modbus(String ipAddress, int port, CommElevatorCallback callback) {
        super(ipAddress, port);
        this.callback = callback;
    }

    @Override
    public void connect() {
        try{
            Connect();
            running = true;
            setSpeedAndDir(new MotorSpeedDir(MotorSpeedDir.speed.ZERO, MotorSpeedDir.direction.NONE));
            WriteSingleRegister(0,0);
            WriteSingleRegister(1,0);
            WriteSingleRegister(2,0);
            WriteSingleRegister(3,0);
            thread.start();
            callback.onConnected();
        }catch (Exception e){
            System.out.println(errorTag + e.getMessage());
        }
    }

    @Override
    public void disconnect() {
        try{
            running = false;
            try {
                thread.join(10000);
            } catch (Exception e){
            }
            Disconnect();
        }catch (Exception e){
            System.out.println(errorTag + e.getMessage());
        }
    }

    @Override
    public void setSpeedAndDir(MotorSpeedDir speed) {
        try {
            //Reset parameters first
            WriteSingleCoil(8, false);
            WriteSingleCoil(9, false);
            WriteSingleCoil(10, false);
            WriteSingleCoil(11, false);
            WriteSingleRegister(1, 0);
            //Set speed according to the configuration
            switch (speed.getDir()) {
                case UP:
                    switch (speed.getSpeed()) {
                        case V1:
                            WriteSingleCoil(10, true);
                            break;
                        case V2:
                            WriteSingleCoil(11, true);
                            break;
                        case CRAWL1:
                            WriteSingleRegister(1, 1);
                            break;
                        case CRAWL2:
                            WriteSingleRegister(1, 2);
                            break;
                        case CRAWL3:
                            WriteSingleRegister(1, 3);
                            break;
                        case CRAWL4:
                            WriteSingleRegister(1, 4);
                            break;
                        case CRAWL5:
                            WriteSingleRegister(1, 5);
                            break;
                    }
                    break;

                case DOWN:
                    switch (speed.getSpeed()) {
                        case V1:
                            WriteSingleCoil(9, true);
                            break;
                        case V2:
                            WriteSingleCoil(8, true);
                            break;
                        case CRAWL1:
                            WriteSingleRegister(1, -1);
                            break;
                        case CRAWL2:
                            WriteSingleRegister(1, -2);
                            break;
                        case CRAWL3:
                            WriteSingleRegister(1, -3);
                            break;
                        case CRAWL4:
                            WriteSingleRegister(1, -4);
                            break;
                        case CRAWL5:
                            WriteSingleRegister(1, -5);
                            break;
                    }
                    break;
            }
        }catch (Exception e){
            System.out.println(errorTag + e.getMessage());
        }
    }

    @Override
    public void closeDoor() {
        try {
            WriteSingleCoil(4 + 8, true);
        }catch (Exception e){
            System.out.println(errorTag + e.getMessage());
        }
    }

    @Override
    public void openDoor() {
        try {
            WriteSingleCoil(5 + 8, true);
        }catch (Exception e){
            System.out.println(errorTag + e.getMessage());
        }
    }

    @Override
    public SensorState getSensorState(Sensor sensor) {
        return polledData.getSensorState(sensor);

    }

    @Override
    public boolean isDoorOpen() {
        return polledData.isdOpened();
    }

    @Override
    public boolean isDoorClosed() {
        return polledData.isdClosed();
    }

    @Override
    public boolean isMotorReady() {
        return polledData.ismReady();
    }

    @Override
    public boolean isMotorOn() {
        return polledData.ismOn();
    }

    @Override
    public boolean isElevatorInErrorState() {
        return polledData.isError();
    }

    @Override
    public int getElevatorId() {
        return polledData.getId();
    }

    @Override
    public int getCurrentSpeed() {
        return polledData.getSpeed();
    }

    @Override
    public void resetSimulation() {
        try{
            WriteSingleCoil(0,true);
            WriteSingleCoil(0,false);
        } catch (Exception e){
            System.out.println(errorTag + e.getMessage());
        }
    }



}
