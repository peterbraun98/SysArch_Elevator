package Gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Daniel Wassmer
 */
public class TravellerReqResetEnumTest {
    @Test
    public void travellerReqResetEnumTest(){
        //Test values
        assertEquals(TravellerReqResetEnum.reset.RESET, TravellerReqResetEnum.reset.get("reset"));
        assertEquals(TravellerReqResetEnum.reset.NO_RESET, TravellerReqResetEnum.reset.get("no reset"));
        //Test null answer if it doesn't exist
        assertEquals(null, TravellerReqResetEnum.reset.get("test"));
        //Test string values of the values
        assertEquals(TravellerReqResetEnum.reset.RESET.toString(), "reset");
        assertEquals(TravellerReqResetEnum.reset.NO_RESET.toString(), "no reset");
    }
}
