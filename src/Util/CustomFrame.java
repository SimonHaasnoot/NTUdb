package Util;

import javax.swing.*;
import java.awt.*;

public class CustomFrame extends JFrame {

    public CustomFrame(int width, int height){

        this.setSize(new Dimension(width, height));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
    }
}
