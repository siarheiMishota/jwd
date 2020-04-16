package by.mishotaSiarhei.composite.entity;

import java.util.Optional;

public interface Component {

    void add(Component component);

    void operation();

    Optional<Component> get(int id);

    void remove(Component component);
}
