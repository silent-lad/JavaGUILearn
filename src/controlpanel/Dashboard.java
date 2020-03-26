package controlpanel;


import common.models.User;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.util.Arrays;

/***
 * The Dahboard class contains the whole BCP logic after the login
 * well as GUI functions.
 */
class Dashboard extends JFrame implements ActionListener {
    // Top Menu Bar
    static JMenuBar menuBar;
    
    // Two sub menus to choose from in the top bar
    // Billboard Menu
    static JMenu billboardMenu;
    static JMenu advancedMenu;

    // Logout Button
    static JMenu logoutMenu;

    static String userToken;

    //Billboard Menu options
    static JMenuItem createBillboard, listBillboards, scheduleBillboard;
    //User Menu Options
    static JMenuItem editUsers,createUser;
    // Logout button
    static JMenuItem logoutButton;
    // Welcome message for user
    static JLabel welcomeMsg;
    // current User
    User loggedInUser;

    // A variable to store current panel, as the panel is changed when you choose another option from the top menu
    public JPanel currentPanel = new JPanel();

    /***
     * Dashboard uctor function
     *
     * @param token
     */
    Dashboard(String token, User loggedInUser)
    {
        // Acknowledgin that the token is recieved from the login window.
        userToken = token;
        this.loggedInUser = loggedInUser;
        
        welcomeMsg = new JLabel();
        welcomeMsg.setText("Select from the Menu options to begin");
        welcomeMsg.setAlignmentX(Component.CENTER_ALIGNMENT);
        currentPanel.add(welcomeMsg);
        currentPanel.setBackground(Color.lightGray);
        
        //Creating the top menu layout with this
        createMenu();

        // add selected panel
        add(currentPanel);

        // set the size of the frame
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void createMenu(){

        // Create the new menu bar
        menuBar = new JMenuBar();

        // Viewing the list of billboards is available to all permissions
        billboardMenu = new JMenu("Billboard Options");
        listBillboards = new JMenuItem("List Billboards"); // Create the menu option
        listBillboards.addActionListener(this); // Add the listener for mouseclicks
        billboardMenu.add(listBillboards); // Finally add it to the menu

        // If a permission is found then we include appropriate feature
        String[]permissionArray = {"Edit Billboards","Schedule Billboards","Edit Users","Schedule Billboards","Create Billboards"};
        List<String> permissionList = Arrays.asList(permissionArray);

        if (loggedInUser.isAllowedTo("create_bb")) {
            createBillboard = new JMenuItem("Create Billboard");
            createBillboard.addActionListener(this);
            billboardMenu.add(createBillboard);
        }
        // Advanced menu options
        advancedMenu = new JMenu("More Options");
        if (loggedInUser.isAllowedTo("schedule_bb")) {
            scheduleBillboard = new JMenuItem("Schedule Billboard");
            scheduleBillboard.addActionListener(this);
            advancedMenu.add(scheduleBillboard);
        }
        if (loggedInUser.isAllowedTo("edit_user")) {
            editUsers = new JMenuItem("Edit Users");
            editUsers.addActionListener(this);
            advancedMenu.add(editUsers);
        }

        logoutMenu = new JMenu("Logout");

        logoutButton = new JMenuItem("Logout User");
        logoutButton.addActionListener(new LogoutActionListener());

        logoutMenu.add(logoutButton);

        // Add these options to the menu bar
        menuBar.add(billboardMenu);
        if (loggedInUser.isAllowedTo("schedule_bb") || loggedInUser.isAllowedTo("edit_user")) {
            menuBar.add(advancedMenu);
        }
        menuBar.add(logoutMenu);

        // Add the menubar to the parent frame
        setJMenuBar(menuBar);

    }

    /***
     * actionPerformed method catches all the events performed
     * on the menu options and reacts to them
     *
     * @param menuEvent
     */
    public void actionPerformed(ActionEvent menuEvent)
    {
        String s = menuEvent.getActionCommand();
        System.out.println(s);
        // Remove exisitng panel from the frame.
        getContentPane().removeAll();

        setSize(800,500);
        // Switch case statement decides which new panel is to be added in the Dashboard JFrame
        switch(s){
            case "Create Billboard" :
                // Changing the value of currentPanel, passing user token to enable it to make requests.
                currentPanel = new CreateBillboard(userToken,loggedInUser);
                currentPanel.setVisible(true);
                // Adding it to the JFrame
                add(currentPanel);
                setTitle("Create Billboard");
                break;
            case "Schedule Billboard" :
                currentPanel = new ScheduleBillboard(userToken,loggedInUser);
                currentPanel.setVisible(true);
                add(currentPanel);
                setTitle("Schedule Billboard");
                break;
            case "List Billboards" :
                currentPanel = new ListBillboard(userToken,loggedInUser);
                currentPanel.setVisible(true);
                setLayout(new BorderLayout());
                add(BorderLayout.CENTER, new JScrollPane(currentPanel));
                //add(currentPanel);
                setTitle("List Billboards");
            break;
            case "Edit Users" :
                currentPanel = new EditUser(userToken,loggedInUser);
                currentPanel.setVisible(true);
                setLayout(new BorderLayout());
                setSize(800,500);
                add(BorderLayout.CENTER, new JScrollPane(currentPanel));
                setTitle("Edit Users");
            break;
            case "Create User" :
                currentPanel = new CreateUser(userToken,loggedInUser);
                currentPanel.setVisible(true);
                setLayout(new BorderLayout());
                add(BorderLayout.CENTER, new JScrollPane(currentPanel));
                setTitle("Create User");
            break;
            default:
                break;
        }

        // Revalidating and repainting the Dashboard JFrame to check for the changes in UI and perform them.
        revalidate();
        repaint();

    }

//    Action Listener for Logout menu option
    private class LogoutActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LoginWindow frame = new LoginWindow();
            frame.setSize(500, 250);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            dispose();
        }
    }

}
