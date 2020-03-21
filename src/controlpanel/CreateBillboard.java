package controlpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CreateBillboard extends JPanel implements ActionListener{
    JButton SUBMIT;
    JPanel panel;
    JLabel title, messageLabel, imageTypeLabel,imageString,informationLabel;
    JTextField messageField,imageStringField;
    JTextArea informationField;
    JRadioButton urlImage,encodedImage;
    JButton createButton, previewButton;

    CreateBillboard() {

        //setBackground(Color.yellow);
        setLayout(null);

        title = new JLabel("Create Billboard");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(150, 30);
        add(title);

        messageLabel = new JLabel("Message");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        messageLabel.setSize(150, 20);
        messageLabel.setLocation(50, 100);
        add(messageLabel);

        messageField = new JTextField();
        messageField.setFont(new Font("Arial", Font.PLAIN, 15));
        messageField.setSize(190, 20);
        messageField.setLocation(150, 100);
        add(messageField);

        imageTypeLabel = new JLabel("Image type");
        imageTypeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        imageTypeLabel.setSize(150, 20);
        imageTypeLabel.setLocation(50, 150);
        add(imageTypeLabel);

        urlImage = new JRadioButton("url");
        urlImage.setFont(new Font("Arial", Font.PLAIN, 15));
        urlImage.setSelected(true);
        urlImage.setSize(75, 20);
        urlImage.setLocation(150, 150);
        add(urlImage);

        encodedImage = new JRadioButton("encoded");
        encodedImage.setFont(new Font("Arial", Font.PLAIN, 15));
        encodedImage.setSelected(false);
        encodedImage.setSize(80, 20);
        encodedImage.setLocation(250, 150);
        add(encodedImage);

        imageString = new JLabel("Image Source");
        imageString.setFont(new Font("Arial", Font.PLAIN, 15));
        imageString.setSize(150, 20);
        imageString.setLocation(50, 200);
        add(imageString);

        imageStringField = new JTextField();
        imageStringField.setFont(new Font("Arial", Font.PLAIN, 15));
        imageStringField.setSize(190, 20);
        imageStringField.setLocation(150, 200);
        add(imageStringField);

        informationLabel = new JLabel("Information");
        informationLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        informationLabel.setSize(150, 20);
        informationLabel.setLocation(50, 230);
        add(informationLabel);

        informationField = new JTextArea();
        informationField.setFont(new Font("Arial", Font.PLAIN, 15));
        informationField.setSize(210, 50);
        informationField.setLocation(150, 230);
        add(informationField);

        createButton = new JButton("Create");
        createButton.addActionListener(this);
        createButton.setFont(new Font("Arial", Font.PLAIN, 15));
        createButton.setSize(190, 20);
        createButton.setLocation(50,400);
        add(createButton, BorderLayout.SOUTH);

        previewButton = new JButton("Preview");
        previewButton.addActionListener(this);
        previewButton.setFont(new Font("Arial", Font.PLAIN, 15));
        previewButton.setSize(190, 20);
        previewButton.setLocation(300, 400);
        add(previewButton, BorderLayout.SOUTH);

    }
    public void actionPerformed(ActionEvent ae) {

    }

}
