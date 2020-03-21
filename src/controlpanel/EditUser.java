package controlpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EditUser extends JPanel{
    JCheckBox form[][] = new JCheckBox[12][5];
    String permissions[] = { "User Permission", "EDIT USER", "CREATE BB", "EDIT ALL BB", "SCHEDULE BB" };
    String users[] = { "Zeegaroot", "admin", "John",
            "Matthew", "ahmed", "aziz", "pat",
            "admin2", "admin2", "admin3", "admin4",
            "admin5" };

    EditUser() {
        setSize(600, 400);
        setLayout(new GridLayout(13, 5, 10, 0));
        for (int row = 0; row < 13; row++) {
            ButtonGroup bg = new ButtonGroup();
            for (int col = 0; col < 5; col++) {
                if (row == 0) {
                    add(new JLabel(permissions[col]));
                } else {
                    if (col == 0) {
                        add(new JLabel(users[row - 1]));
                    } else {
                        form[row - 1][col - 1] = new JCheckBox();
                        bg.add(form[row - 1][col - 1]);
                        add(form[row - 1][col - 1]);
                    }
                }
            }
        }
    }
}
