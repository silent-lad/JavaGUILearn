package controlpanel;

import common.models.Billboard;
import common.models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

class ScheduleBillboard extends JPanel{
    JButton SUBMIT;
    JPanel panel;
    JLabel label1, label2;
    User loggedInUser;
    String token;

    private static final Insets EMPTY_INSETS = new Insets(0, 0, 0, 0);

//    7 Lists of billboard with billboardListPerDay[0] as today's schedule list
    JList[] billboardListPerDay = new JList[7];

    Billboard[] dayBillboards;


    ScheduleBillboard(String token,User loggedInUser) {
        this.token = token;
        this.loggedInUser = loggedInUser;
        label1 = new JLabel();
        label1.setText("SCHEDULE BILLBOARD");
        setBackground(Color.orange);
        add(label1);
        getBillBoardsData();
        initDays();
    }

    public void initDays(){
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new GridBagLayout());

        for(int i=0;i<7;i++){

            add(new JScrollPane(billboardListPerDay[i]), new GridBagConstraints(i%3, i/3, 1, 1, 1,
                    1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    EMPTY_INSETS, 0, 0));
        }


    }

    public void getBillBoardsData() {
        // get List of all billboards in the database
        // code below will segregate it datewise
        String [] billboardIDsFromServer = {"123","q234","45"};
        Billboard[] AllBillboards = new Billboard[billboardIDsFromServer.length];
        for(int l=0;l<billboardIDsFromServer.length;l++) {
            Billboard ex = new Billboard();
            ex.getBillboardByBId(billboardIDsFromServer[l]);
            AllBillboards[l]=ex;
        }

        // Get billboard scheduled for each day
        for(int k=0;k<7;k++){
            dayBillboards = new Billboard[billboardIDsFromServer.length];
            for(int j=0;j<AllBillboards.length;j++){
                System.out.println(AllBillboards[j].message);
                Billboard currentBillboard = AllBillboards[j];
                if(currentBillboard.isScheduledFor(k)){
                    dayBillboards = addBillboard(dayBillboards,currentBillboard);
                }
            }
            this.billboardListPerDay[k] = new JList(dayBillboards);
        }


    }

    public static Billboard[] addBillboard(Billboard arr[], Billboard billboard)
    {
        Billboard[] arrNew = Arrays.copyOf(arr, arr.length + 1);
        arrNew[arr.length - 1] = billboard;
        return  arrNew;
    }
}
