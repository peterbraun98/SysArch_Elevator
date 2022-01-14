package Gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Daniel Wassmer
 */
public class CurrentLevelEnumTest {
    @Test
    public void currentLevelEnumTest(){
        //Test values
        assertEquals(CurrentLevelEnum.level.ONE, CurrentLevelEnum.level.get("1"));
        assertEquals(CurrentLevelEnum.level.TWO, CurrentLevelEnum.level.get("2"));
        assertEquals(CurrentLevelEnum.level.THREE, CurrentLevelEnum.level.get("3"));
        assertEquals(CurrentLevelEnum.level.FOUR, CurrentLevelEnum.level.get("4"));
        assertEquals(CurrentLevelEnum.level.IN_TRANSITION, CurrentLevelEnum.level.get("in transition"));
        //Test null answer if it doesn't exist
        assertEquals(null, CurrentLevelEnum.level.get("test"));
        //Test string values of the values
        assertEquals(CurrentLevelEnum.level.ONE.toString(), "1");
        assertEquals(CurrentLevelEnum.level.TWO.toString(), "2");
        assertEquals(CurrentLevelEnum.level.THREE.toString(), "3");
        assertEquals(CurrentLevelEnum.level.FOUR.toString(), "4");
        assertEquals(CurrentLevelEnum.level.IN_TRANSITION.toString(), "in transition");
    }
}
