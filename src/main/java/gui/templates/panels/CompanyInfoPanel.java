package gui.templates.panels;

import enums.OilType;
import gui.MainWindow;
import gui.templates.borders.RoundBorder;
import gui.templates.buttons.JRoundButton;
import gui.templates.renderers.ListRenderer;
import managgers.App;
import models.Company;
import models.Oil;
import models.Water;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.UUID;

/**
 * Company information panel.
 * it's shows the selected company information.
 */
public class CompanyInfoPanel extends JPanel implements CustomPanel{

    private Company company;
    private UUID companyId;

    private JLabel companyName;
    private JList<Oil> oilList;
    private JList<Water> waterList;

    /**
     * Constructor.
     */
    public CompanyInfoPanel() {
        setBackground(new Color(8, 12, 19, 255));

        initComponents();
    }

    /**
     * Initialize components.
     */
    public void initComponents() {
        // Create title label
        JLabel titleLabel = new JLabel("Company Information");
        titleLabel.setBounds(5, 5, MainWindow.WIDTH-360-5, 30);
        titleLabel.setFont(titleLabel.getFont().deriveFont(24f));
        titleLabel.setForeground(Color.WHITE);

        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(titleLabel);

        // Create company name label
        companyName = new JLabel(company == null ? "Unknown" : company.getName());
        companyName.setBounds(5,40, MainWindow.WIDTH-360-5, 30);
        companyName.setFont(companyName.getFont().deriveFont(16f));
        companyName.setForeground(Color.WHITE);

        companyName.setVerticalAlignment(SwingConstants.CENTER);
        companyName.setHorizontalAlignment(SwingConstants.CENTER);

        add(companyName);

        // Create a JList to show the oils
        JLabel oilsLabel = new JLabel("Oils");
        oilsLabel.setBounds(5, 165, (MainWindow.WIDTH-360-5) / 2, 30);
        oilsLabel.setFont(oilsLabel.getFont().deriveFont(16f));
        oilsLabel.setForeground(Color.WHITE);
        oilsLabel.setVerticalAlignment(SwingConstants.CENTER);
        oilsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(oilsLabel);

        oilList = new JList<>(UpdateOilList());
        oilList.setFont(oilList.getFont().deriveFont(16f));
        oilList.setForeground(Color.WHITE);
        oilList.setBackground(new Color(8, 12, 19, 255));
        oilList.setCellRenderer(new ListRenderer<>());

        JScrollPane oilListScroll = new JScrollPane(oilList);
        oilListScroll.setBounds(5, 195, (MainWindow.WIDTH-360-5) / 2, MainWindow.HEIGHT-165-150);
        oilListScroll.setBackground(new Color(8, 12, 19, 255));
        oilListScroll.setBorder(new RoundBorder(15, Color.WHITE));

        add(oilListScroll);

        // Create a JList to show the waters
        JLabel watersLabel = new JLabel("Waters");
        watersLabel.setBounds((MainWindow.WIDTH-360-5) / 2 + 10, 165, (MainWindow.WIDTH-360-5) / 2, 30);
        watersLabel.setFont(watersLabel.getFont().deriveFont(16f));
        watersLabel.setForeground(Color.WHITE);
        watersLabel.setVerticalAlignment(SwingConstants.CENTER);
        watersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(watersLabel);

        waterList = new JList<>(UpdateWaterList());
        waterList.setFont(waterList.getFont().deriveFont(16f));
        waterList.setForeground(Color.WHITE);
        waterList.setBackground(new Color(8, 12, 19, 255));
        waterList.setCellRenderer(new ListRenderer<>());

        JScrollPane waterListScroll = new JScrollPane(waterList);
        waterListScroll.setBounds((MainWindow.WIDTH-360-5) / 2 + 10, 195, (MainWindow.WIDTH-360-5) / 2 - 10, MainWindow.HEIGHT-165-150);
        waterListScroll.setBackground(new Color(8, 12, 19, 255));
        waterListScroll.setBorder(new RoundBorder(15, Color.WHITE));

        add(waterListScroll);

        // Add oils and remove oils buttons
        JRoundButton addOilButton = new JRoundButton("Add Oil", 5);
        addOilButton.setBounds(5, MainWindow.HEIGHT-110, (MainWindow.WIDTH-360-5) / 2, 30);
        addOilButton.setFont(addOilButton.getFont().deriveFont(14f));
        addOilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(company != null) {
                    String name = JOptionPane.showInputDialog(null, "Enter the name of the oil you want to add:", "Add Oil", JOptionPane.PLAIN_MESSAGE);
                    if(name == null || name.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You must enter a name for the oil.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String liter = JOptionPane.showInputDialog(null, "Enter the amount of liters of the oil you want to add:", "Add Oil", JOptionPane.PLAIN_MESSAGE);
                    if(liter == null || liter.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You must enter the amount of liters of the oil.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int literInt = 0;
                    try {
                        literInt = Integer.parseInt(liter);
                        if(literInt <= 0) {
                            JOptionPane.showMessageDialog(null, "You must enter a positive amount of liters of the oil.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "You must enter a valid amount of liters.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String price = JOptionPane.showInputDialog(null, "Enter the price of the oil you want to add:", "Add Oil", JOptionPane.PLAIN_MESSAGE);
                    if(price == null || price.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You must enter the price of the oil.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int priceInt = 0;
                    try {
                        priceInt = Integer.parseInt(price);
                        if(priceInt <= 0) {
                            JOptionPane.showMessageDialog(null, "You must enter a positive price of the oil.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "You must enter a valid price.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    StringBuilder oilTypes = new StringBuilder();
                    for(OilType type : OilType.values()) {
                        oilTypes.append(type.toString()).append("\n");
                    }

                    String type = JOptionPane.showInputDialog(null, oilTypes + "\nEnter the type of the oil you want to add:", "Add Oil", JOptionPane.PLAIN_MESSAGE);
                    if(type == null || type.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "You must enter the type of the oil.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    OilType oilType = null;
                    for(OilType type1 : OilType.values()) {
                        if(type1.toString().equalsIgnoreCase(type)) {
                            oilType = type1;
                            break;
                        }
                    }

                    if(oilType == null) {
                        JOptionPane.showMessageDialog(null, "You must enter a valid type of the oil.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Oil oil = new Oil(name, literInt, priceInt, oilType);
                    App.addOil(company, oil);

                    oilList.setModel(UpdateOilList());
                }
            }
        });

        add(addOilButton);

        JRoundButton removeOilButton = new JRoundButton("Remove Oil", 5);
        removeOilButton.setBounds(5, MainWindow.HEIGHT-75, (MainWindow.WIDTH-360-5) / 2, 30);
        removeOilButton.setFont(removeOilButton.getFont().deriveFont(14f));
        removeOilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = oilList.getSelectedIndex();
                if(index == -1) {
                    JOptionPane.showMessageDialog(null, "You must select an oil to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Oil oil = oilList.getModel().getElementAt(index);
                for (Map.Entry<UUID, Oil> entry : App.chooseCompany(companyId).getOils().entrySet()){
                    if(entry.getValue().equals(oil)) {
                        App.removeOil(company, entry.getKey());
                        JOptionPane.showMessageDialog(null, "Oil removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        oilList.setModel(UpdateOilList());
                        return;
                    }
                }

                JOptionPane.showMessageDialog(null, "An error occurred while removing the oil.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(removeOilButton);

        // Add waters and remove waters buttons
        JRoundButton addWaterButton = new JRoundButton("Add Water", 5);
        addWaterButton.setBounds((MainWindow.WIDTH-360-5) / 2 + 10, MainWindow.HEIGHT-110, (MainWindow.WIDTH-360-5) / 2 - 10, 30);
        addWaterButton.setFont(addWaterButton.getFont().deriveFont(14f));
        addWaterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(null, "Enter the name of the water you want to add:", "Add Water", JOptionPane.PLAIN_MESSAGE);
                if(name == null || name.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You must enter a name for the water.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String liter = JOptionPane.showInputDialog(null, "Enter the amount of liters of the water you want to add:", "Add Water", JOptionPane.PLAIN_MESSAGE);
                if(liter == null || liter.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You must enter the amount of liters of the water.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int literInt = 0;
                try {
                    literInt = Integer.parseInt(liter);
                    if(literInt <= 0) {
                        JOptionPane.showMessageDialog(null, "You must enter a positive amount of liters of the water.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "You must enter a valid amount of liters.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String price = JOptionPane.showInputDialog(null, "Enter the price of the water you want to add:", "Add water", JOptionPane.PLAIN_MESSAGE);
                if(price == null || price.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You must enter the price of the water.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int priceInt = 0;
                try {
                    priceInt = Integer.parseInt(price);
                    if(priceInt <= 0) {
                        JOptionPane.showMessageDialog(null, "You must enter a positive price of the water.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "You must enter a valid price.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String cleanliness = JOptionPane.showInputDialog(null, "\nEnter the cleanliness of the water you want to add:", "Add Water", JOptionPane.PLAIN_MESSAGE);
                if(cleanliness == null || cleanliness.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You must enter the cleanliness of the water.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int cleanlinessInt = 0;
                try {
                    cleanlinessInt = Integer.parseInt(cleanliness);
                    if(cleanlinessInt <= 0) {
                        JOptionPane.showMessageDialog(null, "You must enter a positive cleanliness of the water.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "You must enter a valid cleanliness.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                Water water = new Water(name, literInt, priceInt, cleanlinessInt);
                App.addWater(company, water);

                waterList.setModel(UpdateWaterList());
            }
        });

        add(addWaterButton);

        JRoundButton removeWaterButton = new JRoundButton("Remove Water", 5);
        removeWaterButton.setBounds((MainWindow.WIDTH-360-5) / 2 + 10, MainWindow.HEIGHT-75, (MainWindow.WIDTH-360-5) / 2 - 10, 30);
        removeWaterButton.setFont(removeWaterButton.getFont().deriveFont(14f));
        removeWaterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(waterList.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "You must select a water to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Water water = waterList.getModel().getElementAt(waterList.getSelectedIndex());
                for (Map.Entry<UUID, Water> entry : App.chooseCompany(companyId).getWaters().entrySet()){
                    if(entry.getValue().equals(water)) {
                        App.removeWater(company, entry.getKey());
                        JOptionPane.showMessageDialog(null, "Water removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        waterList.setModel(UpdateWaterList());
                        return;
                    }
                }
            }
        });

        add(removeWaterButton);
    }

    /**
     * Updates the oil list.
     * @return The updated oil list.
     */
    private DefaultListModel<Oil> UpdateOilList(){
        // Createing a new listModel
        DefaultListModel<Oil> listModel = new DefaultListModel<>();

        // Adding the companies to the listModel
        if(companyId == null) return listModel;
        if(company == null) return listModel;

        App.chooseCompany(companyId).getOils().forEach((k, v) -> {
            listModel.addElement(v);
        });

        // Sort the listModel
        for (int i = 0; i < listModel.getSize(); i++) {
            for (int j = 0; j < listModel.getSize() - i - 1; j++) {
                if (listModel.getElementAt(j).toString().compareTo(listModel.getElementAt(j + 1).toString()) > 0) {
                    Oil temp = listModel.getElementAt(j);
                    listModel.setElementAt(listModel.getElementAt(j + 1), j);
                    listModel.setElementAt(temp, j + 1);
                }
            }
        }

        return listModel;
    }

    /**
     * Updates the water list.
     * @return The updated water list.
     */
    private DefaultListModel<Water> UpdateWaterList(){
        // Createing a new listModel
        DefaultListModel<Water> listModel = new DefaultListModel<>();

        // Adding the companies to the listModel
        if(companyId == null) return listModel;
        if(company == null) return listModel;

        App.chooseCompany(companyId).getWaters().forEach((k, v) -> {
            listModel.addElement(v);
        });

        // Sort the listModel
        for (int i = 0; i < listModel.getSize(); i++) {
            for (int j = 0; j < listModel.getSize() - i - 1; j++) {
                if (listModel.getElementAt(j).toString().compareTo(listModel.getElementAt(j + 1).toString()) > 0) {
                    Water temp = listModel.getElementAt(j);
                    listModel.setElementAt(listModel.getElementAt(j + 1), j);
                    listModel.setElementAt(temp, j + 1);
                }
            }
        }

        return listModel;
    }

    /**
     * Set the company and companyId.
     * @param company The company.
     * @param companyId The company id.
     */
    public void setCompany(Company company, UUID companyId) {
        this.company = company;
        this.companyId = companyId;

        if(company != null) {
            companyName.setText(company.getName());
            oilList.setModel(UpdateOilList());
            waterList.setModel(UpdateWaterList());
            setVisible(true);
        }else{
            setVisible(false);
        }
    }
}
