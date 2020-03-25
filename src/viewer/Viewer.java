/***
 * Viewer class
 * CAB302 QUT 2020
 */

package viewer;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.Dimension;

/***
 * The Viewer class controls the GUI window for the full-screen
 * viewing of the latest or the scheduled billboard.
 */
public class Viewer extends JFrame implements MouseListener, KeyListener
{
    public Viewer() {
        // Poll the screen resolution for Viewer
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int SCREEN_WIDTH = (int)screenSize.getWidth();
        int SCREEN_HEIGHT = (int)screenSize.getHeight();

        addKeyListener(this);
        addMouseListener(this);
        setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        setVisible(true);
    }

    /***
     * When the user clicks (left or right) on the window area we exit the Viewer
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
    }
    // Appease the abstract interface
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }

    /***
     * When the user presses ESC we also close the Viewer
     * @param e
      */

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }
    // Override to appease the interface
    public void keyTyped(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {
    }
}
