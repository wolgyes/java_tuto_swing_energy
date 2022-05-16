package gui;

import gui.templates.HeaderPanel;

import javax.swing.*;
import java.awt.*;

/**
 * GUI for the main window of the application.
 */
public class MainWindow extends JFrame {

    public static final String TITLE = "Energetic Companies";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public MainWindow(){
        // Set the basic properties of the window
        super(TITLE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = new Dimension(WIDTH, HEIGHT);

        setSize(windowSize);
        setLocation((screenSize.width - windowSize.width) / 2, (screenSize.height - windowSize.height) / 2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Initialize the components
        initComponents();

        // Set the visible state of the window to true
        setVisible(true);
    }

    private void initComponents() {
        // Set the basic layout
        setLayout(null);
        setUndecorated(true);

        // Create the content pane
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBounds(0, 0, WIDTH, HEIGHT);

        contentPane.setBackground(new Color(8, 12, 19, 255));

        contentPane.setForeground(new Color(255, 255, 255, 255));
        contentPane.setFont(new Font("Arial", Font.PLAIN, 12));

        // Create the header panel
        HeaderPanel headerPanel = new HeaderPanel(this);
        contentPane.add(headerPanel);

        // Set the content pane
        setContentPane(contentPane);
    }

}
