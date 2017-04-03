package Connection;

import Gui.Client;
import Gui.ConnectionFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static Database instance = null;

    private Connection connection = null;

    public Database() {}

    public static void Initialize(String connectionString, JFrame parent) {

        if(instance == null)
        	instance = new Database();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            instance.connection = DriverManager.getConnection(connectionString);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't connect to the database.");
            parent.dispose();
            new ConnectionFrame();
            return;
        }

        System.out.println("Connected to database.");
        parent.dispose();
        new Client();
    }

    public static Connection getConnection(){
        return instance.connection;
    }
}
