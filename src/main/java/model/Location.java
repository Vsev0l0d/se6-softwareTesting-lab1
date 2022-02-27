package model;

public class Location {
    private final double initialHealthPoint;
    private String name;
    private String planet;
    private int healthPoint;

    public Location(String name, String planet, int healthPoint) {
        this.name = name;
        this.planet = planet;
        this.healthPoint = healthPoint;
        this.initialHealthPoint = healthPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String changeHealthPoint(int healthPointDifference) {
        this.healthPoint += healthPointDifference;
        StringBuilder stringBuilder = new StringBuilder();
        if (healthPointDifference < 0) stringBuilder.append(name + " разваливается").append("/n");
        if (healthPointDifference / initialHealthPoint < 0.7) {
            stringBuilder.append("Плавится лицевая сторона").append("/n");
        }
        return stringBuilder.toString();
    }


}
