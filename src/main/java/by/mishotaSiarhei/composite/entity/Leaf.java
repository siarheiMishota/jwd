package by.mishotaSiarhei.composite.entity;

import java.util.Objects;
import java.util.Optional;

public class Leaf implements Component {

    String content;

    public Leaf(String content) {
        this.content = content;
    }

    @Override
    public void add(Component component) {

        throw new UnsupportedOperationException("Cannot be added to leaf");

    }

    @Override
    public void operation() {

        throw new UnsupportedOperationException("Cannot be parsed to leaf");


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
