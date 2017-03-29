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

        JButton b1 = new JButton("Opzegredenen");
        b1.addActionListener(e -> client.RefreshTable("SELECT * FROM opzegreden"));

        JButton b2 = new JButton("Medewerkers");
        b2.addActionListener(e -> client.RefreshTable("SELECT * FROM Medewerker"));

        JButton b3 = new JButton("test test");
        b3.addActionListener(e -> client.RefreshTable("SELECT * FROM Medewerker"));

        JButton b4 = new JButton("test test");
        b4.addActionListener(e -> client.RefreshTable("SELECT * FROM Medewerker"));

        JButton b5 = new JButton("test test");
        b5.addActionListener(e -> client.RefreshTable("SELECT * FROM Medewerker"));

        this.add(b1, c);
        this.add(b2, c);
        this.add(b3, c);
        this.add(b4, c);
        this.add(b5, c);
    }


}

