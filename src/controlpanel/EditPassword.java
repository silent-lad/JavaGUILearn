package controlpanel;

import common.models.User;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

class EditPassword extends JFrame implements ActionListener {
    JButton SUBMIT;
    JPanel loginPanel;
    JLabel usernameLabel, passwordLabel, heading;
    final JTextField usernameField, passwordField;
    User loggedInUser,user;
    String token;

    EditPassword(String token,User loggedInUser,User user) {
        this.token = token;
        this.loggedInUser = loggedInUser;
        this.user = user;

        heading = new JLabel();
        heading.setText("New Password");
        heading.setFont(new Font("Arial", Font.PLAIN, 25));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameLabel = new JLabel();
        usernameLabel.setText("Username:");
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameField = new JTextField(user.name,15);
        usernameField.setMaximumSize( usernameField.getPreferredSize() );
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Password Label and Field
        passwordLabel = new JLabel();
        passwordLabel.setText("New Password:");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField = new JPasswordField(15);
        passwordField.setMaximumSize( passwordField.getPreferredSize() );
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        //  Submit Button config
        SUBMIT = new JButton("SUBMIT");
        SUBMIT.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Addign action listener to fire actionPerformed function.
        SUBMIT.addActionListener(this);

        // Primary panel for the current JFrame.
        loginPanel = new JPanel();

        // Box Layout starts from here.
        loginPanel.add(heading);
        // Create Rigid Area for the vertical margin between components
        loginPanel.add(Box.createRigidArea(new Dimension(0,20)));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(Box.createRigidArea(new Dimension(0,10)));
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(Box.createRigidArea(new Dimension(0,20)));
        loginPanel.add(SUBMIT);

        // Setting Box Layout
        loginPanel.setLayout(
                new BoxLayout(loginPanel, BoxLayout.PAGE_AXIS)
        );
        loginPanel.setSize(500,500);
        loginPanel.setVisible(true);
        add(loginPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Edit Password");

    }

    public void actionPerformed(ActionEvent ae) {
        //Edit Password LOGIC
        String username = usernameField.getText();
        String password = passwordField.getText();

        //Hashing logic here

        // We already have the user and user_id
        String u_id = user.u_id;
        //Query the User table by U_id and update record with new password.
    }
}