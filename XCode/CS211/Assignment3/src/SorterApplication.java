// SorterApplication.java
// Caitlin Coggins

import javax.swing.JFrame;

/**
 * EncryptorApplication starts the program.
 **/
public class SorterApplication
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new SorterPanel());
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}