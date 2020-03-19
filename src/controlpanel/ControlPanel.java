/***
 * Billboard Control Panel class
 * CAB302 QUT 2020
 */

package controlpanel;

// Use AWT to poll screen resolution
import java.awt.Toolkit;
import java.awt.Dimension;

/***
 * The ControlPanel class contains the logic for the initial
 * login screen as well as GUI functions.
 */
public class ControlPanel
{
    // The variables for the GUI objects on startup (the log in frame)
    private static boolean loggedIn = false;
    private static boolean quit = false;

    // Poll the resolution of the screen using AWT
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    // The variables for the GUI objects after successful login


    // The constructor
    public ControlPanel() {

    }

    /***
     * Main method is the entry point and runs on program startup.
     * @param args
     */
    public static void main(String[] args) {
        //while(!quit) {
            if (!loggedIn){
                new LoginWindow(screenSize);
                //purgeControlPanel();
            } else {
                //createControlPanel();
                //purgeLoginWindow();
            }
        //}


    }

}