package by.mishota.multithreading.entity;

public enum TypeCargo {

    LORRY(5,10),VAN(2,3);

    int takesSpace, capacity;

    TypeCargo(int takesSpace, int capacity) {
        this.takesSpace = takesSpace;
        this.capacity = capacity;
    }

    public int getTakesSpace() {
        return takesSpace;
    }

    public int getCapacity() {
        return capacity;
    }
}
