package gui.templates.borders;

import javax.swing.border.Border;
import java.awt.*;

/**
 * RoundBorder is a border that draws a rounded rectangle.
 *
 * @see Border
 */
public class RoundBorder implements Border {
    private int radius;
    private Color color;

    /**
     * Constructs a new RoundBorder with the specified radius and color.
     * @param radius the radius of the rounded corners
     * @param color the color of the border
     */
    public RoundBorder(int radius, Color color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius + 1, radius  + 1, radius + 2, radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
