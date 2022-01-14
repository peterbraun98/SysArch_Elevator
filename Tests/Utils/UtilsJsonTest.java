package Utils;

import Gui.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * @author Daniel Wassmer
 */
public class UtilsJsonTest {
    @Test
    public void utilsJsonTestJsonCurrentLevel(){
        String expectedAnswer = "{\"type\":\"CurrentLevel\",\"level\":\"1\"}";
        CurrentLevel level = new CurrentLevel(CurrentLevelEnum.level.ONE);
        System.out.println("Level " + UtilsJson.getJson(level));
        assertEquals(expectedAnswer, UtilsJson.getJson(level));

        expectedAnswer = "{\"type\":\"CurrentLevel\",\"level\":\"2\"}";
        level = new CurrentLevel(CurrentLevelEnum.level.TWO);
        System.out.println("Level " + UtilsJson.getJson(level));
        assertEquals(expectedAnswer, UtilsJson.getJson(level));

        expectedAnswer = "{\"type\":\"CurrentLevel\",\"level\":\"3\"}";
        level = new CurrentLevel(CurrentLevelEnum.level.THREE);
        System.out.println("Level " + UtilsJson.getJson(level));
        assertEquals(expectedAnswer, UtilsJson.getJson(level));

        expectedAnswer = "{\"type\":\"CurrentLevel\",\"level\":\"4\"}";
        level = new CurrentLevel(CurrentLevelEnum.level.FOUR);
        System.out.println("Level " + UtilsJson.getJson(level));
        assertEquals(expectedAnswer, UtilsJson.getJson(level));

        expectedAnswer = "{\"type\":\"CurrentLevel\",\"level\":\"in transition\"}";
        level = new CurrentLevel(CurrentLevelEnum.level.IN_TRANSITION);
        System.out.println("Level " + UtilsJson.getJson(level));
        assertEquals(expectedAnswer, UtilsJson.getJson(level));
    }
    @Test
    public void utilsJsonTestJsonDirectionIndication(){
        String expectedAnswer = "{\"type\":\"DirInd\",\"direction\":\"up\",\"active\":\"active\"}";
        DirectionIndication indication = new DirectionIndication(DirectionIndicationEnum.direction.UP, DirectionIndicationEnum.active.ACTIVE);
        System.out.println("Direction Indication " + UtilsJson.getJson(indication));
        assertEquals(expectedAnswer, UtilsJson.getJson(indication));
        expectedAnswer = "{\"type\":\"DirInd\",\"direction\":\"down\",\"active\":\"inactive\"}";
        indication = new DirectionIndication(DirectionIndicationEnum.direction.DOWN, DirectionIndicationEnum.active.INACTIVE);
        System.out.println("Direction Indication " + UtilsJson.getJson(indication));
        assertEquals(expectedAnswer, UtilsJson.getJson(indication));
    }
    @Test
    public void utilsJsonTestJsonDoorState(){
        String expectedAnswer = "{\"type\":\"DoorState\",\"state\":\"closed\"}";
        DoorState doorState = new DoorState(DoorStateEnum.state.CLOSED);
        System.out.println("Door state " + UtilsJson.getJson(doorState));
        assertEquals(expectedAnswer, UtilsJson.getJson(doorState));

        expectedAnswer = "{\"type\":\"DoorState\",\"state\":\"opened\"}";
        doorState = new DoorState(DoorStateEnum.state.OPENED);
        System.out.println("Door state " + UtilsJson.getJson(doorState));
        assertEquals(expectedAnswer, UtilsJson.getJson(doorState));

        expectedAnswer = "{\"type\":\"DoorState\",\"state\":\"in motion\"}";
        doorState = new DoorState(DoorStateEnum.state.IN_MOTION);
        System.out.println("Door state " + UtilsJson.getJson(doorState));
        assertEquals(expectedAnswer, UtilsJson.getJson(doorState));
    }

    @Test
    public void utilsJsonTestJsonLogErrorMsgs(){
        String timestamp = "2021-12-29T11:56:38.481Z";
        String expectedAnswer = "{\"type\":\"LogMsg\",\"message\":\"messageText\",\"source\":\"sourceText\",\"time\":\"2021-12-29T11:56:38.481Z\",\"severity\":\"INFO\"}";
        LogErrorMsgs logErrorMsgs = new LogErrorMsgs("messageText", "sourceText", UtilsDateTime.getDateFromString(timestamp), LogErrorMsgsEnum.severity.INFO);
        System.out.println("Log/Error MSGs " + UtilsJson.getJson(logErrorMsgs));
        assertEquals(expectedAnswer, UtilsJson.getJson(logErrorMsgs));

        expectedAnswer = "{\"type\":\"LogMsg\",\"message\":\"messageText\",\"source\":\"sourceText\",\"time\":\"2021-12-29T11:56:38.481Z\",\"severity\":\"DEBUG\"}";
        logErrorMsgs = new LogErrorMsgs("messageText", "sourceText", UtilsDateTime.getDateFromString(timestamp), LogErrorMsgsEnum.severity.DEBUG);
        System.out.println("Log/Error MSGs " + UtilsJson.getJson(logErrorMsgs));
        assertEquals(expectedAnswer, UtilsJson.getJson(logErrorMsgs));

        expectedAnswer = "{\"type\":\"LogMsg\",\"message\":\"messageText\",\"source\":\"sourceText\",\"time\":\"2021-12-29T11:56:38.481Z\",\"severity\":\"WARN\"}";
        logErrorMsgs = new LogErrorMsgs("messageText", "sourceText", UtilsDateTime.getDateFromString(timestamp), LogErrorMsgsEnum.severity.WARN);
        System.out.println("Log/Error MSGs " + UtilsJson.getJson(logErrorMsgs));
        assertEquals(expectedAnswer, UtilsJson.getJson(logErrorMsgs));

        expectedAnswer = "{\"type\":\"LogMsg\",\"message\":\"messageText\",\"source\":\"sourceText\",\"time\":\"2021-12-29T11:56:38.481Z\",\"severity\":\"ERROR\"}";
        logErrorMsgs = new LogErrorMsgs("messageText", "sourceText", UtilsDateTime.getDateFromString(timestamp), LogErrorMsgsEnum.severity.ERROR);
        System.out.println("Log/Error MSGs " + UtilsJson.getJson(logErrorMsgs));
        assertEquals(expectedAnswer, UtilsJson.getJson(logErrorMsgs));

        expectedAnswer = "{\"type\":\"LogMsg\",\"message\":\"messageText\",\"source\":\"sourceText\",\"time\":\"2021-12-29T11:56:38.481Z\",\"severity\":\"CRITICAL\"}";
        logErrorMsgs = new LogErrorMsgs("messageText", "sourceText", UtilsDateTime.getDateFromString(timestamp), LogErrorMsgsEnum.severity.CRITICAL);
        System.out.println("Log/Error MSGs " + UtilsJson.getJson(logErrorMsgs));
        assertEquals(expectedAnswer, UtilsJson.getJson(logErrorMsgs));
    }

    @Test
    public void utilsJsonTestJsonServicePanelAnswer(){
        String timestamp = "2021-12-29T11:56:38.481Z";
        String expectedAnswer = "{\"type\":\"ServPaAns\",\"answer\":\"answerText\",\"time\":\"2021-12-29T11:56:38.481Z\"}";
        ServicePanelAnswer servicePanelAnswer = new ServicePanelAnswer("answerText", UtilsDateTime.getDateFromString(timestamp));
        System.out.println("Service Panel Answer " + UtilsJson.getJson(servicePanelAnswer));
        assertEquals(expectedAnswer, UtilsJson.getJson(servicePanelAnswer));
    }

    @Test
    public void utilsJsonTestJsonServicePanelReq(){
        String expectedAnswer = "{\"type\":\"ServPReq\",\"request\":\"requestText\"}";
        ServicePanelReq servicePanelReq = new ServicePanelReq("requestText");
        System.out.println("Service Panel Request " + UtilsJson.getJson(servicePanelReq));
        assertEquals(expectedAnswer, UtilsJson.getJson(servicePanelReq));
    }

    @Test
    public void utilsJsonTestJsonServiceState(){
        String timestamp = "2021-12-29T11:56:38.481Z";
        String expectedAnswer = "{\"type\":\"ServState\",\"state\":\"in service\",\"time\":\"2021-12-29T11:56:38.481Z\"}";
        ServiceState servicePanelAnswer = new ServiceState(ServiceStateEnum.state.IN_SERVICE, UtilsDateTime.getDateFromString(timestamp));
        System.out.println("Service State " + UtilsJson.getJson(servicePanelAnswer));
        assertEquals(expectedAnswer, UtilsJson.getJson(servicePanelAnswer));

        expectedAnswer = "{\"type\":\"ServState\",\"state\":\"out of service\",\"time\":\"2021-12-29T11:56:38.481Z\"}";
        servicePanelAnswer = new ServiceState(ServiceStateEnum.state.OUT_OF_SERVICE, UtilsDateTime.getDateFromString(timestamp));
        System.out.println("Service State " + UtilsJson.getJson(servicePanelAnswer));
        assertEquals(expectedAnswer, UtilsJson.getJson(servicePanelAnswer));

        expectedAnswer = "{\"type\":\"ServState\",\"state\":\"emergency\",\"time\":\"2021-12-29T11:56:38.481Z\"}";
        servicePanelAnswer = new ServiceState(ServiceStateEnum.state.EMERGENCY, UtilsDateTime.getDateFromString(timestamp));
        System.out.println("Service State " + UtilsJson.getJson(servicePanelAnswer));
        assertEquals(expectedAnswer, UtilsJson.getJson(servicePanelAnswer));

         expectedAnswer = "{\"type\":\"ServState\",\"state\":\"power off\",\"time\":\"2021-12-29T11:56:38.481Z\"}";
        servicePanelAnswer = new ServiceState(ServiceStateEnum.state.POWER_OFF, UtilsDateTime.getDateFromString(timestamp));
        System.out.println("Service State " + UtilsJson.getJson(servicePanelAnswer));
        assertEquals(expectedAnswer, UtilsJson.getJson(servicePanelAnswer));
    }

    @Test
    public void utilsJsonTestJsonTravellerReq(){
        String expectedAnswer = "{\"type\":\"TravReq\",\"location\":\"inside\",\"request\":\"requestText\"}";
        TravellerReq travellerReq = new TravellerReq(TravellerReqEnum.location.INSIDE.toString(), "requestText");
        System.out.println("Traveller Request " + UtilsJson.getJson(travellerReq));
        assertEquals(expectedAnswer, UtilsJson.getJson(travellerReq));

        expectedAnswer = "{\"type\":\"TravReq\",\"location\":\"outside\",\"request\":\"requestText\"}";
        travellerReq = new TravellerReq(TravellerReqEnum.location.OUTSIDE.toString(), "requestText");
        System.out.println("Traveller Request " + UtilsJson.getJson(travellerReq));
        assertEquals(expectedAnswer, UtilsJson.getJson(travellerReq));
    }

    @Test
    public void utilsJsonTestJsonTravellerReqReset(){
        String expectedAnswer = "{\"type\":\"TravReqRes\",\"reset\":\"reset\"}";
        TravellerReqReset travellerReq = new TravellerReqReset(TravellerReqResetEnum.reset.RESET);
        System.out.println("Traveller Request " + UtilsJson.getJson(travellerReq));
        assertEquals(expectedAnswer, UtilsJson.getJson(travellerReq));

        expectedAnswer = "{\"type\":\"TravReqRes\",\"reset\":\"no reset\"}";
        travellerReq = new TravellerReqReset(TravellerReqResetEnum.reset.NO_RESET);
        System.out.println("Traveller Request " + UtilsJson.getJson(travellerReq));
        assertEquals(expectedAnswer, UtilsJson.getJson(travellerReq));
    }

    @Test
    public void utilsJsonTestObjectCurrentLevel(){
        String jsonValid = "{\"type\":\"CurrentLevel\",\"level\":\"1\"}";
        assertEquals(CurrentLevel.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(CurrentLevelEnum.level.ONE, UtilsJson.getCurrentLevelFromJson(jsonValid).getLevel());
        jsonValid = "{\"type\":\"CurrentLevel\",\"level\":\"2\"}";
        assertEquals(CurrentLevel.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(CurrentLevelEnum.level.TWO, UtilsJson.getCurrentLevelFromJson(jsonValid).getLevel());
        jsonValid = "{\"type\":\"CurrentLevel\",\"level\":\"3\"}";
        assertEquals(CurrentLevel.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(CurrentLevelEnum.level.THREE, UtilsJson.getCurrentLevelFromJson(jsonValid).getLevel());
        jsonValid = "{\"type\":\"CurrentLevel\",\"level\":\"4\"}";
        assertEquals(CurrentLevel.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(CurrentLevelEnum.level.FOUR, UtilsJson.getCurrentLevelFromJson(jsonValid).getLevel());
        jsonValid = "{\"type\":\"CurrentLevel\",\"level\":\"in transition\"}";
        assertEquals(CurrentLevel.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(CurrentLevelEnum.level.IN_TRANSITION, UtilsJson.getCurrentLevelFromJson(jsonValid).getLevel());
    }

    @Test
    public void utilsJsonTestObjectDirectionIndication(){
        String jsonValid = "{\"type\":\"DirInd\",\"direction\":\"up\",\"active\":\"active\"}";
        DirectionIndication original = new DirectionIndication(DirectionIndicationEnum.direction.UP, DirectionIndicationEnum.active.ACTIVE);
        DirectionIndication parsed = UtilsJson.getDirectionIndicationFromJson(jsonValid);
        assertEquals(DirectionIndication.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getDirection(), parsed.getDirection());
        assertEquals(original.getActive(), parsed.getActive());
        jsonValid = "{\"type\":\"DirInd\",\"direction\":\"down\",\"active\":\"inactive\"}";
        original = new DirectionIndication(DirectionIndicationEnum.direction.DOWN, DirectionIndicationEnum.active.INACTIVE);
        parsed = UtilsJson.getDirectionIndicationFromJson(jsonValid);
        assertEquals(DirectionIndication.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getDirection(), parsed.getDirection());
        assertEquals(original.getActive(), parsed.getActive());
    }

    @Test
    public void utilsJsonTestObjectDoorState(){
        String jsonValid = "{\"type\":\"DoorState\",\"state\":\"closed\"}";
        DoorState original = new DoorState(DoorStateEnum.state.CLOSED);
        DoorState parsed = UtilsJson.getDoorStateFromJson(jsonValid);
        assertEquals(DoorState.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getState(), parsed.getState());
        jsonValid = "{\"type\":\"DoorState\",\"state\":\"opened\"}";
        original = new DoorState(DoorStateEnum.state.OPENED);
        parsed = UtilsJson.getDoorStateFromJson(jsonValid);
        assertEquals(DoorState.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getState(), parsed.getState());
        jsonValid = "{\"type\":\"DoorState\",\"state\":\"in motion\"}";
        original = new DoorState(DoorStateEnum.state.IN_MOTION);
        parsed = UtilsJson.getDoorStateFromJson(jsonValid);
        assertEquals(DoorState.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getState(), parsed.getState());
    }

    @Test
    public void utilsJsonTestObjectLogErrorMsgs(){
        String jsonValid = "{\"type\":\"LogMsg\",\"message\":\"messageText\",\"source\":\"sourceText\",\"time\":\"2021-12-29T11:56:38.481Z\",\"severity\":\"INFO\"}";
        String timestamp = "2021-12-29T11:56:38.481Z";
        LogErrorMsgs original = new LogErrorMsgs("messageText", "sourceText", UtilsDateTime.getDateFromString(timestamp), LogErrorMsgsEnum.severity.INFO);
        LogErrorMsgs parsed = UtilsJson.getLogErrorMsgsFromJson(jsonValid);
        assertEquals(LogErrorMsgs.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getMessage(), parsed.getMessage());
        assertEquals(original.getSeverity(), parsed.getSeverity());
        assertEquals(original.getSource(), parsed.getSource());
        assertEquals(original.getTime(), parsed.getTime());

        jsonValid = "{\"type\":\"LogMsg\",\"message\":\"messageText\",\"source\":\"sourceText\",\"time\":\"2021-12-29T11:56:38.481Z\",\"severity\":\"DEBUG\"}";
        original = new LogErrorMsgs("messageText", "sourceText", UtilsDateTime.getDateFromString(timestamp), LogErrorMsgsEnum.severity.DEBUG);
        parsed = UtilsJson.getLogErrorMsgsFromJson(jsonValid);
        assertEquals(LogErrorMsgs.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getMessage(), parsed.getMessage());
        assertEquals(original.getSeverity(), parsed.getSeverity());
        assertEquals(original.getSource(), parsed.getSource());
        assertEquals(original.getTime(), parsed.getTime());

        jsonValid = "{\"type\":\"LogMsg\",\"message\":\"messageText\",\"source\":\"sourceText\",\"time\":\"2021-12-29T11:56:38.481Z\",\"severity\":\"WARN\"}";
        original = new LogErrorMsgs("messageText", "sourceText", UtilsDateTime.getDateFromString(timestamp), LogErrorMsgsEnum.severity.WARN);
        parsed = UtilsJson.getLogErrorMsgsFromJson(jsonValid);
        assertEquals(LogErrorMsgs.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getMessage(), parsed.getMessage());
        assertEquals(original.getSeverity(), parsed.getSeverity());
        assertEquals(original.getSource(), parsed.getSource());
        assertEquals(original.getTime(), parsed.getTime());

        jsonValid = "{\"type\":\"LogMsg\",\"message\":\"messageText\",\"source\":\"sourceText\",\"time\":\"2021-12-29T11:56:38.481Z\",\"severity\":\"ERROR\"}";
        original = new LogErrorMsgs("messageText", "sourceText", UtilsDateTime.getDateFromString(timestamp), LogErrorMsgsEnum.severity.ERROR);
        parsed = UtilsJson.getLogErrorMsgsFromJson(jsonValid);
        assertEquals(LogErrorMsgs.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getMessage(), parsed.getMessage());
        assertEquals(original.getSeverity(), parsed.getSeverity());
        assertEquals(original.getSource(), parsed.getSource());
        assertEquals(original.getTime(), parsed.getTime());

        jsonValid = "{\"type\":\"LogMsg\",\"message\":\"messageText\",\"source\":\"sourceText\",\"time\":\"2021-12-29T11:56:38.481Z\",\"severity\":\"CRITICAL\"}";
        original = new LogErrorMsgs("messageText", "sourceText", UtilsDateTime.getDateFromString(timestamp), LogErrorMsgsEnum.severity.CRITICAL);
        parsed = UtilsJson.getLogErrorMsgsFromJson(jsonValid);
        assertEquals(LogErrorMsgs.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getMessage(), parsed.getMessage());
        assertEquals(original.getSeverity(), parsed.getSeverity());
        assertEquals(original.getSource(), parsed.getSource());
        assertEquals(original.getTime(), parsed.getTime());
    }

    @Test
    public void utilsJsonTestObjectServicePanelAnswer(){
        String jsonValid = "{\"type\":\"ServPaAns\",\"answer\":\"answerText\",\"time\":\"2021-12-29T11:56:38.481Z\"}";
        String timestamp = "2021-12-29T11:56:38.481Z";
        ServicePanelAnswer original = new ServicePanelAnswer("answerText", UtilsDateTime.getDateFromString(timestamp));
        ServicePanelAnswer parsed = UtilsJson.getServicePanelAnswerFromJson(jsonValid);
        assertEquals(ServicePanelAnswer.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getAnswer(), parsed.getAnswer());
        assertEquals(original.getTime(), parsed.getTime());
    }

    @Test
    public void utilsJsonTestObjectServicePanelReq(){
        String jsonValid = "{\"type\":\"ServPReq\",\"request\":\"requestText\"}";
        ServicePanelReq original = new ServicePanelReq("requestText");
        ServicePanelReq parsed = UtilsJson.getServicePanelReqFromJson(jsonValid);
        assertEquals(ServicePanelReq.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getRequest(), parsed.getRequest());
    }

    @Test
    public void utilsJsonTestObjectServiceState(){
        String timestamp = "2021-12-29T11:56:38.481Z";
        String jsonValid = "{\"type\":\"ServState\",\"state\":\"in service\",\"time\":\"2021-12-29T11:56:38.481Z\"}";
        ServiceState original = new ServiceState(ServiceStateEnum.state.IN_SERVICE, UtilsDateTime.getDateFromString(timestamp));
        ServiceState parsed = UtilsJson.getServiceStateFromJson(jsonValid);
        assertEquals(ServiceState.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getState(), parsed.getState());
        assertEquals(original.getTime(), parsed.getTime());

        jsonValid = "{\"type\":\"ServState\",\"state\":\"out of service\",\"time\":\"2021-12-29T11:56:38.481Z\"}";
        original = new ServiceState(ServiceStateEnum.state.OUT_OF_SERVICE, UtilsDateTime.getDateFromString(timestamp));
        parsed = UtilsJson.getServiceStateFromJson(jsonValid);
        assertEquals(ServiceState.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getState(), parsed.getState());
        assertEquals(original.getTime(), parsed.getTime());

        jsonValid = "{\"type\":\"ServState\",\"state\":\"emergency\",\"time\":\"2021-12-29T11:56:38.481Z\"}";
        original = new ServiceState(ServiceStateEnum.state.EMERGENCY, UtilsDateTime.getDateFromString(timestamp));
        parsed = UtilsJson.getServiceStateFromJson(jsonValid);
        assertEquals(ServiceState.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getState(), parsed.getState());
        assertEquals(original.getTime(), parsed.getTime());

        jsonValid = "{\"type\":\"ServState\",\"state\":\"power off\",\"time\":\"2021-12-29T11:56:38.481Z\"}";
        original = new ServiceState(ServiceStateEnum.state.POWER_OFF, UtilsDateTime.getDateFromString(timestamp));
        parsed = UtilsJson.getServiceStateFromJson(jsonValid);
        assertEquals(ServiceState.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getState(), parsed.getState());
        assertEquals(original.getTime(), parsed.getTime());
    }

    @Test
    public void utilsJsonTestObjectTravellerReq(){
        String jsonValid = "{\"type\":\"TravReq\",\"location\":\"inside\",\"request\":\"requestText\"}";
        TravellerReq original = new TravellerReq(TravellerReqEnum.location.INSIDE.toString(), "requestText");
        TravellerReq parsed = UtilsJson.getTravellerReqFromJson(jsonValid);
        assertEquals(TravellerReq.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getRequest(), parsed.getRequest());
        assertEquals(original.getLocation(), parsed.getLocation());

        jsonValid = "{\"type\":\"TravReq\",\"location\":\"outside\",\"request\":\"requestText\"}";
        original = new TravellerReq(TravellerReqEnum.location.OUTSIDE.toString(), "requestText");
        parsed = UtilsJson.getTravellerReqFromJson(jsonValid);
        assertEquals(TravellerReq.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getRequest(), parsed.getRequest());
        assertEquals(original.getLocation(), parsed.getLocation());
    }

    @Test
    public void utilsJsonTestObjectTravellerReqReset(){
        String jsonValid = "{\"type\":\"TravReqRes\",\"reset\":\"reset\"}";
        TravellerReqReset original = new TravellerReqReset(TravellerReqResetEnum.reset.RESET);
        TravellerReqReset parsed = UtilsJson.getTravellerReqResetFromJson(jsonValid);
        assertEquals(TravellerReqReset.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getReset(), parsed.getReset());

        jsonValid = "{\"type\":\"TravReqRes\",\"reset\":\"no reset\"}";
        original = new TravellerReqReset(TravellerReqResetEnum.reset.NO_RESET);
        parsed = UtilsJson.getTravellerReqResetFromJson(jsonValid);
        assertEquals(TravellerReqReset.class, UtilsJson.getClassTypeFromJson(jsonValid));
        assertEquals(original.getReset(), parsed.getReset());
    }

    @Test
    public void utilsJsonTestObjectInvalidType(){
        String jsonInvalid = "{}";
        assertEquals(null, UtilsJson.getClassTypeFromJson(jsonInvalid));
    }

}
