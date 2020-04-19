package by.mishotaSiarhei.composite.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Composite implements Component {

    private List<Component> components = new ArrayList<>();
    private Type type;

    public Composite(Type type) {
        this.type = type;
    }

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
    public void remove(Component component) {

        components.remove(component);

    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Composite)) return false;
        Composite composite = (Composite) o;
        return Objects.equals(components, composite.components) &&
                type == composite.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(components, type);
    }

    @Override
    public String toString() {

        StringBuilder stringComponents = new StringBuilder();

        for (Component component : components) {


            switch (component.getType()) {

                case PARAGRAPH:
                    stringComponents.append("\n    ");
                    break;

                case WORD:
                    stringComponents.append(" ");
                    break;
            }
            stringComponents.append(component.toString());



        }

        return stringComponents.toString();

    }
}
