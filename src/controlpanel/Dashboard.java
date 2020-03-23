package controlpanel;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
    // User Menu
    static JMenu userMenu;

    static String userToken;

    //Billboard Menu options
    static JMenuItem createBillboardMenuOption, editBillboardMenuOption, listBillboardMenuOption, scheduleBillboardMenuOption;
    //User Menu Options
    static JMenuItem editUserMenuOption;

    // a label
    static JLabel l;

    // A variable to store current panel, as the panel is changed when you choose another option from the top menu
    public JPanel currentPanel = new JPanel();

    /***
     * Dashboard uctor function
     *
     * @param token
     */
    Dashboard(String token)
    {
        // Acknowledgin that the token is recieved from the login window.
        System.out.println(token);
        userToken = token;
        currentPanel.setBackground(Color.red);
        
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
        // create a menubar
        menuBar = new JMenuBar();

        // create both the menu menu
        billboardMenu = new JMenu("Billboard");
        userMenu = new JMenu("User");

        // create menuitems
        createBillboardMenuOption = new JMenuItem("Create Billboard");
        editBillboardMenuOption = new JMenuItem("Edit Billboard");
        listBillboardMenuOption = new JMenuItem("List Billboard");
        scheduleBillboardMenuOption = new JMenuItem("Schedule Billboard");
        editUserMenuOption = new JMenuItem("Edit User");

        // add ActionListener to menuItems
        createBillboardMenuOption.addActionListener(this);
        editBillboardMenuOption.addActionListener(this);
        listBillboardMenuOption.addActionListener(this);
        scheduleBillboardMenuOption.addActionListener(this);
        editUserMenuOption.addActionListener(this);

        // add menu options to menu
        billboardMenu.add(createBillboardMenuOption);
        billboardMenu.add(editBillboardMenuOption);
        billboardMenu.add(listBillboardMenuOption);
        billboardMenu.add(scheduleBillboardMenuOption);

        userMenu.add(editUserMenuOption);

        // add menu to menu bar
        menuBar.add(billboardMenu);
        menuBar.add(userMenu);

        // add menubar to frame
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
        // Remove exisitng panel from the frame.
        getContentPane().removeAll();

        // Switch case statement decides which new panel is to be added in the Dashboard JFrame
        switch(s){
            case "Create Billboard" :
                // Changing the value of currentPanel, passing user token to enable it to make requests.
                currentPanel = new CreateBillboard(userToken);
                currentPanel.setVisible(true);
                // Adding it to the JFrame
                add(currentPanel);
                setTitle("Create Billboard");
                break;
            case "Edit Billboard" :
                currentPanel = new EditBillboard();
                currentPanel.setVisible(true);
                add(currentPanel);
                setTitle("Edit Billboard");
                break;
            case "Schedule Billboard" :
                currentPanel = new ScheduleBillboard();
                currentPanel.setVisible(true);
                add(currentPanel);
                setTitle("Schedule Billboard");
                break;
            case "List Billboard" :
                currentPanel = new ListBillboard();
                currentPanel.setVisible(true);
                setLayout(new BorderLayout());
                add(BorderLayout.CENTER, new JScrollPane(currentPanel));
                //add(currentPanel);
                setTitle("List Billboard");
                break;
            case "Edit User" :
                currentPanel = new EditUser();
                currentPanel.setVisible(true);
                setLayout(new BorderLayout());
                add(BorderLayout.CENTER, new JScrollPane(currentPanel));
                setTitle("Edit User");
            break;
            default:
                break;
        }

        // Revalidating and repainting the Dashboard JFrame to check for the changes in UI and perform them.
        revalidate();
        repaint();

    }

}
