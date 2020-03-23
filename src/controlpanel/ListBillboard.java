
package controlpanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListBillboard extends JPanel {

    private static final Insets EMPTY_INSETS = new Insets(0, 0, 0, 0);

    private static final String DEFAULT_SOURCE_CHOICE_LABEL = "BillBoards";

    private static final String DEFAULT_DEST_CHOICE_LABEL = "BillBoard Description";

    private JLabel billboardListLabel = new JLabel("Billboard List");

    private JList billboardList;
    private String[] billboardLabels = {"new billboard","another billboard","example billboard"};
    int selection=0;

    private JPanel descriptionPanel;
    private JLabel descriptionLabel = new JLabel("Description");

    private String selectedBillboardMessage = "---";
    private String selectedBillboardInformation = "---";
    private String selectedBillboardImageType = "---";
    private String selectedBillboardImageString = "---";

    public ListBillboard() {
        initList();
        initDescriptionPanel();
    }


    private void initList() {
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new GridBagLayout());

        billboardList = new JList(billboardLabels); // Create the list
        billboardList.setSelectedIndex(selection); // Set initial selected index

        // Handle list selection changes
        billboardList.addListSelectionListener(new BillboardSelectionListener());

        add(billboardListLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                EMPTY_INSETS, 0, 0));
        add(new JScrollPane(billboardList), new GridBagConstraints(0, 1, 1, 5, .5,
                1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                EMPTY_INSETS, 0, 0));

    }

    private void initDescriptionPanel() {
        descriptionPanel = new JPanel();

        descriptionPanel.add(new JLabel("Billboard Message"));
        descriptionPanel.add(new JTextField(selectedBillboardMessage));

        descriptionPanel.add(new JLabel("Billboard Info"));
        descriptionPanel.add(new JTextField(selectedBillboardInformation));

        descriptionPanel.add(new JLabel("ImageType"));
        descriptionPanel.add(new JComboBox(new String[]{"url", "image"}));

        descriptionPanel.add(new JLabel("ImageUrl"));
        descriptionPanel.add(new JTextField(selectedBillboardImageString));

        descriptionPanel.add(new JButton("Edit Billboard"));

        descriptionPanel.setLayout(new GridLayout(5,2));
        descriptionPanel.setVisible(true);

        add(descriptionLabel, new GridBagConstraints(3, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                EMPTY_INSETS, 0, 0));
        add(descriptionPanel, new GridBagConstraints(3, 1, 1, 5, .5,
                1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                EMPTY_INSETS, 0, 0));
    }

    private class BillboardSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent billboardSelectionEvent){
            //You have the name of the billboard now query server to get the data
            System.out.println(billboardLabels[billboardList.getSelectedIndex()]);
            // Store the data inside and object and pass it to the follwoing variables to show in display
            selectedBillboardMessage = "Test data from server";
            selectedBillboardInformation = "Test data from server";
            selectedBillboardImageType = "Test data from server";
            selectedBillboardImageString = "Test data from server";

            remove(descriptionPanel);
            revalidate();
            repaint();
            initDescriptionPanel();
        }
    }
}
