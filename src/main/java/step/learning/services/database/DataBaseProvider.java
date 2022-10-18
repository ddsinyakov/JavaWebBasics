package step.learning.services.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataBaseProvider {
    Connection getConnection();
}
