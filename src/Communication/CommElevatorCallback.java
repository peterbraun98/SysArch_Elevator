package Communication;

import ElevatorSps.SensorState;
/**
 * @author Daniel Wassmer
 */
public interface CommElevatorCallback {
    /**
     * When the communication to the elevator get's connected this method get's called
     */
    void onConnected();
    /**
     * When the communication to the elevator get's disconnected this method get's called
     */
    void onDisconnected();

    /**
     * Everytime a sensor value changes this method get's called
     * @param state Sensor which changed status and the status
     */
    void onSensorStateChanged(SensorState state);

    /**
     * This function get's called when the door is fully opened
     */
    void onDoorOpened();

    /**
     * This function get's called when the door is fully closed
     */
    void onDoorClosed();

    /**
     * This function get's called when an error occures on the elevator side
     */
    void onError();

    /**
     * When the motor ready flag changes this function get's called
     * @param ready current motor ready flag
     */
    void onMotorReadyChanged(boolean ready);

    /**
     * When the motor on flag changes this function get's called
     * @param on current motor on flag
     */
    void onMotorOnChanged(boolean on);

    /**
     * When the motor speed changes this function get's called
     * @param speed current motor speed
     */
    void onSpeedChanged(int speed);
}
