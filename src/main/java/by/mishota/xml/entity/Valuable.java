package by.mishota.xml.entity;

public enum Valuable {

    HISTORICAL, COLLECTIBLE, THEMATIC;

    public static Valuable valueOfIgnoreCase(String name) {

        return valueOf(name.toUpperCase());
    }
}
