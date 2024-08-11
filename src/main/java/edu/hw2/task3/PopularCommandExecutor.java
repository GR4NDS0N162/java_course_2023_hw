package edu.hw2.task3;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection_manager.ConnectionManager;
import edu.hw2.task3.connection_manager.FaultyConnectionManager;
import edu.hw2.task3.exception.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PopularCommandExecutor {

    private static final Logger LOGGER = LogManager.getLogger();

    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public static void main(String[] args) {
        var commandExecutor = new PopularCommandExecutor(new FaultyConnectionManager(), 5);
        try {
            commandExecutor.updatePackages();
        } catch (ConnectionException e) {
            LOGGER.error("Не удалось выполнить команду спустя все попытки");
        }
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void removeUnusedDependencies() {
        tryExecute("apt autoremove -y");
    }

    void tryExecute(String command) throws ConnectionException {
        try (Connection connection = manager.getConnection()) {
            for (int i = 1; i <= maxAttempts; i++) {
                try {
                    connection.execute(command);
                    LOGGER.info("Команда `%s` успешно выполнена с %d-й попытки".formatted(command, i));
                    break;
                } catch (ConnectionException e) {
                    LOGGER.error("Команда `%s` не выполнена с %d-й попытки".formatted(command, i));
                    if (i == maxAttempts) {
                        throw new ConnectionException(e);
                    }
                }
            }
        } catch (ConnectionException e) {
            throw e;
        } catch (Exception e) {
            LOGGER.info("Не удалось закрыть соединение");
        }
    }
}
