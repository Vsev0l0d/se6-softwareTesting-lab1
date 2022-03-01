import model.Event;
import model.Location;
import model.Personage;
import model.Scene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ModelTest {
    private static Location computerBank;
    private static Event bombing;
    private static Personage personage1;
    private static Personage personage2;
    private Scene scene;

    @BeforeEach
    private void init() {
        computerBank = new Location("Компьютерный банк", "Земля", 100);
        bombing = new Event("Бомбардировка", false, 110, 110, 35);
        personage1 = new Personage("Она");
        personage2 = new Personage("Она");
        Personage[] they = new Personage[]{personage1, personage2};
        scene = new Scene(computerBank, bombing, they);
    }

    @Test
    void testLocationName() {
        assertEquals("Компьютерный банк", computerBank.getName());
        assertEquals("Компьютерный банк", scene.getLocation().getName());
    }

    @Test
    void testEventName() {
        assertEquals("Бомбардировка", bombing.getName());
        assertEquals("Бомбардировка", scene.getEvent().getName());
    }

    @Test
    void testEventActive() {
        assertTrue(bombing.isActive());
        assertTrue(scene.getEvent().isActive());
    }

    @Test
    void testEventOptions() {
        assertEquals(110, bombing.getHeat());
        assertEquals(110, bombing.getVolume());
    }

    @Test
    void testLocationState() {
        assertEquals(100, computerBank.getHealthPoint());
    }

    @Test
    void testPersonageName() {
        assertEquals("Он", personage1.getName());
        assertEquals("Она", personage2.getName());
    }

    @Test
    void testLocationChangeHP() {
        assertEquals(computerBank.getName() + " разваливается\nПлавится лицевая сторона\n", computerBank.changeHealthPoint(-bombing.getDamage()));
    }

    @Test
    void testScene() {
        assertEquals(bombing.getName() + " активно, громкость: " + bombing.getVolume() + " жаркость: " + bombing.getHeat() + "\n" + computerBank.getName() + " разваливается\nПлавится лицевая сторона\n" + personage1.waiting() + personage2.waiting(), scene.start());
    }
}
