package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static Database instance = null;

    private Connection connection = null;

    public Database() {}

    public static void Initialize(String url, String username, String password) {

        if(instance == null)
        	instance = new Database();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            instance.connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't connect to the database.");
        }

        System.out.println("Connected to database");
    }
}
