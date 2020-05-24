package by.mishota.xml.entity;

public enum Tag {
    POSTCARDS, POSTCARD, ID, THEME,TYPE,COUNTRY,YEAR,VALUABLE,AUTHORS,AUTHOR;

    public static Tag valueOfIgnoreCase(String name){

        return valueOf(name.toUpperCase());
    }
}
