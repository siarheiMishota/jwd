package by.mishota.multithreading.entity;

import by.mishota.multithreading.action.LogisticBase;
import by.mishota.multithreading.util.CargoUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cargo implements Runnable {

    private int id;
    private TypeCargo type;
    private boolean isQuicklyPerishable;
    private LogisticBase logisticBase;

    private static Logger logger= LogManager.getLogger();

    public Cargo(TypeCargo type, boolean isQuicklyPerishable, LogisticBase logisticBase) {
        this.type = type;
        this.isQuicklyPerishable = isQuicklyPerishable;
        this.logisticBase = logisticBase;
        id = CargoUtil.getGenerateId();
    }

    public int getId() {
        return id;
    }

    public TypeCargo getType() {
        return type;
    }

    public boolean isQuicklyPerishable() {
        return isQuicklyPerishable;
    }

    @Override
    public void run() {
        try {
            logisticBase.getTerritory().put(this);
            logger.info(String.format("The Car(%5d,%10s) was putted to the territory\n",id,type.toString()));
            System.out.println(String.format("The Car(%5d,%10s,%6b) was putted to the territory\n",id,type.toString(),isQuicklyPerishable));
        } catch (InterruptedException e) {
            logger.warn(String.format("Putting the Car(%5d,%10s) to the territory was interrupted - %s",id,type.toString(),e.toString()));
        }
    }
}
