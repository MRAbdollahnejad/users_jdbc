package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    public static Connection getConnection() {
        try {
            Connection connection= DriverManager.getConnection(
                    Config.URL_DB,
                    Config.USERNAME,
                    Config.PASSWORD);
            return connection;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

}
