package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private final static String username = "cringerxd";
    private final static String password = "Piskut123";
    private final static String url = "jdbc:sqlserver://p7db.database.windows.net:1433;database=p7db;";

    private static Database instance = null;

    private Connection connection = null;

    public Database() {}

    public static void Initialize() {

        if(instance == null)
        	instance = new Database();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            instance.connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't connect to the database.");
            return;
        }

        System.out.println("Connected to database");
    }
}
