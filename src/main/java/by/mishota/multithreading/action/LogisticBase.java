package by.mishota.multithreading.action;

import by.mishota.multithreading.entity.Cargo;
import by.mishota.multithreading.entity.Terminal;
import by.mishota.multithreading.entity.Territory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LogisticBase {

    private List<Terminal> terminals;
    private Territory territory;
    private ExecutorService executorTerminals,executorCargoes;

    public LogisticBase(List<Terminal> terminals, Territory territory) {
        this.terminals = terminals;
        this.territory = territory;
        executorTerminals = Executors.newCachedThreadPool();
        runTerminals();
    }

    private void runTerminals() {
        for (Terminal terminal:terminals) {
            executorTerminals.execute(terminal);
        }
    }


    public Territory getTerritory() {
        return territory;
    }
}
