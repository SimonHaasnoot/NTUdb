package Gui;

import Connection.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {

    private TableView tableView;

    private QueryView queryView;

    public Client(){

       JFrame client = SetupFrame();
       client.setLayout(new BorderLayout(8, 8));

       tableView = new TableView();
       queryView = new QueryView();

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


    /**
     * Method to fill a JTable with the ResultSet of a query
     * @param query
     * @param table
     * @throws SQLException
     */
    public void FillTable(String query, JTable table) throws SQLException {

        //create connection to database
        Connection conn = Database.getConnection();

        //make your query
        Statement statement = conn.createStatement();

        //get ResultSet after entering your query
        ResultSet result = statement.executeQuery(query);

        while(table.getRowCount() > 0)
        {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        int columns = result.getMetaData().getColumnCount();
        while(result.next())
        {
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++)
            {
                row[i - 1] = result.getObject(i);
            }
            ((DefaultTableModel) table.getModel()).insertRow(result.getRow()-1,row);
        }
    }

}
