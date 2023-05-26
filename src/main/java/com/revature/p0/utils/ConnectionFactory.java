package com.revature.p0.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static ConnectionFactory instance;
    private static Connection connection;

    private ConnectionFactory() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.postgresql.Driver");
        Properties properties = getProperties();
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
    }

    /* -----------------------Methods----------------------------- */

    public static ConnectionFactory getInstance() throws ClassNotFoundException, SQLException, IOException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() {
        // System.out.println("\nConnection: " + connection + "\n"); // keep for
        // debugging
        return connection;
    }

    /* ---------------------Helper Methods------------------------ */

    private Properties getProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream iStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (iStream == null) {
                throw new IOException("Unable to find application.properties");
            }
            properties.load(iStream);
        }
        return properties;
    }
}
