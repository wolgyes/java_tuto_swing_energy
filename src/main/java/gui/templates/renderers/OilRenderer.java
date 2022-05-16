package gui.templates.renderers;

import models.Oil;

import javax.swing.*;
import java.awt.*;

/**
 * <h2>Oil Renderer</h2>
 *
 * Used to render an oil in a JList using a ListCellRenderer
 *
 * @see JLabel
 * @see ListCellRenderer
 */
public class OilRenderer extends JLabel implements ListCellRenderer<Oil> {

    /**
     * Constructor
     */
    public OilRenderer() {
        setOpaque(true);
    }

    /**
     * Get the component used for drawing the specified value.
     * @param list the JList we're painting
     * @param value the value returned by list.getModel().getElementAt(index)
     * @param index the cells index
     * @param isSelected true if the specified cell was selected, false otherwise
     * @param cellHasFocus true if the specified cell has the focus, false otherwise
     * @return the component used for drawing the specified value
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends Oil> list, Oil value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.toString());
        setFont(new Font("Arial", Font.PLAIN, 16));

        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);

        setForeground(Color.WHITE);

        if(isSelected){
            setBackground(new Color(29, 60, 110));
        }else{
            setBackground(new Color(8, 12, 19, 255));
        }

        return this;
    }
}
