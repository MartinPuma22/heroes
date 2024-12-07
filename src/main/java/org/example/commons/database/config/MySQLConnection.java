package org.example.commons.database.config;

import org.example.commons.util.PropertiesReaderUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

    private static Connection instance = null;

    public static Connection getConnection(){
        try {
            if (instance == null){
                Runtime.getRuntime().addShutdownHook(new ShutdownHook());

                String driver = PropertiesReaderUtil.getProperty("database.driver");
                String url = PropertiesReaderUtil.getProperty("database.url");
                String password = PropertiesReaderUtil.getProperty("database.password");
                String user = PropertiesReaderUtil.getProperty("database.user");

                Class.forName(driver);
                instance = DriverManager.getConnection(url,user,password);
            }
            return instance;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
    static class ShutdownHook extends Thread {
        public void run() {
            try {
                Connection connection = MySQLConnection.getConnection();
                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
