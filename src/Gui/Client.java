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

    private JFrame client;

    public Client(){

       JFrame client = setupFrame();
       client.add(setupPanel());
       client.setVisible(true); // needed for osx for whatever reason
    }

    public JFrame setupFrame() {

    	JFrame frame = new JFrame();

        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);

        frame.setMinimumSize(new Dimension(800, 600));

        frame.setLocationRelativeTo(null);
        return frame;
    }

    public JPanel setupPanel(){

        GridBagConstraints c = new GridBagConstraints();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JButton test = new JButton("This is a test button!");

        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.insets = new Insets(0, 0, 0, 0);

        panel.add(test, c);

        JButton test2 = new JButton("This is a second test button!");

        c.gridy = 1;
        c.gridx = 0;

        panel.add(test2, c);


        panel.add(test);
        return panel;
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
