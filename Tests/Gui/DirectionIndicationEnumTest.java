package Gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Daniel Wassmer
 */
public class DirectionIndicationEnumTest {
    @Test
    public void directionIndicationEnumGetTestDirection(){
        //Test values
        assertEquals(DirectionIndicationEnum.direction.UP, DirectionIndicationEnum.direction.get("up"));
        assertEquals(DirectionIndicationEnum.direction.DOWN, DirectionIndicationEnum.direction.get("down"));
        //Test null answer if it doesn't exist
        assertEquals(null, DirectionIndicationEnum.direction.get("test"));
        //Test string values of the values
        assertEquals(DirectionIndicationEnum.direction.UP.toString(), "up");
        assertEquals(DirectionIndicationEnum.direction.DOWN.toString(), "down");

    }
    @Test
    public void directionIndicationEnumGetTestActive(){
        //Test values
        assertEquals(DirectionIndicationEnum.active.ACTIVE, DirectionIndicationEnum.active.get("active"));
        assertEquals(DirectionIndicationEnum.active.INACTIVE, DirectionIndicationEnum.active.get("inactive"));
        //Test null answer if it doesn't exist
        assertEquals(null, DirectionIndicationEnum.active.get("test"));
        //Test string values of the values
        assertEquals(DirectionIndicationEnum.active.ACTIVE.toString(), "active");
        assertEquals(DirectionIndicationEnum.active.INACTIVE.toString(), "inactive");
    }
}
