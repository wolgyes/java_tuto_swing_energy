package gui;

import gui.templates.buttons.JRoundButton;
import gui.templates.panels.HeaderPanel;
import gui.templates.panels.MainPanel;

import javax.swing.*;
import java.awt.*;

/**
 * GUI for the main window of the application.
 */
public class MainWindow extends JFrame {

    public static final String TITLE = "Energetic Companies";
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private JPanel contentPane;
    private JComponent content;

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
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBounds(0, 0, WIDTH, HEIGHT);

        contentPane.setBackground(new Color(8, 12, 19, 255));

        contentPane.setForeground(new Color(255, 255, 255, 255));
        contentPane.setFont(new Font("Arial", Font.PLAIN, 12));

        // Create the header panel
        HeaderPanel headerPanel = new HeaderPanel(this);
        contentPane.add(headerPanel);

        // Create content panel
        setContent(new MainPanel());

        // Set the content pane
        setContentPane(contentPane);
    }

    public void setContent(JComponent newContent){
        if(content != null) contentPane.remove(content);

        content = newContent;
        content.setBounds(0, HeaderPanel.HEIGHT, WIDTH, HEIGHT - HeaderPanel.HEIGHT);
        content.setBackground(new Color(8, 12, 19, 255));

        contentPane.add(content);
    }

    public JComponent getContent(){
        return content;
    }
}
