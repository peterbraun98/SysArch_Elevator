package Gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Daniel Wassmer
 */
public class ServiceStateEnumTest {
    @Test
    public void serviceStateEnumTest(){
        //Test values
        assertEquals(ServiceStateEnum.state.IN_SERVICE, ServiceStateEnum.state.get("in service"));
        assertEquals(ServiceStateEnum.state.OUT_OF_SERVICE, ServiceStateEnum.state.get("out of service"));
        assertEquals(ServiceStateEnum.state.EMERGENCY, ServiceStateEnum.state.get("emergency"));
        assertEquals(ServiceStateEnum.state.POWER_OFF, ServiceStateEnum.state.get("power off"));
        //Test null answer if it doesn't exist
        assertEquals(null, ServiceStateEnum.state.get("test"));
        //Test string values of the values
        assertEquals(ServiceStateEnum.state.IN_SERVICE.toString(), "in service");
        assertEquals(ServiceStateEnum.state.OUT_OF_SERVICE.toString(), "out of service");
        assertEquals(ServiceStateEnum.state.EMERGENCY.toString(), "emergency");
        assertEquals(ServiceStateEnum.state.POWER_OFF.toString(), "power off");
    }
}
