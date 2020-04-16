package by.mishotaSiarhei.composite.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Composite implements Component {

    private List<Component> components = new ArrayList<>();


    @Override
    public Optional<Component> get(int index) {

        if (index >= 0 && index < components.size()) {
            return Optional.of(components.get(index));
        }

        return Optional.empty();
    }

    @Override
    public void add(Component component) {

        components.add(component);

    }

    @Override
    public void operation() {


    }


    @Override
    public void remove(Component component) {

        components.remove(component);

    }

}
