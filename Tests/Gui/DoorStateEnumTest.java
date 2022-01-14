package Gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Daniel Wassmer
 */
public class DoorStateEnumTest {
    @Test
    public void doorStateEnumTest(){
        //Test values
        assertEquals(DoorStateEnum.state.OPENED, DoorStateEnum.state.get("opened"));
        assertEquals(DoorStateEnum.state.CLOSED, DoorStateEnum.state.get("closed"));
        assertEquals(DoorStateEnum.state.IN_MOTION, DoorStateEnum.state.get("in motion"));
        //Test null answer if it doesn't exist
        assertEquals(null, DoorStateEnum.state.get("test"));
        //Test string values of the values
        assertEquals(DoorStateEnum.state.OPENED.toString(), "opened");
        assertEquals(DoorStateEnum.state.CLOSED.toString(), "closed");
        assertEquals(DoorStateEnum.state.IN_MOTION.toString(), "in motion");
    }
}
