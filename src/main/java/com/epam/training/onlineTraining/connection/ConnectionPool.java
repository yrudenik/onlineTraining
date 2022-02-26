package com.epam.training.onlineTraining.connection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static final int MAX_CONNECTIONS = 10;

    private static ConnectionPool INSTANCE;

    private final Queue<ProxyConnection> availableConnections;
    private final Queue<ProxyConnection> connectionsInUse;

    private static final ReentrantLock connectionsLock = new ReentrantLock();

    private final ConnectionFactory connectionFactory = new ConnectionFactory();

    private ConnectionPool() throws SQLException, IOException, ClassNotFoundException {
        availableConnections = new ArrayDeque<>();
        connectionsInUse = new ArrayDeque<>();
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            ProxyConnection connection = connectionFactory.create();
            availableConnections.offer(connection);
        }
    }

    public static ConnectionPool getInstance() throws SQLException, IOException, ClassNotFoundException {
        ConnectionPool localInstance = INSTANCE;
        if (localInstance == null) {
            connectionsLock.lock();
            try {
                localInstance = INSTANCE;
                if (localInstance == null) {
                    localInstance = INSTANCE = new ConnectionPool();
                }
            } finally {
                connectionsLock.unlock();
            }
        }
        return localInstance;
    }

    private void initConnections() {
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            ProxyConnection connection = connectionFactory.create();
            availableConnections.offer(connection);
        }
    }


    public void returnConnection(ProxyConnection connection) {
        connectionsLock.lock();
        try {
            if (connectionsInUse.contains(connection)) {
                availableConnections.offer(connection);
            }
        } finally {
            connectionsLock.unlock();
        }
    }

    public ProxyConnection getConnection() {
        connectionsLock.lock();
        try {
            ProxyConnection connection = availableConnections.remove();
            connectionsInUse.offer(connection);
            return connection;
        } finally {
            connectionsLock.unlock();
        }
    }

}
