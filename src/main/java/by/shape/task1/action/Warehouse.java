package by.shape.task1.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {

    private Map<Long, TriangleAction> triangleActions = new HashMap<>();
    private static Warehouse warehouse;

    public TriangleAction add(long id, TriangleAction triangleAction) {

        return triangleActions.put(id, triangleAction);

    }

    public TriangleAction remove(long id) {
        return triangleActions.remove(id);
    }

    public Optional<TriangleAction> getById(long id) {
        return Optional.of(triangleActions.get(id));

    }

    public static Warehouse getInstance() {

        if (warehouse == null) {
            warehouse = new Warehouse();
        }

        return warehouse;
    }


}
