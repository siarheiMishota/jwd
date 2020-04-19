package by.mishotaSiarhei.composite.entity;

import java.util.List;
import java.util.Optional;

public interface Component {

    void add(Component component);


    Optional<Component> get(int id);

    void remove(Component component);

    Type getType();

    List<Component> getComponents();
}
