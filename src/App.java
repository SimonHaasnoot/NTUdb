import Connection.Database;
import Gui.Client;

public class App {

    public static void main(String[] args) {

        System.out.println("Initializing connection...");
        String username = "cringerxd";
        String password = "Piskut123";
        String url = "jdbc:sqlserver://p7db.database.windows.net:1433;database=p7db;";
        Database.Initialize(url, username, password);

        new Client();
    }
}
