
import java.sql.Connection;

public class DatabaseTest {

    public static void main(String[] args) {

        try (Connection connection =
                DatabaseConnection.getConnection()) {

            if (connection != null) {

                System.out.println(
                    "Database connected successfully!"
                );

                System.out.println(
                    "JDBC connection test successful!"
                );
            }

        } catch (Exception e) {

            System.out.println("Connection test failed!");
            e.printStackTrace();
        }
    }
}
