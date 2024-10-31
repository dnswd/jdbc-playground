import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class Test {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://127.0.0.1:5432/sample";
        Properties properties = new Properties();
        properties.setProperty("user", "halcyon");
        // properties.setProperty("password", "postgres");
        // extended is the default
        // properties.setProperty("preferQueryMode", "extended");

        try {
            Connection connection = DriverManager.getConnection(url, properties);
            // -- one-off
            ResultSet result;
            Statement statement = connection.createStatement();

            // result = statement.executeQuery("select now()");
            // result.next();
            // result.close();

            // -- batch
            statement.execute("create table if not exists test(id int primary key, f1 text)");
            statement.execute("truncate table test");

            statement.addBatch("insert into test (id, f1) values (1, 'A')");
            statement.addBatch("insert into test (id, f1) values (2, 'B')");
            statement.addBatch("insert into test (id, f1) values (3, 'C')");

            for (int i = 4; i < 1000; i++) {
                statement.addBatch("insert into test (id, f1) values (" + i + ", 'C')");
            }

            System.out.println("DONE");
            statement.executeBatch();
            statement.close();
            // --
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
