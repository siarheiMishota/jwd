package by.mishota.multithreading;

import by.mishota.multithreading.entity.Base;
import by.mishota.multithreading.entity.Cargo;
import by.mishota.multithreading.entity.Terminal;
import by.mishota.multithreading.exception.ReadingException;
import by.mishota.multithreading.factory.FactoryCargo;
import by.mishota.multithreading.reader.CargoReader;
import by.mishota.multithreading.reader.impl.CargoReaderFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args)  {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Base base = Base.getInstance();
        base.addTerminal(new Terminal());
        base.addTerminal(new Terminal());
        base.addTerminal(new Terminal());
        base.addTerminal(new Terminal());
        base.addTerminal(new Terminal());
        base.addTerminal(new Terminal());

        Path path = Path.of("file/cargoes.txt");
        CargoReader reader = new CargoReaderFile();
        List<String> reading = null;
        List<Cargo> cargoes;

        try {
            reading = reader.read(path);
        } catch (ReadingException e) {
            logger.error("File isn't found");
        }

        cargoes = FactoryCargo.createCargoes(reading);

        for (Cargo cargo:cargoes) {
            executorService.execute(cargo);
        }


    }

}
