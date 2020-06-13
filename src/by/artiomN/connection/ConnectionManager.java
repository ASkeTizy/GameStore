package by.artiomN.connection;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost/users?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static PoolProperties poolProperties=new PoolProperties();
    static {

        poolProperties.setUrl(URL);
        poolProperties.setUsername(USER);
        poolProperties.setPassword(PASSWORD);
        poolProperties.setDriverClassName("com.mysql.jdbc.Driver");

    }
    private static DataSource dataSource = new DataSource(poolProperties);


    public static Connection newConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
