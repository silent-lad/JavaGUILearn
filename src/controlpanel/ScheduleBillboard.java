package controlpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ScheduleBillboard extends JPanel{
    JButton SUBMIT;
    JPanel panel;
    JLabel label1, label2;

    ScheduleBillboard() {
        label1 = new JLabel();
        label1.setText("SCHEDULE BILLBOARD");
        setBackground(Color.orange);
        add(label1);
    }
}
