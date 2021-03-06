package by.mishota.multithreading.entity;

import by.mishota.multithreading.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cargo implements Runnable {

    private int id;
    private TypeCargo type;
    private boolean perishable;

    private static Logger logger = LogManager.getLogger();

    public Cargo(TypeCargo type, boolean perishable) {
        this.type = type;
        this.perishable = perishable;
        id = Util.getGenerateCargoID();
    }

    public int getId() {
        return id;
    }

    public TypeCargo getType() {
        return type;
    }

    public boolean isPerishable() {
        return perishable;
    }

    @Override
    public void run() {
        Base base = Base.getInstance();
        Terminal terminal = null;

        try {
            logger.info(String.format("Cargo (%4d, %b ) waiting for terminal", id, perishable));

            terminal = base.getTerminal(this);
            logger.info(String.format("Cargo ( %4d, %b ) got a terminal (%4d)", id, perishable, terminal.getId()));

            terminal.load(this);

        } catch (InterruptedException e) {
            logger.warn(String.format("Exception load or unload cargo(%4d, %b) in terminal(%d)", id, perishable, terminal.getId()));
        } finally {
            base.releaseTerminal();
            logger.info(String.format("Terminal(%d) was realised",terminal.getId()));
        }
    }
}
