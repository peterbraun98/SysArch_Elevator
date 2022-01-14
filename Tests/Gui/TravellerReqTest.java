package Gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Daniel Wassmer
 */
public class TravellerReqTest {
    @Test
    public void travellerRequestValid(){
        TravellerReq valid = new TravellerReq("outside", "2");
        assertEquals("2", valid.getRequest());
        assertEquals(TravellerReqEnum.location.OUTSIDE, valid.getLocation());

        valid = new TravellerReq("inside", "test");
        assertEquals("test", valid.getRequest());
        assertEquals(TravellerReqEnum.location.INSIDE, valid.getLocation());
    }
    @Test
    public void travellerRequestInvalid(){
        TravellerReq valid = new TravellerReq("test", "2");
        assertEquals("2", valid.getRequest());
        assertEquals(null, valid.getLocation());
    }
}
