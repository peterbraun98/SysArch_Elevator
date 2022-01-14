package Gui;
/**
 * @author Daniel Wassmer
 */
public class DirectionIndicationEnum {
    public enum direction{
        UP("up"),
        DOWN("down");

        private final String value;

        private direction(String s) {
            value = s;
        }

        public static direction get(String text) {
            for (direction d : direction.values()) {
                if (d.toString().equalsIgnoreCase(text)) {
                    return d;
                }
            }
            return null;
        }
        @Override
        public String toString() {
            return this.value;
        }
    }
    public enum active{
        ACTIVE("active"),
        INACTIVE("inactive");

        private final String value;

        private active(String s) {
            value = s;
        }
        public static active get(String text) {
            for (active a : active.values()) {
                if (a.toString().equalsIgnoreCase(text)) {
                    return a;
                }
            }
            return null;
        }
        @Override
        public String toString() {
            return this.value;
        }
    }
}
