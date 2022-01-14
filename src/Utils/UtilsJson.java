package Utils;

import Gui.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
/**
 * @author Daniel Wassmer
 */
public class UtilsJson {

    public static Object getClassTypeFromJson(String json){
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        if(jsonObject.get("type")!=null) {
            switch (jsonObject.get("type").getAsString()) {
                case "CurrentLevel":
                    return CurrentLevel.class;
                case "DirInd":
                    return DirectionIndication.class;
                case "DoorState":
                    return DoorState.class;
                case "LogMsg":
                    return LogErrorMsgs.class;
                case "ServPaAns":
                    return ServicePanelAnswer.class;
                case "ServPReq":
                    return ServicePanelReq.class;
                case "ServState":
                    return ServiceState.class;
                case "TravReq":
                    return TravellerReq.class;
                case "TravReqRes":
                    return TravellerReqReset.class;
                default:
                    break;
            }
        }
        return null;
    }

    public static CurrentLevel getCurrentLevelFromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, CurrentLevel.class);
    }
    public static DirectionIndication getDirectionIndicationFromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, DirectionIndication.class);
    }
    public static DoorState getDoorStateFromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, DoorState.class);
    }
    public static LogErrorMsgs getLogErrorMsgsFromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, LogErrorMsgs.class);
    }
    public static ServicePanelAnswer getServicePanelAnswerFromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, ServicePanelAnswer.class);
    }
    public static ServicePanelReq getServicePanelReqFromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, ServicePanelReq.class);
    }
    public static ServiceState getServiceStateFromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, ServiceState.class);
    }
    public static TravellerReq getTravellerReqFromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, TravellerReq.class);
    }
    public static TravellerReqReset getTravellerReqResetFromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, TravellerReqReset.class);
    }

    public static String getJson(Object message){
        Gson gson = new Gson();
        return gson.toJson(message);
    }
}
