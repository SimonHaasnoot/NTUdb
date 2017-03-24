package Gui;

import javax.swing.*;
import java.awt.*;

public class Client {

    public Client(){

       JFrame client = setupFrame();
    }

    public JFrame setupFrame(){

        JFrame frame = new JFrame();

        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);

        frame.setMinimumSize(new Dimension(800, 600));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return frame;
    }
}
