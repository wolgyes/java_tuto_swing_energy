package gui.templates.renderers;

import javax.swing.*;
import java.awt.*;

/**
 * <h2>List Renderer class</h2>
 *
 * <p>
 *     Its supposed to manage the list item to customize the appearance.<br/>
 *     Not nessesary to extends from JLabel, it could be anything else or a panel <br/>
 *     to create a new visual representation of the list item, like icon + text.
 * </p>
 * @param <T> the type of the list item.
 * @see JLabel
 * @see ListCellRenderer
 */
public class ListRenderer<T> extends JLabel implements ListCellRenderer<T>{

    /**
     * <h3>Constructor </h3>
     * Basicly only thing that is do to set the opaque to true.<br/>
     * Without it the selection is working but not visible!
     */
    public ListRenderer() {
        setOpaque(true);
    }

    /**
     * <h3>getListCellRendererComponent</h3>
     * Its an override of the method from the interface {@link ListCellRenderer}<br/>
     * @param list the list that is being rendered.
     * @param value the value of the list item.
     * @param index the index of the list item.
     * @param isSelected true if the item is selected.
     * @param cellHasFocus true if the item has focus.
     * @return the component to render.
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends T> list, T value, int index, boolean isSelected, boolean cellHasFocus) {
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
