package edu.hw2.task3.connection_manager;

import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection.FaultyConnection;
import edu.hw2.task3.connection.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {

    private static final Random RANDOM = new Random();

    @Override
    public Connection getConnection() {
        if (RANDOM.nextInt(2) % 2 == 0) {
            return new StableConnection();
        } else {
            return new FaultyConnection();
        }
    }
}
