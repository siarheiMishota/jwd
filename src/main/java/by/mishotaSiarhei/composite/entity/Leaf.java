package by.mishotaSiarhei.composite.entity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Leaf implements Component {

    private String content;
    private Type type;


    public Leaf(String content, Type type) {
        this.content = content;
        this.type=type;
    }

    @Override
    public void add(Component component) {

        throw new UnsupportedOperationException("Cannot be added to leaf");

    }


    @Override
    public List<Component> getComponents() {
        return null;
    }

    @Override
    public Optional<Component> get(int id) {
        return Optional.of(this);
    }

    @Override
    public void remove(Component component) {

        throw new UnsupportedOperationException("Cannot be removed to leaf");

    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leaf)) return false;
        Leaf leaf = (Leaf) o;
        return Objects.equals(content, leaf.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return content;
    }
}
