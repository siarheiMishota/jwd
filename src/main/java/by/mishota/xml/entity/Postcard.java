package by.mishota.xml.entity;

import java.util.List;
import java.util.Objects;

public class Postcard {

    private long id;
    private Theme theme;
    private Type type;
    private String country;
    private int yearPublication;
    private List<String> authors;
    private Valuable valuable;

    private Postcard(long id, Theme theme, Type type, String country, int yearPublication, Valuable valuable, List<String> authors) {
        this.id = id;
        this.theme = theme;
        this.type = type;
        this.country = country;
        this.yearPublication = yearPublication;
        this.authors = authors;
        this.valuable = valuable;
    }


    public static class Builder {
        private long id = 0;
        private Theme theme = Theme.NATURE;
        private Type type = Type.ORDINARY;
        private String country = "Belarus";
        private int yearPublication = 2000;
        private List<String> authors;
        private Valuable valuable = Valuable.THEMATIC;

        public Builder() {
            theme = Theme.ANIMAL;
            type = Type.ORDINARY;
            country = "Belarus";
            yearPublication = 2000;
        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setTheme(Theme theme) {
            this.theme = theme;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setYearPublication(int yearPublication) {
            this.yearPublication = yearPublication;
            return this;
        }

        public Builder setAuthors(List<String> authors) {
            this.authors = authors;
            return this;
        }

        public Builder setValuable(Valuable valuable) {
            this.valuable = valuable;
            return this;
        }

        public Postcard build() {
            return new Postcard(id, theme, type, country, yearPublication, valuable, authors);
        }
    }


    public long getId() {
        return id;
    }

    public Theme getTheme() {
        return theme;
    }

    public Type getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public Valuable getValuable() {
        return valuable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postcard postcard = (Postcard) o;
        return id == postcard.id &&
                yearPublication == postcard.yearPublication &&
                theme == postcard.theme &&
                type == postcard.type &&
                country.equals(postcard.country) &&
                authors.equals(postcard.authors) &&
                valuable == postcard.valuable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, theme, type, country, yearPublication, authors, valuable);
    }

    @Override
    public String toString() {

        StringBuilder builderAuthors = new StringBuilder();

        for (String author : authors) {
            builderAuthors.append(author);
            builderAuthors.append(", ");
        }

        if (builderAuthors.length() > 2) {
            builderAuthors.delete(builderAuthors.length() - 2, builderAuthors.length());
        }
        return String.format("Postcard (%3d; %13s; %12s; %15s; %5d; %13s; %s.", id, theme, type, country, yearPublication, valuable, builderAuthors.toString());
    }
}
