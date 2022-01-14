package Gui;
/**
 * @author Daniel Wassmer
 */
public class TravellerReqResetEnum {
    public enum reset {
        RESET("reset"),
        NO_RESET("no reset");


        private final String value;

        private reset(String s) {
            value = s;
        }
        public static reset get(String text) {
            for (reset r : reset.values()) {
                if (r.toString().equalsIgnoreCase(text)) {
                    return r;
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
