package by.mishota.multithreading.parser;

import by.mishota.multithreading.action.LogisticBase;
import by.mishota.multithreading.entity.Cargo;
import by.mishota.multithreading.entity.TypeCargo;

import java.util.ArrayList;
import java.util.List;

public class CargoParser {

    public List<Cargo> parse(List<String> lines, LogisticBase base) {

        List<Cargo> cargoes=new ArrayList<>();

        for (String line : lines) {

            String[] elements = line.split(" ");

            boolean isQuicklyPerishable = elements[0].equalsIgnoreCase("true");
            TypeCargo type=parseTypeCargo(elements[1]);

            Cargo cargo=new Cargo(type,isQuicklyPerishable,base);
            cargoes.add(cargo);

        }
        return cargoes;
    }

    private TypeCargo parseTypeCargo(String type) {
        switch (type) {
            case "lorry":
                return TypeCargo.LORRY;
            default:
                return TypeCargo.VAN;
        }
    }
}
