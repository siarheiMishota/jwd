package by.mishota.graduation.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static String url = "jdbc:mysql://localhost:3306/commission?useUnicode=true&serverTimezone=UTC";
    private static String login = "root";
    private static String password = "root";

    private static Logger logger = LogManager.getLogger();
    private static ConnectionPool instance;

    private BlockingQueue<Connection> free;

    private ConnectionPool() throws SQLException {
        free = new ArrayBlockingQueue<Connection>(12, true);

        for (int i = 0; i < free.size(); i++) {
            free.offer(DriverManager.getConnection(url, login, password));
        }
    }

    public static ConnectionPool getInstance() throws SQLException {

        if (instance == null) {
            Lock instanceLock = new ReentrantLock();
            try {
                instanceLock.lock();

                if (instance == null) {
                    instance = new ConnectionPool();
                }
            } finally {
                instanceLock.unlock();
            }
        }
        return instance;
    }


    public Connection getConnection() throws SQLException, InterruptedException {

        Connection connection;
        if (free.isEmpty()) {
            connection = DriverManager.getConnection(url, login, password);
        } else {
            connection = free.take();
        }
        return connection;
    }

    public void closeConnection(Connection connection) {
        free.offer(connection);
    }

}
