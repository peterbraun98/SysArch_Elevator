package Gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Daniel Wassmer
 */
public class LogErrorMsgsEnumTest {
    @Test
    public void logErrorMsgsEnumTest(){
        //Test values
        assertEquals(LogErrorMsgsEnum.severity.DEBUG, LogErrorMsgsEnum.severity.get("DEBUG"));
        assertEquals(LogErrorMsgsEnum.severity.INFO, LogErrorMsgsEnum.severity.get("INFO"));
        assertEquals(LogErrorMsgsEnum.severity.WARN, LogErrorMsgsEnum.severity.get("WARN"));
        assertEquals(LogErrorMsgsEnum.severity.ERROR, LogErrorMsgsEnum.severity.get("ERROR"));
        assertEquals(LogErrorMsgsEnum.severity.CRITICAL, LogErrorMsgsEnum.severity.get("CRITICAL"));
        //Test null answer if it doesn't exist
        assertEquals(null, LogErrorMsgsEnum.severity.get("test"));
        //Test string values of the values
        assertEquals(LogErrorMsgsEnum.severity.DEBUG.toString(), "DEBUG");
        assertEquals(LogErrorMsgsEnum.severity.INFO.toString(), "INFO");
        assertEquals(LogErrorMsgsEnum.severity.WARN.toString(), "WARN");
        assertEquals(LogErrorMsgsEnum.severity.ERROR.toString(), "ERROR");
        assertEquals(LogErrorMsgsEnum.severity.CRITICAL.toString(), "CRITICAL");
    }
}
