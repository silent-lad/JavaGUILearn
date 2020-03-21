package controlpanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

class LoginWindow extends JFrame implements ActionListener {
        JButton SUBMIT;
        JPanel panel;
        JLabel label1, label2, heading;
        final JTextField text1, text2;

        LoginWindow() {
                heading = new JLabel();
                heading.setText("LOGIN");
                heading.setFont(new Font("Arial", Font.PLAIN, 25));
                heading.setAlignmentX(Component.CENTER_ALIGNMENT);

                label1 = new JLabel();
                label1.setText("Username:");
                label1.setAlignmentX(Component.CENTER_ALIGNMENT);
                text1 = new JTextField(15);
                text1.setMaximumSize( text1.getPreferredSize() );
                text1.setAlignmentX(Component.CENTER_ALIGNMENT);


                label2 = new JLabel();
                label2.setText("Password:");
                label2.setAlignmentX(Component.CENTER_ALIGNMENT);
                text2 = new JPasswordField(15);
                text2.setMaximumSize( text2.getPreferredSize() );
                text2.setAlignmentX(Component.CENTER_ALIGNMENT);

                SUBMIT = new JButton("SUBMIT");
                SUBMIT.setAlignmentX(Component.CENTER_ALIGNMENT);

                panel = new JPanel();


                panel.add(heading);
                panel.add(Box.createRigidArea(new Dimension(0,20)));
                panel.add(label1);
                panel.add(text1);
                panel.add(Box.createRigidArea(new Dimension(0,10)));
                panel.add(label2);
                panel.add(text2);
                panel.add(Box.createRigidArea(new Dimension(0,20)));
                panel.add(SUBMIT);
                panel.setLayout(
                        new BoxLayout(panel, BoxLayout.PAGE_AXIS)
                );
                panel.setSize(500,500);
                panel.setVisible(true);
                add(panel);
                SUBMIT.addActionListener(this);
                setTitle("LOGIN FORM");

        }

        public void actionPerformed(ActionEvent ae) {
                String username = text1.getText();
                String password = text2.getText();

                if (username.equals("") && password.equals("")) {
                        String token = "sdfasdf";
                        new Dashboard(token);
                        dispose();

                } else {
                        System.out.println("enter the valid username and password");
                        JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                }
        }
}


//buttons = new Button [5];
//
//        for (int i = 0;i<5;i++) {
//        buttons[i] = new Button ("Button " + (i + 1));
//        add (buttons[i]);
//        }
