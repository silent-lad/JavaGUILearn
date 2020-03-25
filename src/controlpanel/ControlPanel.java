/***
 * Billboard Control Panel class
 * CAB302 QUT 2020
 */
package controlpanel;


// Use AWT to poll screen resolution
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;

/***
 * The ControlPanel class contains the logic for the initial login screen as
 * well as GUI functions.
 */
public class ControlPanel {

    /***
     * Main method is the entry point and runs on program startup.
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Login Window will be the first screen and if login is passed new JFrame Dashboard will initialised.
        LoginWindow frame = new LoginWindow();
        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}