package Gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class QueryView extends JPanel {

    public QueryView(){
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SQL", TitledBorder.CENTER, TitledBorder.TOP));

        Init();
    }

    private void Init() {
        GridBagConstraints c = new GridBagConstraints();


        JButton select = new JButton("Update table");

        this.add(select, c);
    }


}

