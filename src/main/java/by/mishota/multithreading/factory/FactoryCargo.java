package by.mishota.multithreading.factory;

import by.mishota.multithreading.entity.Cargo;
import by.mishota.multithreading.entity.TypeCargo;
import by.mishota.multithreading.parser.CargoParser;

import java.util.ArrayList;
import java.util.List;

public class FactoryCargo {

    public static List<Cargo> createCargoes(List<String> lines) {
        List<Cargo> cargoes = new ArrayList<>();

        for (String line : lines) {
            String[] parsedLine = CargoParser.parse(line);
            TypeCargo type = TypeCargo.valueOf(parsedLine[0]);
            boolean perishable=Boolean.parseBoolean(parsedLine[1]);
            Cargo cargo = new Cargo(type,perishable);
            cargoes.add(cargo);
        }

        return cargoes;
    }
}
