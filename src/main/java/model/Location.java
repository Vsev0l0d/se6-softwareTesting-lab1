package model;

public class Location {
    private final double initialHealthPoint;
    private String planet;
    private int healthPoint;

    public Location(String planet, int healthPoint) {
        this.planet = planet;
        this.healthPoint = healthPoint;
        this.initialHealthPoint = healthPoint;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void changeHealthPoint(int healthPointDifference) {
        this.healthPoint += healthPointDifference;
        if (healthPointDifference < 0) System.out.println("Разваливается");
        if (healthPointDifference / initialHealthPoint < 0.7) {
            System.out.println("Плавится лицевая сторона");
        }
    }


}
