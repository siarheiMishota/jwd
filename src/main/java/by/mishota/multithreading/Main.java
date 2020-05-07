package by.mishota.multithreading;

import by.mishota.multithreading.action.LogisticBase;
import by.mishota.multithreading.entity.Cargo;
import by.mishota.multithreading.entity.Terminal;
import by.mishota.multithreading.entity.Territory;
import by.mishota.multithreading.entity.TypeCargo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int numberTerminals = 8;
        Random random=new Random();
        Territory territory = new Territory(45);
        List<Terminal> terminals = new ArrayList<>();
        ExecutorService executorService= Executors.newCachedThreadPool();

        for (int i = 0; i < numberTerminals; i++) {
            terminals.add(new Terminal(territory));
        }

        LogisticBase base=new LogisticBase(terminals,territory);

        for (int i = 0; i < 50; i++) {
            Cargo cargo=new Cargo(TypeCargo.LORRY,random.nextBoolean(),base);
            executorService.execute(cargo);
        }

    }

}
