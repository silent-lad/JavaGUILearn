package controlpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CreateBillboard extends JPanel implements ActionListener{
    JButton SUBMIT;
    JPanel panel;
    JLabel heading, messageLabel, imageTypeLabel,imageString,informationLabel;
    JTextField messageField,imageStringField;
    JTextArea informationField;
    JRadioButton urlImage,encodedImage;
    JButton createButton, previewButton;

    CreateBillboard() {

        heading = new JLabel();
        heading.setText("Create Billboard");
        heading.setFont(new Font("Arial", Font.PLAIN, 25));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        messageLabel = new JLabel();
        messageLabel.setText("Message:");
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageField = new JTextField(15);
        messageField.setMaximumSize( messageField.getPreferredSize() );
        messageField.setAlignmentX(Component.CENTER_ALIGNMENT);

        informationLabel = new JLabel();
        informationLabel.setText("Information:");
        informationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        informationField = new JTextArea();
        informationField.setMaximumSize( messageField.getPreferredSize() );
        informationField.setAlignmentX(Component.CENTER_ALIGNMENT);

        imageTypeLabel = new JLabel();
        imageTypeLabel.setText("Image:");
        imageTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        urlImage = new JRadioButton("url");
        urlImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        encodedImage = new JRadioButton("enocoded");
        encodedImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        ButtonGroup group = new ButtonGroup();
        group.add(urlImage);
        group.add(encodedImage);

        imageString = new JLabel();
        imageString.setText("Image:");
        imageString.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageStringField = new JPasswordField(15);
        imageStringField.setMaximumSize( imageStringField.getPreferredSize() );
        imageStringField.setAlignmentX(Component.CENTER_ALIGNMENT);

        createButton = new JButton("Create");
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        previewButton = new JButton("Preview");
        previewButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        add(heading);
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
        setLayout(
                new BoxLayout(this, BoxLayout.PAGE_AXIS)
        );
        setSize(500,500);
        setVisible(true);
        createButton.addActionListener(this);
        previewButton.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae) {

    }

}
