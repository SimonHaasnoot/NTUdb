package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private final static String username = "cringerxd";
    private final static String password = "Piskut123";
    private final static String server = "p7db.database.windows.net:1433";
    private final static String database = "p7db";
    private final static String url = "jdbc:sqlserver://" + server + ";database="+ database + ";";

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

    public static Connection getConnection(){
        return instance.connection;
    }
}
