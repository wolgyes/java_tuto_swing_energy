package gui.templates.buttons;

import gui.templates.borders.RoundBorder;

import javax.swing.*;
import java.awt.*;

public class JRoundButton extends JButton {

    public JRoundButton(String text, int radius) {
        super(text);

        setBackground(new Color(8, 12, 19, 255));
        setForeground(Color.WHITE);
    }

    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        setBorder(new RoundBorder(height / 2, Color.WHITE));
    }
}
