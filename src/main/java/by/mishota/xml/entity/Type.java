package by.mishota.xml.entity;

public enum Type {
    GREETING, PROMOTIONAL,ORDINARY;

    public static Type valueOfIgnoreCase(String name){

        return valueOf(name.toUpperCase());
    }
}
