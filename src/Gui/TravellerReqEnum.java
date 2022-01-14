package Gui;
/**
 * @author Daniel Wassmer
 */
public class TravellerReqEnum {
    public enum location {
        OUTSIDE("outside"),
        INSIDE("inside");


        private final String value;

        private location(String s) {
            value = s;
        }
        public static location get(String text) {
            for (location l : location.values()) {
                if (l.toString().equalsIgnoreCase(text)) {
                    return l;
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
