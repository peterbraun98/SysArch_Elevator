package Communication;

import ElevatorSps.MotorSpeedDir;
import ElevatorSps.Sensor;
import ElevatorSps.SensorState;

/**
 * @author Daniel Wassmer
 */

public interface CommElevatorProtocol {
    /**
     * Connect to the elevator PLC
     */
    void connect();

    /**
     * Disconnect from the elevator PLC
     */
    void disconnect();

    /**
     * Resets current parameters and set's the new wished motor direction and speed
     * @param speed motor speed and direction the elevator should move
     */
    void setSpeedAndDir(MotorSpeedDir speed);

    /**
     * Set's the closeDoor flag and reset's itself after the elevator is fully closed
     */
    void closeDoor();

    /**
     * Set's the openDoor flag and reset's itself after the elevator is fully opened
     */
    void openDoor();

    /**
     * Fetches the SensorState of the requested sensor with the last polled data
     * @param sensor requested sensor state
     * @return sensor state of the sensor
     */
    SensorState getSensorState(Sensor sensor);

    /**
     * Returnes if the door is open from last polled dataset
     * @return true if door is open
     */
    boolean isDoorOpen();

    /**
     * Returnes if the door is closed from the last polled dataset
     * @return true if door is closed
     */
    boolean isDoorClosed();

    /**
     * Returnes if the motor ready flag is set from the last polled dataset
     * @return true if motor is ready
     */
    boolean isMotorReady();

    /**
     * Returnes if the motor on flag is set from the last polled dataset
     * @return true if motor is on
     */
    boolean isMotorOn();

    /**
     * Returns if the elevator is in Error State from the last polled dataset
     * @return true if elevator has an error
     */
    boolean isElevatorInErrorState();

    /**
     * Returns the elevator id from the last polled dataset
     * @return elevator id of the elevator 1..4
     */
    int getElevatorId();

    /**
     * Returns the current speed that the elevator travels from the last polled dataset
     * @return speed of the elevator in 1cm/s
     */
    int getCurrentSpeed();

    /**
     * Resets the simulation of the elevator
     */
    void resetSimulation();
}
