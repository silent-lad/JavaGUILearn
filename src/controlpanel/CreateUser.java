package controlpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * The CreateUser class extends Jpanel as it will be shown on Dashboard JFrame
 * well as GUI functions.
 * implements ActionListener to listen for form submission
 */
class CreateUser extends JPanel implements ActionListener {

    JLabel formHeading, nameLabel, permissionsLabel,passwordLabel;
    JTextField nameField,passwordField;
    JCheckBox scheduleBillboard,editAllBillboards,createBillboard,editUsers;
    JButton createButton;
    String userToken;

    /***
     * The CreateUser class extends Jpanel as it will be shown on Dashboard JFrame
     * well as GUI functions.
     * implements ActionListener to listen for form submission
     */
    CreateUser(String token) {

        userToken = token;

        formHeading = new JLabel();
        formHeading.setText("Create User");
        formHeading.setFont(new Font("Arial", Font.PLAIN, 25));
        formHeading.setAlignmentX(Component.CENTER_ALIGNMENT);

        nameLabel = new JLabel();
        nameLabel.setText("Name:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameField = new JTextField(15);
        nameField.setMaximumSize( nameField.getPreferredSize() );
        nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordLabel = new JLabel();
        passwordLabel.setText("Image:");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField = new JPasswordField(15);
        passwordField.setMaximumSize( passwordField.getPreferredSize() );
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        permissionsLabel = new JLabel();
        permissionsLabel.setText("Permissions:");
        permissionsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        createBillboard = new JCheckBox("Create Billboards");
        createBillboard.setAlignmentX(Component.CENTER_ALIGNMENT);

        scheduleBillboard = new JCheckBox("Schedule Billboards");
        scheduleBillboard.setAlignmentX(Component.CENTER_ALIGNMENT);

        editAllBillboards = new JCheckBox("Edit All Billboards");
        editAllBillboards.setAlignmentX(Component.CENTER_ALIGNMENT);

        editUsers = new JCheckBox("Edit Users");
        editUsers.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Combining these 2 radio buttons in a group so if one gets selected other one gets unselected.

        createButton = new JButton("Create");
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Creating the layout.
        add(formHeading);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(nameLabel);
        add(nameField);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(passwordLabel);
        add(passwordField);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(permissionsLabel);
        add(createBillboard);
        add(scheduleBillboard);
        add(editAllBillboards);
        add(editUsers);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(createButton);
        // Using Boxlayout.
        setLayout(
                new BoxLayout(this, BoxLayout.PAGE_AXIS)
        );
        setSize(500,500);
        setVisible(true);
        createButton.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae) {
        // user token available here for making requests to the server.
        System.out.println(userToken);
    }

}

