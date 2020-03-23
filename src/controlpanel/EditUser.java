package controlpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EditUser extends JPanel{
    int userCount;
    JCheckBox form[][];
    JButton deleteButtons[];
    JButton editPassword[];
    String permissions[] = { "User Permission", "EDIT USER", "CREATE BB", "EDIT ALL BB", "SCHEDULE BB", "DELETE USER", "EDIT PASSWORD" };
    String users[] ;

    EditUser() {
        //Fetch the users from the db; and populate the local variables
        GetUsers();

        setSize(8 00, 400);
        setLayout(new GridLayout(13, 7, 10, 0));
        for (int row = 0; row < 13; row++) {
            //ButtonGroup bg = new ButtonGroup();
            for (int col = 0; col < 7; col++) {
                if (row == 0) {
                    add(new JLabel(permissions[col]));
                } else {
                    if (col == 0) {
                        add(new JLabel(users[row - 1]));
                    } else if(col<5) {
                        form[row - 1][col - 1] = new JCheckBox();
                        //bg.add(form[row - 1][col - 1]);
                        add(form[row - 1][col - 1]);
                    } else if(col ==5){
                         add(new JButton("DELETE"));
                    } else {
                        if(true) //check if the user is himself or admin
                        {
                            add(new JButton("EDIT PASSWORDS"));
                        }else {
                            add(new JLabel("ACCESS DENIED"));
                        }

                    }
                }
            }
        }
    }
    public void GetUsers(){
        // This data will come from servers, server connection logic goes here.
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
