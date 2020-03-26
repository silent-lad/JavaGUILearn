package controlpanel;

import common.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EditUser extends JPanel{
    int userCount;
    JCheckBox form[][];
    String permissions[] = { "User Permission", "EDIT USER", "CREATE BB", "EDIT ALL BB", "SCHEDULE BB", "DELETE USER", "EDIT PASSWORD" };
    String users[] ;
    String token;
    User loggedInUser;

    EditUser(String token,User loggedInUser) {
        this.token = token;
        this.loggedInUser = loggedInUser;
        //Fetch the users from the db; and populate the local variables
        GetUsers();

        setSize(800, 400);
        setLayout(new GridLayout(13, 7, 10, 0));
        setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

        for (int row = 0; row < 13; row++) {
            for (int col = 0; col < 7; col++) {
                if (row == 0) {
                    JLabel TopRowLabel = new JLabel(permissions[col]);
                    TopRowLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                    add(TopRowLabel,SwingConstants.CENTER);
                } else {
                    if (col == 0) {
                        JLabel TopColLabel = new JLabel(users[row - 1],SwingConstants.CENTER);
                        TopColLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        add(TopColLabel);
                    } else if(col<5) {
                        form[row - 1][col - 1] = new JCheckBox();
                        add(form[row - 1][col - 1]);

                    } else if(col ==5){
                         add(new JButton("DELETE"));
                    } else {
                        if(loggedInUser.isAllowedTo("edit_user")) //check if the user is himself or admin
                        {
                            add(new JButton("EDIT USER"));
                        }else {
                            add(new JLabel("ACCESS DENIED"),SwingConstants.CENTER);
                        }

                    }
                }
            }
        }
    }
    public void GetUsers(){
        // This data will come from servers, server connection logic goes here.
        // Use the USER model instead of this logic.
        int userCountFromServer = 12;
        String userArrayFromServer[] = { "Zeegaroot", "admin", "John",
                "Matthew", "ahmed", "aziz", "pat",
                "admin2", "admin2", "admin3", "admin4",
                "admin5" };

        userCount = userCountFromServer;
        users = userArrayFromServer;

        form = new JCheckBox[userCount][5];
     }
}
