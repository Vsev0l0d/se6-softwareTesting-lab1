package model;

public class Event {
    private String name;
    private boolean active;
    private int volume;
    private int heat;
    private int damage;

    public Event(String name, boolean active, int volume, int heat, int damage) {
        this.name = name;
        this.active = active;
        this.volume = volume;
        this.heat = heat;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
