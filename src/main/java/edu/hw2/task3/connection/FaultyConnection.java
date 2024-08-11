package edu.hw2.task3.connection;

import edu.hw2.task3.exception.ConnectionException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Random RANDOM = new Random();

    private static final double ERROR_PROBABILITY = 0.8;

    @Override
    public void execute(String command) throws ConnectionException {
        LOGGER.info(command);
        if (RANDOM.nextDouble() < ERROR_PROBABILITY) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() {
        LOGGER.info("Закрываем нестабильное соединение");
    }
}
