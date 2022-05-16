package gui.templates.renderers;

import models.Water;

import javax.swing.*;
import java.awt.*;

public class WaterRenderer extends JLabel implements ListCellRenderer<Water> {

    public WaterRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Water> list, Water value, int index, boolean isSelected, boolean cellHasFocus) {
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
