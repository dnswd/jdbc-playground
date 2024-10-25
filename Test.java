import java.sql.*;
import java.util.Properties;

class Test
{
    public static void main(String[] args)
    {
        String url = "jdbc:postgresql://127.0.0.1:5432/sample";
        Properties properties = new Properties();
        properties.setProperty("user", "halcyon");
        //properties.setProperty("password", "postgres");
        // extended is the default
        // properties.setProperty("preferQueryMode", "extended");
        
        try
        {
            Connection connection = DriverManager.getConnection(url, properties);
            //Connection connection = DriverManager.getConnection(url);
            // -- 
            ResultSet result;
            Statement statement = connection.createStatement();
            result = statement.executeQuery("select now()");
            result.next();
            result.close();
            // --
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
