package io.mcggy.jdev.qt5toj8.xcavegame;
import io.mcggy.jdev.thirdparty.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * Entry point for swing gui app
 * @author GrishaGor
 */
public class xcavegame extends JFrame {
    /**
     * Main frame of the window.
     */
    public static JFrame frame;
    
    /**
     * Command line passed to the app.
     */
    public static String[] sCmdLine;
    
    /**
     * Plays sound placed in "io.mcggy.jdev.thirdparty" package using
     * Sound class
     * <br><b>WARNING!!!</b> Sound class is not Javadoc-documented
     * @param s file to play
     * @return Sound object
     */
    public Sound snd(String s)
    {
        return Sound.playSound(s);
    }
    
    /**
     * Constructs xcavegame object.
     */
    public xcavegame()
    {
        super("xCaveGame-JE");
        try {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            snd("./data/snd1.wav");

            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(null);
            
            JLabel closelbl = new JLabel("close");
            closelbl.setBounds(0, 0, 40, 8);
            closelbl.setFont(new Font("Arial", 0, 8));
            closelbl.setIcon(new ImageIcon("./data/6.png"));
            closelbl.addMouseListener(new mouseEvent() {
                @Override public void mouseClicked(MouseEvent e) {
                    System.exit(0);
                }
            });
            
            mainPanel.add(closelbl);
            getContentPane().add(mainPanel);
            repaint();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sCmdLine = args;
        System.out.println(new File(".").getAbsolutePath());
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //JFrame.setDefaultLookAndFeelDecorated(true); //blue theme
                io.mcggy.jdev.qt5toj8.xcavegame.xcavegame.frame = new xcavegame();
                io.mcggy.jdev.qt5toj8.xcavegame.xcavegame.frame.setPreferredSize(new Dimension(640, 480));
                io.mcggy.jdev.qt5toj8.xcavegame.xcavegame.frame.pack();
                io.mcggy.jdev.qt5toj8.xcavegame.xcavegame.frame.setLocationRelativeTo(null);
                io.mcggy.jdev.qt5toj8.xcavegame.xcavegame.frame.setVisible(true);
               }
        });
    }
    
    /**
     * closes app with code C
     * @param c exit code
     */
    public static void close(int c)
    {
        System.exit(c);
    }

    /**
     * MouseListener.
     */
    public class mouseEvent implements MouseListener {
        @Override public void mouseClicked(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
        @Override public void mousePressed(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
     }
}
