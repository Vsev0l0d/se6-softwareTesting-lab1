import model.Event;
import model.Location;
import model.Personage;
import model.Scene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {
    private Scene scene;

    @BeforeEach
    private void init() {
        Location computerBank = new Location("Компьютерный банк", "Земля", 100);
        Event bombing = new Event("Бомбардировка", true, 110, 110, 35);
        Personage personage1 = new Personage("Он");
        Personage personage2 = new Personage("Она");
        Personage[] they = new Personage[]{personage1, personage2};
        scene = new Scene(computerBank, bombing, they);
    }

    @Test
    void testLocationName() {
        assertEquals("Компьютерный банк", scene.getLocation().getName());
    }

    @Test
    void testEventName() {
        assertEquals("Бомбардировка", scene.getEvent().getName());
    }

    @Test
    void testPersonageName() {
        assertAll(
                () -> assertEquals("Он", scene.getMembers()[0].getName()),
                () -> assertEquals("Она", scene.getMembers()[1].getName())
        );
    }

    @Test
    void testEventActive() {
        assertTrue(scene.getEvent().isActive());
    }

    @Test
    void testEventOptions() {
        assertAll(
                () -> assertEquals(110, scene.getEvent().getHeat()),
                () -> assertEquals(110, scene.getEvent().getVolume())
        );
    }

    @Test
    void testLocationInitialHP() {
        assertEquals(100, scene.getLocation().getHealthPoint());
    }

    @Test
    void testLocationChangeHP() {
        int newHP = scene.getLocation().getHealthPoint() - scene.getEvent().getDamage();
        scene.getLocation().changeHealthPoint(-scene.getEvent().getDamage());
        assertEquals(newHP, scene.getLocation().getHealthPoint());
    }

    @Test
    void testScene() {
        assertEquals("Бомбардировка активно, громкость: 110 жаркость: 110\n" +
                "Компьютерный банк разваливается\n" +
                "Плавится лицевая сторона\n" +
                "Он жду... Она жду... ", scene.start());
    }

    @Test
    void testSceneLittleDamage() {
        scene.getEvent().setDamage(1);
        assertEquals("Бомбардировка активно, громкость: 110 жаркость: 110\n" +
                "Компьютерный банк разваливается\n", scene.start());
    }

    @Test
    void testSceneNoDamage() {
        scene.getEvent().setDamage(0);
        assertEquals("Бомбардировка активно, громкость: 110 жаркость: 110\n", scene.start());
    }

    @Test
    void testSceneEventNotActive() {
        scene.getEvent().setActive(false);
        assertEquals("", scene.start());
    }
}
