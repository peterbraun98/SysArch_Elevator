package Gui;
/**
 * @author Daniel Wassmer
 */
public class ServiceStateEnum {
    public enum state {
        IN_SERVICE("in service"),
        OUT_OF_SERVICE("out of service"),
        EMERGENCY("emergency"),
        POWER_OFF("power off");


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
