package Gui;
/**
 * @author Daniel Wassmer
 */
public class DoorStateEnum {
    public enum state{
        OPENED("opened"),
        CLOSED("closed"),
        IN_MOTION("in motion");

        private final String value;

        private state(String s) {
            value = s;
        }
        public static state get(String text) {
            for (state s : state.values()) {
                if (s.toString().equalsIgnoreCase(text)) {
                    return s;
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
