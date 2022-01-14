package Gui;
/**
 * @author Daniel Wassmer
 */
public class LogErrorMsgsEnum {
    public enum severity{
        DEBUG("DEBUG"),
        INFO("INFO"),
        WARN("WARN"),
        ERROR("ERROR"),
        CRITICAL("CRITICAL");

        private final String value;

        private severity(String s) {
            value = s;
        }
        public static severity get(String text) {
            for (severity s : severity.values()) {
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
