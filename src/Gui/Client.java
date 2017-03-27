package Gui;

import javax.swing.*;
import java.awt.*;

public class Client {

    private JFrame client;

    public Client(){

       JFrame client = setupFrame();
       client.add(setupPanel());
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

    public JPanel setupPanel(){

        GridBagConstraints c = new GridBagConstraints();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JButton test = new JButton("This is a test button!");

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.insets = new Insets(0, 0, 0, 0);

        panel.add(test, c);

        JButton test2 = new JButton("This is a second test button!");

        c.gridy = 1;
        c.gridx = 0;

        panel.add(test2, c);


        panel.add(test);
        return panel;
    }
}
