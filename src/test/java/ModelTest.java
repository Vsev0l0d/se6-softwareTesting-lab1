import model.Event;
import model.Location;
import model.Personage;
import model.Scene;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModelTest {
    private static Location computerBank;
    private static Event bombing;
    private static Personage personage1;
    private static Personage personage2;
    private static Scene scene;

    @BeforeEach
    private void init() {
        computerBank = new Location("Компьютерный банк", "Земля", 100);
        bombing = new Event("Бомбардировка", true, 110, 110, 35);
        personage1 = new Personage("Он");
        personage2 = new Personage("Она");
        Personage[] they = new Personage[]{personage1, personage2};
        scene = new Scene(computerBank, bombing, they);
    }

    @Test
    void test() {
        scene.start();
    }
}
