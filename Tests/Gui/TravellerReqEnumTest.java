package Gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Daniel Wassmer
 */
public class TravellerReqEnumTest {
    @Test
    public void travellerReqEnumTest(){
        //Test values
        assertEquals(TravellerReqEnum.location.OUTSIDE, TravellerReqEnum.location.get("outside"));
        assertEquals(TravellerReqEnum.location.INSIDE, TravellerReqEnum.location.get("inside"));
        //Test null answer if it doesn't exist
        assertEquals(null, TravellerReqEnum.location.get("test"));
        //Test string values of the values
        assertEquals(TravellerReqEnum.location.OUTSIDE.toString(), "outside");
        assertEquals(TravellerReqEnum.location.INSIDE.toString(), "inside");
    }
}
