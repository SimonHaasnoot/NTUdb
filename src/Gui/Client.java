package Gui;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Client {

    private TableView tableView;

    private QueryView queryView;

    public Client(){

       JFrame client = SetupFrame();
       client.setLayout(new BorderLayout(8, 8));

       tableView = new TableView();
       queryView = new QueryView(this);

       client.add(tableView, BorderLayout.CENTER);
       client.add(queryView, BorderLayout.SOUTH);

       client.setVisible(true);
    }

    public JFrame SetupFrame() {

    	JFrame frame = new JFrame();

        frame.setPreferredSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 800));

        frame.setLocationRelativeTo(null);
        return frame;
    }

    public void RefreshTable(String query){
        try {
            tableView.UpdateTableView(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong with refreshing.");
        }
    }

}
