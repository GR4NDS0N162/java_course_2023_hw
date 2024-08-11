package edu.hw2.task3;

import edu.hw2.task3.connection_manager.ConnectionManager;

public class PopularCommandExecutor {

    private static final Logger LOGGER = LogManager.getLogger();

    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void removeUnusedDependencies() {
        tryExecute("apt autoremove -y");
    }

    void tryExecute(String command) {
        // TODO: Реализовать метод tryExecute(String command)
    }
}
