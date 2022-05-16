package gui.templates.renderers;

import models.Oil;

import javax.swing.*;
import java.awt.*;

public class OilRenderer extends JLabel implements ListCellRenderer<Oil> {

    public OilRenderer() {
        setOpaque(true);
    }

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
