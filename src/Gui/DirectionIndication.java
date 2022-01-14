package Gui;
/**
 * @author Daniel Wassmer
 */
public class DirectionIndication {
    private String type = "DirInd";
    private String direction;
    private String active;

    public DirectionIndication(DirectionIndicationEnum.direction direction, DirectionIndicationEnum.active active) {
        setDirection(direction);
        setActive(active);
    }

    public void setDirection(DirectionIndicationEnum.direction direction) {
        this.direction = direction.toString();
    }

    public void setActive(DirectionIndicationEnum.active active) {
        this.active = active.toString();
    }

    public String getDirection() {
        return direction;
    }

    public String getActive() {
        return active;
    }
}
