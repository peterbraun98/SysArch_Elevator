package ElevatorSps;
/**
 * @author Daniel Wassmer
 */
public class Sensor {
    private level level;
    private sensorType sensorType;

    public Sensor(level level, sensorType sensorType) {
        this.level = level;
        this.sensorType = sensorType;
    }

    public level getLevel() {
        return level;
    }

    public sensorType getSensorType() {
        return sensorType;
    }

    public enum level{
        ONE,TWO,THREE,FOUR
    }

    public enum sensorType{
        SAFETY_LOWER, SAFETY_UPPER, LEVEL_REACH, APPROACH_LOWER, APPROACH_UPPER
    }
}
