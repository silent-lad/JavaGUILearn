
package controlpanel;

import javax.swing.*;
import java.awt.*;


class ListBillboard extends JPanel {

    JCheckBox form[][] = new JCheckBox[12][5];
    String counts[] = { "", "0-1", "2-5", "6-10", "11-100", "101+" };
    String categories[] = { "Household", "Office", "Extended Family",
            "Company (US)", "Company (World)", "Team", "Will",
            "Birthday Card List", "High School", "Country", "Continent",
            "Planet" };

    ListBillboard() {

        setSize(600, 400);
        setLayout(new GridLayout(13, 6, 10, 0));
        for (int row = 0; row < 13; row++) {
            // ButtonGroup bg = new ButtonGroup();
            for (int col = 0; col < 6; col++) {
                if (row == 0) {
                    add(new JLabel(counts[col]));
                } else {
                    if (col == 0) {
                        add(new JLabel(categories[row - 1]));
                    } else {
                        form[row - 1][col - 1] = new JCheckBox();
//                        bg.add(form[row - 1][col - 1]);
                        add(form[row - 1][col - 1]);
                    }
                }
            }
        }
        CreateBillboard test = new CreateBillboard("");
        add(test);
    }
}

