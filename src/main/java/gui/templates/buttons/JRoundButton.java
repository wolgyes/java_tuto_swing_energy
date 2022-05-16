package gui.templates.buttons;

import gui.templates.borders.RoundBorder;

import javax.swing.*;
import java.awt.*;

/**
 * JRoundButton is a JButton with a round border.
 *
 * @see JButton
 */
public class JRoundButton extends JButton{

    /**
     * Constructs a JRoundButton with the specified text and default radius.
     * @param text the text of the button
     * @param radius the radius of the border
     */
    public JRoundButton(String text, int radius) {
        super(text);

        setBackground(new Color(8, 12, 19, 255));
        setForeground(Color.WHITE);
        setFocusPainted(false);

    }

    /**
     * Set the bounds of the button and create a round border.
     * @param x the x coordinate of the bound
     * @param y the y coordinate of the bound
     * @param width the width of the bound
     * @param height the height of the bound
     */
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        setBorder(new RoundBorder(height / 2, Color.WHITE));
    }
}
