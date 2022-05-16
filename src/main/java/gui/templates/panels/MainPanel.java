package gui.templates.panels;

import gui.MainWindow;
import gui.templates.borders.RoundBorder;
import gui.templates.buttons.JRoundButton;
import gui.templates.renderers.CompanyRenderer;
import managgers.App;
import models.Company;

import javax.swing.*;
import java.awt.*;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MainPanel extends JPanel {

    public MainPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);

        // Buttons
        JRoundButton jRoundButton = new JRoundButton("Teszt", 5);
        jRoundButton.setBounds(5, 35, 100, 25);
        jRoundButton.setFocusPainted(false);
        add(jRoundButton);

        // JList of the Companies
        DefaultListModel<String> listModel = new DefaultListModel<>();

        App.companyMangger.getCompanies().forEach((k, v) -> {
           listModel.addElement(v.getName());
        });

        JList<String> jList = new JList<>(listModel);
        jList.setCellRenderer(new CompanyRenderer());
        jList.setBackground(new Color(8, 12, 19, 255));

        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setBounds(5, 100, 200, 200);
        jScrollPane.setBorder(new RoundBorder(5, Color.WHITE));
        jScrollPane.setBackground(new Color(8, 12, 19, 255));

        add(jScrollPane);
    }

}
