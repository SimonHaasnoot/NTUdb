package Gui;

import Util.CustomFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ConnectionFrame  {

    public ConnectionFrame(){
        CreateSelectGUI();
    }

    public void CreateSelectGUI(){

        CustomFrame frame = new CustomFrame(200, 200);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Database login", TitledBorder.CENTER, TitledBorder.TOP));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        JButton localB = new JButton("Use local connection");
        localB.addActionListener( a -> {
            frame.dispose();
            new LocalConnectionFrame();
        });
        JButton onlineB = new JButton("Use online connection");
        onlineB.addActionListener( a -> {
            frame.dispose();
            new OnlineConnectionFrame();
        });

        c.gridy = 0;
        c.insets = new Insets(8, 8, 16,8);
        panel.add(localB, c);

        c.gridy = 1;
        panel.add(onlineB, c);
        frame.add(panel);
    }
}
