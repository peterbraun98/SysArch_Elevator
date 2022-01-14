package Gui;
/**
 * @author Daniel Wassmer
 */
public class CurrentLevelEnum {
    public enum level {
        ONE("1"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        IN_TRANSITION("in transition");


        private final String value;

        private level(String s) {
            value = s;
        }

        public static level get(String text) {
            for (level l : level.values()) {
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
