package Gui;


import Connection.Database;
import Util.CustomFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class OnlineConnectionFrame {

    public OnlineConnectionFrame(){


        CustomFrame frame = new CustomFrame(300, 250);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder((BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Online", TitledBorder.CENTER, TitledBorder.TOP)));

        GridBagConstraints c = new GridBagConstraints();

        c.gridy = 0;
        c.gridx = 0;
        c.insets = new Insets(8, 8, 8, 8);
        JLabel label = new JLabel("Username");
        panel.add(label, c);

        c.gridy = 0;
        c.gridx = 1;
        JTextField usernameInput = new JTextField();
        usernameInput.setPreferredSize(new Dimension(120, 20));
        panel.add(usernameInput, c);

        c.gridy = 1;
        c.gridx = 0;
        JLabel label2 = new JLabel("Password");
        panel.add(label2, c);

        c.gridy = 1;
        c.gridx = 1;
        JTextField passwordInput = new JTextField();
        passwordInput.setPreferredSize(new Dimension(120, 20));
        panel.add(passwordInput, c);


        c.gridy = 2;
        c.gridx = 0;
        JLabel label3 = new JLabel("Server");
        panel.add(label3, c);

        c.gridy = 2;
        c.gridx = 1;
        JTextField serverInput = new JTextField();
        serverInput.setPreferredSize(new Dimension(120, 20));
        panel.add(serverInput, c);

        c.gridy = 3;
        c.gridx = 0;
        JLabel label4 = new JLabel("Database");
        panel.add(label4, c);

        c.gridy = 3;
        c.gridx = 1;
        JTextField databaseInput = new JTextField();
        databaseInput.setPreferredSize(new Dimension(120, 20));
        panel.add(databaseInput, c);

        c.gridy = 4;
        c.gridx = 0;
        JButton preset = new JButton("preset");
        preset.addActionListener( a -> {
            usernameInput.setText("cringerxd");
            passwordInput.setText("Piskut123");
            serverInput.setText("p7db.database.windows.net:1433");
            databaseInput.setText("p7db");
        });
        panel.add(preset, c);

        c.gridy = 4;
        c.gridx = 1;
        JButton connect = new JButton("connect");
        connect.addActionListener(a -> {
            String url = "jdbc:sqlserver://" + serverInput.getText() + ";database="+ databaseInput.getText() +
                    ";user=" + usernameInput.getText() + ";password=" + passwordInput.getText() + ";";
            Database.Initialize(url, frame);
        });

        panel.add(connect, c);
        frame.add(panel);
    }
}
