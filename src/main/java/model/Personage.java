package model;

public class Personage {
    private String name;

    public Personage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void waiting() {
        System.out.println(name + " жду...");
    }
}
