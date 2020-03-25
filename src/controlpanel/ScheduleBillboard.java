package controlpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ScheduleBillboard extends JPanel{
    JButton SUBMIT;
    JPanel panel;
    JLabel label1, label2;

//    7 Lists of billboard with billboardListPerDay[0] as today's schedule list
    JList[] billboardListPerDay = new JList[7];

    ScheduleBillboard() {
        label1 = new JLabel();
        label1.setText("SCHEDULE BILLBOARD");
        setBackground(Color.orange);
        add(label1);
    }

    public void getDataFromServer() {

    }
}
