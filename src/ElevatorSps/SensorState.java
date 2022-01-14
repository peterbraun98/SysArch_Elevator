package ElevatorSps;
/**
 * @author Daniel Wassmer
 */
public class SensorState {

    Sensor sensor;
    boolean state;

    public SensorState(Sensor sensor, boolean state) {
        this.sensor = sensor;
        this.state = state;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public boolean isPressed() {
        return state;
    }
}
