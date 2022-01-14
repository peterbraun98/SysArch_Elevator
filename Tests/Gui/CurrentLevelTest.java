package Gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * @author Daniel Wassmer
 */
public class CurrentLevelTest {

    @Test
    public void levelTest1(){
        CurrentLevel level = new CurrentLevel(CurrentLevelEnum.level.ONE);
        assertEquals(CurrentLevelEnum.level.ONE, level.getLevel());
    }
    @Test
    public void levelTest2(){
        CurrentLevel level = new CurrentLevel(CurrentLevelEnum.level.TWO);
        assertEquals(CurrentLevelEnum.level.TWO, level.getLevel());
    }
    @Test
    public void levelTest3(){
        CurrentLevel level = new CurrentLevel(CurrentLevelEnum.level.THREE);
        assertEquals(CurrentLevelEnum.level.THREE, level.getLevel());
    }
    @Test
    public void levelTest4(){
        CurrentLevel level = new CurrentLevel(CurrentLevelEnum.level.FOUR);
        assertEquals(CurrentLevelEnum.level.FOUR, level.getLevel());
    }
    @Test
    public void levelTestTransition(){
        CurrentLevel level = new CurrentLevel(CurrentLevelEnum.level.IN_TRANSITION);
        assertEquals(CurrentLevelEnum.level.IN_TRANSITION, level.getLevel());
    }
    @Test
    public void levelTestInvalid(){
        assertThrows(NullPointerException.class, ()->{
            CurrentLevel level = new CurrentLevel(CurrentLevelEnum.level.get("test"));
        });
    }
}
