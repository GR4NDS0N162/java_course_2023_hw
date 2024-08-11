package edu.hw2.task3.connection;

import edu.hw2.task3.ConnectionException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Random RANDOM = new Random();

    @Override
    public void execute(String command) throws ConnectionException {
        LOGGER.info(command);
        if (RANDOM.nextInt(2) % 2 == 0) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() {
        LOGGER.info("Закрываем нестабильное соединение");
    }
}
