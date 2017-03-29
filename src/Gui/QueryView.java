package Gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class QueryView extends JPanel {

    private Client client;

    public QueryView(Client client){
        this.client = client;
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SQL", TitledBorder.CENTER, TitledBorder.TOP));

        Init();
    }

    private void Init() {
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(8, 96, 8, 8);
        c.gridx = 0;
        c.gridy = 0;
        JButton b1 = new JButton("Opzegredenen");
        b1.addActionListener(e -> client.RefreshTable("SELECT * FROM opzegreden"));
        this.add(b1, c);

        c.gridx = 0;
        c.gridy = 1;
        JButton b2 = new JButton("Medewerkers");
        b2.addActionListener(e -> client.RefreshTable("SELECT * FROM Medewerker"));
        this.add(b2, c);


        JTextArea ta = new JTextArea(3, 16);
        ta.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Query", TitledBorder.CENTER, TitledBorder.TOP));

        JButton b5 = new JButton("run SQL-SERVER query");
        b5.addActionListener(e -> client.RefreshTable(ta.getText()));

        c.gridx = 5;
        c.gridy = 0;
        c.insets = new Insets(8, 96, 8, 8);
        this.add(b5, c);

        c.gridx = 5;
        c.gridy = 1;
        c.insets = new Insets(8, 96, 8, 8);
        this.add(ta, c);
    }
}

