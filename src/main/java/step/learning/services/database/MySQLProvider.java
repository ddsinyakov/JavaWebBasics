package step.learning.services.database;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLProvider implements DataBaseProvider{

    String connectionString = "jdbc:mysql://localhost:3306/javaTest?useUnicode=true&characterEncoding=UTF-8";

    String userName = "dima";
    String password = "qwerty";

    private Connection connection;
    private Driver mysqlDriver;


    @Override
    public Connection getConnection() {
        if (connection == null) {
            try {
                mysqlDriver = new Driver();
                DriverManager.registerDriver(mysqlDriver);

                connection = DriverManager.getConnection(connectionString, userName, password);
            } catch (SQLException e) {
                System.out.println("MySqlProvider::getConnection() -- " + e.getMessage());
            }
        }
        return connection;
    }
}
