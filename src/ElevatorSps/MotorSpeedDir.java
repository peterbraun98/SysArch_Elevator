package ElevatorSps;
/**
 * @author Daniel Wassmer
 */
public class MotorSpeedDir {

    private speed speed;
    private direction dir;

    public MotorSpeedDir(speed speed, direction dir) {
        this.speed = speed;
        this.dir = dir;
    }

    public MotorSpeedDir.speed getSpeed() {
        return speed;
    }

    public direction getDir() {
        return dir;
    }

    public void setSpeed(MotorSpeedDir.speed speed) {
        this.speed = speed;
    }

    public void setDir(direction dir) {
        this.dir = dir;
    }

    public enum speed{
        V1,V2,CRAWL1,CRAWL2,CRAWL3,CRAWL4,CRAWL5,ZERO
    }

    public enum direction{
        UP,DOWN,NONE
    }
}
