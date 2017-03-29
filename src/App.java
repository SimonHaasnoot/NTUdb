import Connection.Database;
import Gui.Client;

public class App {

    public static void main(String[] args) {

        System.out.println("Initializing connection.");

        Database.Initialize();
        new Client();
    }
}
