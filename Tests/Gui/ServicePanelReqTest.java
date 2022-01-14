package Gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Daniel Wassmer
 */
public class ServicePanelReqTest {
    @Test
    public void panelReqTest(){
        ServicePanelReq request = new ServicePanelReq("test");
        assertEquals("test", request.getRequest());
    }
}
