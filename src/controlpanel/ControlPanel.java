/***
 * Billboard Control Panel class
 * CAB302 QUT 2020
 */

package controlpanel;
import java.awt.*;
import java.awt.event.*;

/***
 * The ControlPanel class contains the logic for the initial
 * login screen as well as GUI functions.
 */
public class ControlPanel extends Frame implements ActionListener
{
    // The variables for the GUI objects on startup (to log in)
    private Frame windowFrame;    // The "super" version of the ControlPanel window
    private Label welcomeMsg;
    private TextField user;       // Declare the field for their username
    private TextField password;   // Declare the field for a password
    private Button loginButton;         // Submit login request button
    private Button viewerButton;        // View the viewer pop-up window

    // The variables for the GUI objects after successful login


    // The constructor initialises the objects and adds event listeners.
    public ControlPanel() {
        windowFrame = new Frame();
        windowFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Initialise the screen height and width then set the window size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // Attributes of the GUI
        setTitle("Billboard Control Panel 2020");
        setSize(screenWidth - 200, screenHeight - 200);
        setLocation(100, 100); // Center on screen

        // Make sure we can close the application window
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });


        welcomeMsg = new Label("--  BILLBOARD CONTROL PANEL  --\nSUBMIT USERNAME AND PASSWORD PLEASE");
        add(welcomeMsg);                  // Add() will create the object in the window ("super" Frame)

        loginButton = new Button("SUBMIT");
        loginButton.setSize(100,100);
        add(loginButton);
        loginButton.addActionListener(this); // Clicking "loginButton" invokes the listener function

        viewerButton = new Button("ACCESS THE VIEWER");
        viewerButton.setSize(100, 100);
        add(viewerButton);
        viewerButton.addActionListener(this);

        setVisible(true); // Show the window
    }


    // ActionEvent handler - Called back upon button-click.
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(loginButton)) {
            System.out.println("Login request made");
        } else if (ae.getSource().equals(viewerButton)) {
            System.out.println("Create a new viewer object until esc or click or window close");
        }
        //System.out.println(" "+ae.toString());
    }

    /***
     * Main method is the entry point and runs on program startup.
     * @param args
     */
    public static void main(String[] args) {
        ControlPanel window = new ControlPanel();
    }
}