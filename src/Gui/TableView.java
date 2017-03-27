package Gui;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TableView extends JPanel {

    public TableView(){
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Table", TitledBorder.CENTER, TitledBorder.TOP));
    }
}
