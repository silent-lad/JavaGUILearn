package controlpanel;

import common.models.Billboard;
import common.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/***
 * The EditBillboard class extends Jpanel as it will be shown on Dashboard JFrame
 * well as GUI functions.
 * implements ActionListener to listen for form submission
 */
class EditBillboard extends JPanel implements ActionListener{

    JLabel formHeading, messageLabel, imageTypeLabel,imageString,informationLabel;
    JTextField messageField,imageStringField;
    JTextArea informationField;
    JRadioButton urlImage,encodedImage;
    JButton createButton, previewButton;
    User loggedInUser;
    String token;

    /***
     * The Dahboard class extends Jpanel as it will be shown on Dashboard JFrame
     * well as GUI functions.
     * implements ActionListener to listen for form submission
     */
    EditBillboard(String token, User loggedInUser, Billboard billboard) {


        this.token = token;
        this.loggedInUser = loggedInUser;

        formHeading = new JLabel();
        formHeading.setText("Edit Billboard");
        formHeading.setFont(new Font("Arial", Font.PLAIN, 25));
        formHeading.setAlignmentX(Component.CENTER_ALIGNMENT);

        messageLabel = new JLabel();
        messageLabel.setText("Message:");
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageField = new JTextField(billboard.message,15);
        messageField.setMaximumSize( messageField.getPreferredSize() );
        messageField.setAlignmentX(Component.CENTER_ALIGNMENT);

        informationLabel = new JLabel();
        informationLabel.setText("Information:");
        informationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        informationField = new JTextArea(billboard.information);
        informationField.setMaximumSize( messageField.getPreferredSize() );
        informationField.setAlignmentX(Component.CENTER_ALIGNMENT);

        imageTypeLabel = new JLabel();
        imageTypeLabel.setText("Image:");
        imageTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        urlImage = new JRadioButton("url");
        urlImage.setSelected(billboard.isUrl);
        urlImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        encodedImage = new JRadioButton("enocoded");
        encodedImage.setSelected(!billboard.isUrl);
        encodedImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Combining these 2 radio buttons in a group so if one gets selected other one gets unselected.
        ButtonGroup group = new ButtonGroup();
        group.add(urlImage);
        group.add(encodedImage);

        imageString = new JLabel();
        imageString.setText("Image:");
        imageString.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageStringField = new JTextField(billboard.imageString,15);
        imageStringField.setMaximumSize( imageStringField.getPreferredSize() );
        imageStringField.setAlignmentX(Component.CENTER_ALIGNMENT);

        createButton = new JButton("Save Changes");
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        previewButton = new JButton("Preview");
        previewButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Creating the layout.
        add(formHeading);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(messageLabel);
        add(messageField);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(informationLabel);
        add(informationField);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(imageTypeLabel);
        add(urlImage);
        add(encodedImage);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(imageString);
        add(imageStringField);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(createButton);
        add(previewButton);
        // Using Boxlayout.
        setLayout(
                new BoxLayout(this, BoxLayout.PAGE_AXIS)
        );
        setSize(500,500);
        setVisible(true);
        createButton.addActionListener(this);
        previewButton.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae) {
        // user token available here for making requests to the server.
        System.out.println(token);
    }

}
