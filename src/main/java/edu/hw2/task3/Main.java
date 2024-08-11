package edu.hw2.task3;

import edu.hw2.task3.connection_manager.FaultyConnectionManager;
import edu.hw2.task3.exception.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        var commandExecutor = new PopularCommandExecutor(new FaultyConnectionManager(), 5);
        try {
            commandExecutor.updatePackages();
        } catch (ConnectionException e) {
            LOGGER.error("Не удалось выполнить команду спустя все попытки");
        }
    }
}
