package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcella
 */
public class ConnectionFactory 
{
    private String User     = "root";
    private String Password = "";
    private String Url = "jdbc:mysql://localhost/fj21";
    
    
    public Connection getConnection()
    {
    
        try
        {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(Url, User, Password);
        }
        catch(SQLException e)
        {
            throw new RuntimeException("Error: " + e);
        }
    }
    
}
