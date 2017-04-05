package Gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class QueryView extends JPanel {

    private Client client;

    public QueryView(Client client){
        this.client = client;
//        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SQL", TitledBorder.CENTER, TitledBorder.TOP));

        this.setLayout(new GridLayout(1, 2, 8, 8));

        this.add(CreateStandardQueryLayout());
        this.add(CreateCustomQueryLayout());

//        Init();
    }

    private JPanel CreateStandardQueryLayout(){

        JPanel p1 = new JPanel();
        p1.setLayout(new GridBagLayout());
        p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Standard Queries", TitledBorder.CENTER, TitledBorder.TOP));

        CreateStandardQueryComponents(p1);

        return p1;
    }

    private JPanel CreateCustomQueryLayout(){

        JPanel p2 = new JPanel();
        p2.setLayout(new GridBagLayout());
        p2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Custom Queries", TitledBorder.CENTER, TitledBorder.TOP));

        CreateCustomQueryComponenets(p2);

        return p2;
    }

    private void CreateStandardQueryComponents(JPanel p1) {

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(8, 8, 8, 8);
        c.gridx = 0;
        c.gridy = 0;
        JButton b1 = new JButton("Webhistorie");
        b1.addActionListener(e -> client.RefreshTable("SELECT * FROM webhistorie"));
        p1.add(b1, c);

        c.gridx = 0;
        c.gridy = 1;
        JButton b2 = new JButton("Medewerkers(Training)");
        b2.addActionListener(e -> client.RefreshTable("SELECT Medewerker.voornaam, Medewerker.achternaam, Training.cursus FROM Medewerker JOIN Training ON Training.medewerker = Medewerker.code"));
        p1.add(b2, c);
    }

    private void CreateCustomQueryComponenets(JPanel p2) {

        GridBagConstraints c = new GridBagConstraints();

        JTextArea ta = new JTextArea(3, 16);
        ta.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Query", TitledBorder.CENTER, TitledBorder.TOP));

        JButton b5 = new JButton("run SQL-SERVER query");
        b5.addActionListener(e -> client.RefreshTable(ta.getText()));

        c.gridx = 5;
        c.gridy = 0;
        c.insets = new Insets(8, 0, 8, 8);
        p2.add(b5, c);

        c.gridx = 5;
        c.gridy = 1;
        c.insets = new Insets(8, 0, 8, 8);
        p2.add(ta, c);
    }
}

