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

        c.insets = new Insets(8, 8, 8, 8);
        JButton b1 = new JButton("Opzegredenen");
        b1.addActionListener(e -> client.RefreshTable("SELECT * FROM opzegreden"));

        JButton b2 = new JButton("Medewerkers");
        b2.addActionListener(e -> client.RefreshTable("SELECT * FROM Medewerker"));

        JButton b3 = new JButton("niks");
        b3.addActionListener(e -> client.RefreshTable("SELECT * FROM Medewerker"));

        JButton b4 = new JButton("niks");
        b4.addActionListener(e -> client.RefreshTable("SELECT * FROM Medewerker"));

        JTextArea ta = new JTextArea(3, 16);
        ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton b5 = new JButton("run query");
        b5.addActionListener(e -> client.RefreshTable(ta.getText()));


        this.add(b1, c);
        this.add(b2, c);
        this.add(b3, c);
        this.add(b4, c);
        this.add(ta, c);
        this.add(b5, c);
    }


}

