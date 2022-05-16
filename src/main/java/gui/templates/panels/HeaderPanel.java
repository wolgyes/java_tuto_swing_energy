package gui.templates.panels;

import gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * <h2>Header panel for the application.</h2>
 *
 * <p>
 *     By using the JPanel class, we create a header panel that is used to display<br/><br/>
 *     With the MouseListener and MouseMotionListener, we create a draggable window.<br/>
 * </p>
 *
 * @see JPanel
 * @see MouseListener
 * @see MouseMotionListener
 */
public class HeaderPanel extends JPanel implements MouseListener, MouseMotionListener {

    private MainWindow mainWindow;

    private boolean isDragged = false;
    private Point lastClickedPosition;

    /**
     * Constructor.
     *
     * @param mainWindow The main window.
     */
    public HeaderPanel(MainWindow mainWindow) {
        super();

        this.mainWindow = mainWindow;
        setBackground(new Color(7, 8, 12,255));
        setBounds(0, 0, MainWindow.WIDTH, 30);

        addMouseListener(this);
        addMouseMotionListener(this);

        initComponents();
    }

    /**
     * Initializes the components.
     */
    private void initComponents() {
        setLayout(null);

        // Title
        JLabel title = new JLabel("<html><font color='white' size='+1'><b>"+ MainWindow.TITLE +"</b></font></html>");
        title.setBounds(5, 0, MainWindow.WIDTH - 20, 20);
        add(title);

        // Exit button
        JButton exitButton = new JButton("X");
        exitButton.setBounds(MainWindow.WIDTH - 30, 0, 30, 30);
        exitButton.setBackground(new Color(7, 8, 12,255));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(e -> System.exit(0));
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                exitButton.setBackground(Color.red);
                exitButton.setForeground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                exitButton.setBackground(new Color(7, 8, 12,255));
                exitButton.setForeground(Color.white);
            }
        });
        add(exitButton);

        // Minimize button
        JButton minimizeButton = new JButton("_");
        minimizeButton.setBounds(MainWindow.WIDTH - 60, 0, 30, 30);
        minimizeButton.setBackground(new Color(7, 8, 12,255));
        minimizeButton.setForeground(Color.WHITE);
        minimizeButton.setBorder(BorderFactory.createEmptyBorder());
        minimizeButton.setFocusPainted(false);
        minimizeButton.addActionListener(e -> mainWindow.setState(JFrame.ICONIFIED));
        minimizeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                minimizeButton.setBackground(Color.red);
                minimizeButton.setForeground(Color.black);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                minimizeButton.setBackground(new Color(7, 8, 12,255));
                minimizeButton.setForeground(Color.white);
            }
        });
        add(minimizeButton);
    }

    //#region Mouse Listener section
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        isDragged = true;

        lastClickedPosition = e.getLocationOnScreen();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isDragged = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(isDragged){
            Point currentPosition = e.getLocationOnScreen();

            int x = currentPosition.x - lastClickedPosition.x;
            int y = currentPosition.y - lastClickedPosition.y;

            mainWindow.setLocation(mainWindow.getX() + x, mainWindow.getY() + y);

            lastClickedPosition = currentPosition;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    //#endregion
}
