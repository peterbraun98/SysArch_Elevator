package ElevatorSps;
/**
 * @author Daniel Wassmer
 */
public class SPSDataInput {

    //Level 1 safety lower
    private boolean L1SL;
    //Level 1 reached
    private boolean L1R;
    //Level 1 safety upper
    private boolean L1SU;
    //level 1 approach upper
    private boolean L1AU;

    //Level 2 approach lower
    private boolean L2AL;
    //Level 2 safety lower
    private boolean L2SL;
    //Level 2 reached
    private boolean L2R;
    //Level 2 safety upper
    private boolean L2SU;
    //level 2 approach upper
    private boolean L2AU;

    //Level 3 approach lower
    private boolean L3AL;
    //Level 3 safety lower
    private boolean L3SL;
    //Level 3 reached
    private boolean L3R;
    //Level 3 safety upper
    private boolean L3SU;
    //level 3 approach upper
    private boolean L3AU;

    //Level 4 approach lower
    private boolean L4AL;
    //Level 4 safety lower
    private boolean L4SL;
    //Level 4 reached
    private boolean L4R;
    //Level 4 safety upper
    private boolean L4SU;

    //elevator id
    private int id;

    //door status
    private boolean dOpened;
    private boolean dClosed;

    //motor ready
    private boolean mReady;
    //motor on
    private boolean mOn;

    //Error
    private boolean error;

    //speed
    private int speed;

    public SPSDataInput(boolean[] sensors, boolean[] doorMotor, int elevatorId, int speed, boolean error) {
        setData(sensors,doorMotor,elevatorId, speed,error);
    }

    public void setData(boolean[] sensors, boolean[] doorMotor, int elevatorId, int speed, boolean error){
        L1SL = sensors[1];
        L1R  = sensors[2];
        L1SU = sensors[3];
        L1AU = sensors[4];

        L2AL = sensors[0+8];
        L2SL = sensors[1+8];
        L2R = sensors[2+8];
        L2SU = sensors[3+8];
        L2AU = sensors[4+8];

        L3AL = sensors[0+16];
        L3SL = sensors[1+16];
        L3R = sensors[2+16];
        L3SU = sensors[3+16];
        L3AU = sensors[4+16];

        L4AL =  sensors[0+24];
        L4SL =  sensors[1+24];
        L4R =  sensors[2+24];
        L4SU =  sensors[3+24];

        id = elevatorId;
        dOpened = doorMotor[0];
        dClosed = doorMotor[1];
        mReady = doorMotor[2];
        mOn = doorMotor[3];
        this.error = error;
        this.speed = speed;
    }


    public boolean isL1SL() {
        return L1SL;
    }

    public boolean isL1R() {
        return L1R;
    }

    public boolean isL1SU() {
        return L1SU;
    }

    public boolean isL1AU() {
        return L1AU;
    }

    public boolean isL2AL() {
        return L2AL;
    }

    public boolean isL2SL() {
        return L2SL;
    }

    public boolean isL2R() {
        return L2R;
    }

    public boolean isL2SU() {
        return L2SU;
    }

    public boolean isL2AU() {
        return L2AU;
    }

    public boolean isL3AL() {
        return L3AL;
    }

    public boolean isL3SL() {
        return L3SL;
    }

    public boolean isL3R() {
        return L3R;
    }

    public boolean isL3SU() {
        return L3SU;
    }

    public boolean isL3AU() {
        return L3AU;
    }

    public boolean isL4AL() {
        return L4AL;
    }

    public boolean isL4SL() {
        return L4SL;
    }

    public boolean isL4R() {
        return L4R;
    }

    public boolean isL4SU() {
        return L4SU;
    }

    public int getId() {
        return id;
    }

    public boolean isdOpened() {
        return dOpened;
    }

    public boolean isdClosed() {
        return dClosed;
    }

    public boolean ismReady() {
        return mReady;
    }

    public boolean ismOn() {
        return mOn;
    }

    public boolean isError() {
        return error;
    }

    public int getSpeed() {
        return speed;
    }

    public SensorState getSensorState(Sensor sensor){
        switch (sensor.getLevel()){
            case ONE:
                switch (sensor.getSensorType()){
                    case LEVEL_REACH:
                        return new SensorState(sensor, isL1R());
                    case SAFETY_LOWER:
                        return new SensorState(sensor, isL1SL());
                    case SAFETY_UPPER:
                        return new SensorState(sensor, isL1SU());
                    case APPROACH_LOWER:
                        return null;
                    case APPROACH_UPPER:
                        return new SensorState(sensor, isL1AU());
                }
                break;
            case TWO:
                switch (sensor.getSensorType()){
                    case LEVEL_REACH:
                        return new SensorState(sensor, isL2R());
                    case SAFETY_LOWER:
                        return new SensorState(sensor, isL2SL());
                    case SAFETY_UPPER:
                        return new SensorState(sensor, isL2SU());
                    case APPROACH_LOWER:
                        return new SensorState(sensor, isL2AL());
                    case APPROACH_UPPER:
                        return new SensorState(sensor, isL2AU());
                }
                break;
            case THREE:
                switch (sensor.getSensorType()){
                    case LEVEL_REACH:
                        return new SensorState(sensor, isL3R());
                    case SAFETY_LOWER:
                        return new SensorState(sensor, isL3SL());
                    case SAFETY_UPPER:
                        return new SensorState(sensor, isL3SU());
                    case APPROACH_LOWER:
                        return new SensorState(sensor, isL3AL());
                    case APPROACH_UPPER:
                        return new SensorState(sensor, isL3AU());
                }
                break;
            case FOUR:
                switch (sensor.getSensorType()){
                    case LEVEL_REACH:
                        return new SensorState(sensor, isL4R());
                    case SAFETY_LOWER:
                        return new SensorState(sensor, isL4SL());
                    case SAFETY_UPPER:
                        return new SensorState(sensor, isL4SU());
                    case APPROACH_LOWER:
                        return new SensorState(sensor, isL4AL());
                    case APPROACH_UPPER:
                        return null;
                }
                break;
        }

        return null;
    }

    @Override
    public boolean equals(Object obj) {
        try{
            boolean same = true;
            SPSDataInput input = (SPSDataInput)obj;
            same = same && isL1SL() == input.isL1SL();
            same = same && isL1R() == input.isL1R();
            same = same && isL1SU() == input.isL1SU();
            same = same && isL1AU() == input.isL1AU();
            same = same && isL2AL() == input.isL2AL();
            same = same && isL2SL() == input.isL2SL();
            same = same && isL2R() == input.isL2R();
            same = same && isL2SU() == input.isL2SU();
            same = same && isL2AU() == input.isL2AU();
            same = same && isL3AL() == input.isL3AL();
            same = same && isL3SL() == input.isL3SL();
            same = same && isL3R() == input.isL3R();
            same = same && isL3SU() == input.isL3SU();
            same = same && isL3AU() == input.isL3AU();
            same = same && isL4AL() == input.isL4AL();
            same = same && isL4SL() == input.isL4SL();
            same = same && isL4R() == input.isL4R();
            same = same && isL4SU() == input.isL4SU();
            same = same && getId() == input.getId();
            same = same && isdOpened() == input.isdOpened();
            same = same && isdClosed() == input.isdClosed();
            same = same && ismReady() == input.ismReady();
            same = same && ismOn() == input.ismOn();
            same = same && isError() == input.isError();
            same = same && getSpeed() == input.getSpeed();
            return same;

        } catch (Exception e){
            return false;
        }
    }
}
