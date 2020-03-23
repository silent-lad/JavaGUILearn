
package controlpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class ListBillboard extends JPanel {

    private static final Insets EMPTY_INSETS = new Insets(0, 0, 0, 0);

    private static final String DEFAULT_SOURCE_CHOICE_LABEL = "BillBoards";

    private static final String DEFAULT_DEST_CHOICE_LABEL = "BillBoard Description";

    private JLabel sourceLabel;

    private JList sourceList;

    private SortedListModel sourceListModel;

    private JList destList;

    private SortedListModel destListModel;

    private JLabel destLabel;

    public ListBillboard() {
        initScreen();
    }


    private void initScreen() {
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new GridBagLayout());
        sourceLabel = new JLabel(DEFAULT_SOURCE_CHOICE_LABEL);
        sourceListModel = new SortedListModel();
        sourceList = new JList(sourceListModel);
        add(sourceLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                EMPTY_INSETS, 0, 0));
        add(new JScrollPane(sourceList), new GridBagConstraints(0, 1, 1, 5, .5,
                1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                EMPTY_INSETS, 0, 0));

//        addButton.addActionListener(new AddListener());

        destLabel = new JLabel(DEFAULT_DEST_CHOICE_LABEL);
        destListModel = new SortedListModel();
        destList = new JList(destListModel);
        add(destLabel, new GridBagConstraints(3, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                EMPTY_INSETS, 0, 0));
        add(new JScrollPane(destList), new GridBagConstraints(3, 1, 1, 5, .5,
                1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                EMPTY_INSETS, 0, 0));
    }

//    private class AddListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            Object selected[] = sourceList.getSelectedValues();
//            addDestinationElements(selected);
//            clearSourceSelected();
//        }
//    }
}

class SortedListModel extends AbstractListModel {

    SortedSet model;

    public SortedListModel() {
        model = new TreeSet();
    }

    public int getSize() {
        return model.size();
    }

    public Object getElementAt(int index) {
        return model.toArray()[index];
    }

}