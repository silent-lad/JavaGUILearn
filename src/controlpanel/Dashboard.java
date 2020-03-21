package controlpanel;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Dashboard extends JFrame implements ActionListener {
    // menubar
    static JMenuBar menuBar;

    // Billboard Menu
    static JMenu billboardMenu;
    // User Menu
    static JMenu userMenu;

    //Billboard Menu items
    static JMenuItem bbMenuItem1, bbMenuItem2, bbMenuItem3, bbMenuItem4;
    //User Menu Items
    static JMenuItem userMenuItem;

    // a label
    static JLabel l;

    public JPanel currentPanel = new JPanel();

    public JFrame primaryFrame = new JFrame("Control Panel");

    // main class
    Dashboard(String token)
    {
        System.out.println(token);
        currentPanel.setBackground(Color.red);

        createMenu();

        // add selected panel
        primaryFrame.add(currentPanel);

        // set the size of the frame
        primaryFrame.setSize(500, 500);
        primaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        primaryFrame.setLocationRelativeTo(null);
        primaryFrame.setVisible(true);
    }

    public void createMenu(){
        // create a menubar
        menuBar = new JMenuBar();

        // create a menu
        billboardMenu = new JMenu("Billboard");
        userMenu = new JMenu("User");

        // create menuitems
        bbMenuItem1 = new JMenuItem("Create Billboard");
        bbMenuItem2 = new JMenuItem("Edit Billboard");
        bbMenuItem3 = new JMenuItem("List Billboard");
        bbMenuItem4 = new JMenuItem("Schedule Billboard");
        userMenuItem = new JMenuItem("Edit User");

        // add ActionListener to menuItems
        bbMenuItem1.addActionListener(this);
        bbMenuItem2.addActionListener(this);
        bbMenuItem3.addActionListener(this);
        bbMenuItem4.addActionListener(this);
        userMenuItem.addActionListener(this);

        // add menu items to menu
        billboardMenu.add(bbMenuItem1);
        billboardMenu.add(bbMenuItem2);
        billboardMenu.add(bbMenuItem3);
        billboardMenu.add(bbMenuItem4);

        userMenu.add(userMenuItem);

        // add menu to menu bar
        menuBar.add(billboardMenu);
        menuBar.add(userMenu);

        // add menubar to frame
        primaryFrame.setJMenuBar(menuBar);
    }

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        primaryFrame.getContentPane().removeAll();
        switch(s){
            case "Create Billboard" :
                currentPanel = new CreateBillboard();
                currentPanel.setVisible(true);
                primaryFrame.add(currentPanel);
                setTitle("Create Billboard");
                break;
            case "Edit Billboard" :
                currentPanel = new EditBillboard();
                currentPanel.setVisible(true);
                primaryFrame.add(currentPanel);
                setTitle("Edit Billboard");
                break;
            case "Schedule Billboard" :
                currentPanel = new ScheduleBillboard();
                currentPanel.setVisible(true);
                primaryFrame.add(currentPanel);
                setTitle("Schedule Billboard");
                break;
            case "List Billboard" :
                currentPanel = new ListBillboard();
                currentPanel.setVisible(true);
                primaryFrame.setLayout(new BorderLayout());
                primaryFrame.add(BorderLayout.CENTER, new JScrollPane(currentPanel));
                //primaryFrame.add(currentPanel);
                setTitle("List Billboard");
                break;
            case "Edit User" :
                currentPanel = new EditUser();
                currentPanel.setVisible(true);
                primaryFrame.setLayout(new BorderLayout());
                primaryFrame.add(BorderLayout.CENTER, new JScrollPane(currentPanel));
                setTitle("Edit User");
            break;
            default:
                break;
        }
        primaryFrame.revalidate();
        primaryFrame.repaint();

    }

}
