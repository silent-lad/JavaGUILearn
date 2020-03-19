package controlpanel;

// Import
import java.awt.*;
import javax.swing.*;

/***
 * This class created the GUI for the login screen when needed
 */
public class LoginWindow extends JFrame {
    public static Component frame;

    public LoginWindow(Dimension screenSize) {
        int w = (int)screenSize.getWidth();
        int h = (int)screenSize.getHeight();
        // Initialise this new frame
        JFrame frame = new JFrame();
        frame.setSize(w - 200,h - 200);
        initialise(frame);
        frame.setVisible(true);
    }

    public void initialise(JFrame frame){
        /* Layout not working
        GroupLayout layout = new GroupLayout(frame);
        frame.setLayout(null);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING))
        );*/

        JLabel welcomeMsg = new JLabel("PLEASE SUBMIT USERNAME AND PASSWORD TO LOG IN");;
        JButton submit = new JButton("SUBMIT");
        JButton quitButton = new JButton("QUIT");
        frame.add(welcomeMsg);
        frame.add(submit);
        frame.add(quitButton);

        /*
        layout.linkSize(SwingConstants.HORIZONTAL, submit, quitButton);
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(submit)
                        .addComponent(quitButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(welcomeMsg)
                )
        );*/

        setTitle("CAB302 Billboard Control Panel 2020");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
