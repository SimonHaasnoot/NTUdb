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
        serverInput.setPreferredSize(new Dimension(144, 20));
        c.gridy = 1;
        panel.add(serverInput, c);

        c.gridy = 2;

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        panel.add(buttonPanel, c);

        JButton connect = new JButton("Connect");
        connect.addActionListener(a -> {
            String localdb = serverInput.getText();
            String localUrl = "jdbc:sqlserver://localhost:1433;databaseName=" + localdb + ";integratedSecurity=true;";
            Database.Initialize(localUrl, frame);
        });
        buttonPanel.add(connect, BorderLayout.EAST);

        JButton back = new JButton("Back");
        back.addActionListener(a -> {
            frame.dispose();
            new ConnectionFrame();
        });
        buttonPanel.add(back, BorderLayout.WEST);

        frame.add(panel);
    }
}
