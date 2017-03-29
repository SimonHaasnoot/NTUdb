package Gui;

import Connection.Database;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class TableView extends JPanel {

    private JTable table;

    private DefaultTableModel defaultTableModel;

    public TableView(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Table", TitledBorder.CENTER, TitledBorder.TOP));

        CreateTableView();
    }

    public void CreateTableView(){

        defaultTableModel = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
                return false;
            }};

        //add the model to a table and a ScrollPane
        table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }

    public void UpdateTableView(String query) throws SQLException {

        //create connection to database
        Connection conn = Database.getConnection();

        //make your query
        Statement statement = conn.createStatement();

        //get ResultSet after entering your query
        ResultSet result = statement.executeQuery(query);

        //remove all rows(refresh)
        if(table != null) {
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
        }

        //remove all columns(refresh)
        defaultTableModel.setColumnCount(0);


        //add all column names to the model
        for (int i = 0; i < result.getMetaData().getColumnCount(); i++) {
            defaultTableModel.addColumn(result.getMetaData().getColumnName(i + 1));
        }

        //while the resultSet has rows, add them to the model
        while(result.next())
        {
            Object[] row = new Object[result.getMetaData().getColumnCount()];
            for (int i = 1; i <= result.getMetaData().getColumnCount(); i++)
            {
                row[i - 1] = result.getObject(i);
            }
            defaultTableModel.insertRow(result.getRow()-1,row);
        }
    }
}
