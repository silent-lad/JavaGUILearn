package controlpanel;

import common.models.User;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

class LoginWindow extends JFrame implements ActionListener {
        JButton SUBMIT;
        JPanel loginPanel;
        JLabel usernameLabel, passwordLabel, heading;
        final JTextField usernameField, passwordField;

        LoginWindow() {
                heading = new JLabel();
                heading.setText("LOGIN");
                heading.setFont(new Font("Arial", Font.PLAIN, 25));
                heading.setAlignmentX(Component.CENTER_ALIGNMENT);

                usernameLabel = new JLabel();
                usernameLabel.setText("Username:");
                usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                usernameField = new JTextField(15);
                usernameField.setMaximumSize( usernameField.getPreferredSize() );
                usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

                // Password Label and Field
                passwordLabel = new JLabel();
                passwordLabel.setText("Password:");
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
                setTitle("LOGIN FORM");

        }

        public void actionPerformed(ActionEvent ae) {
                //LOGIN LOGIC
                String username = usernameField.getText();
                String password = passwordField.getText();

                //Hashing logic here

                if (username.equals("") && password.equals("")) {
                        String token = "sdfasdf";
                        User loggedInUser = new User();
                        loggedInUser.getUserByName(username);
                        //passing mock token to Dashboard, so that it can make requests to server
                        new Dashboard(token,loggedInUser);
                        // Disposing the Login JFrame as it's work is done.
                        dispose();

                } else {
                        // Logic for error dialogbox which shows if login fails with custom message.
                        System.out.println("enter the valid username and password");
                        JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                }
        }
}