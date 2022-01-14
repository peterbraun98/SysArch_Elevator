package Gui;
/**
 * @author Daniel Wassmer
 */
public class CurrentLevel {
    private String type = "CurrentLevel";
    private String level;

    public CurrentLevel(CurrentLevelEnum.level level) {
        this.level = level.toString();
    }

    public CurrentLevelEnum.level getLevel() {
        return CurrentLevelEnum.level.get(level);
    }
}
