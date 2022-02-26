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

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
        if (initialHealthPoint > healthPoint) System.out.println("Разваливается");
        if (healthPoint / initialHealthPoint < 0.7) {
            System.out.println("Плавится лицевая сторона");
        }
    }


}
