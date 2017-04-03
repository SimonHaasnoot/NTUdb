package Gui;


import Connection.Database;
import Util.CustomFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class LocalConnectionFrame {

    public LocalConnectionFrame(){

        CustomFrame frame = new CustomFrame(200, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder((BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Local", TitledBorder.CENTER, TitledBorder.TOP)));

        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;
        c.insets = new Insets(8, 8, 8, 8);
        JLabel label = new JLabel("Insert DB name below");
        panel.add(label, c);

        JTextField serverInput = new JTextField();
        serverInput.setPreferredSize(new Dimension(120, 20));
        c.gridy = 1;
        panel.add(serverInput, c);

        c.gridy = 2;
        JButton initDB = new JButton("Connect");
        initDB.addActionListener(a -> {

            String localdb = serverInput.getText();
            String localUrl = "jdbc:sqlserver://localhost:1433;databaseName=" + localdb + ";integratedSecurity=true;";
            Database.Initialize(localUrl, frame);
        });

        panel.add(initDB, c);
        frame.add(panel);
    }
}
