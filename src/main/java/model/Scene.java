package model;

public class Scene {
    private Location location;
    private Event event;
    private Personage[] members;

    public Scene(Location location, Event event, Personage[] members) {
        this.location = location;
        this.event = event;
        this.members = members;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvents(Event event) {
        this.event = event;
    }

    public Personage[] getMembers() {
        return members;
    }

    public void setMembers(Personage[] members) {
        this.members = members;
    }

    public String start() {
        StringBuilder stringBuilder = new StringBuilder();
        if (event.isActive()) {
            stringBuilder.append(event.getName()).append(" активно, громкость: ")
                    .append(event.getVolume()).append(" жаркость: ")
                    .append(event.getHeat()).append("\n");
            stringBuilder.append(location.changeHealthPoint(-event.getDamage()));
            if (location.isFrontMelt()) {
                for (Personage personage : members)
                    stringBuilder.append(personage.waiting());
            }
        }
        return stringBuilder.toString();
    }
}
