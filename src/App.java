import Gui.ConnectionFrame;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            System.out.println("Failed to set native GUI look and feel.");
        }

        System.out.println("Initializing connection.");
        new ConnectionFrame();
    }
}
