
package controlpanel;

import javax.swing.*;
import java.awt.*;


class EditBillboard extends JPanel {
    JButton SUBMIT;
    JPanel panel;
    JLabel label1, label2;

    EditBillboard() {
        label1 = new JLabel();
        label1.setText("EDIT BILLBOARD");
        setBackground(Color.lightGray);
        add(label1);
    }
}

