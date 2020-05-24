package by.mishota.xml.entity;

public enum Theme {
    CITY, NATURE, PEOPLE, RELIGIOUS, SPORT, ARCHITECTURE,ANIMAL,SHIP;

    public static Theme valueOfIgnoreCase(String name){

        return valueOf(name.toUpperCase());
    }
}
