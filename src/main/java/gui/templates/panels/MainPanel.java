package gui.templates.panels;

import gui.MainWindow;
import gui.templates.borders.RoundBorder;
import gui.templates.buttons.JRoundButton;
import gui.templates.renderers.CompanyRenderer;
import managgers.App;
import models.Company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MainPanel extends JPanel {

    public MainPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);

        // Button panels
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(5, 35, 350, 120);
        buttonPanel.setBackground(new Color(8, 12, 19, 255));
        add(buttonPanel);

        // Company List Panel
        JPanel companyListPanel = new JPanel();
        companyListPanel.setLayout(null);
        companyListPanel.setBounds(5, 165, 350, MainWindow.HEIGHT - 170);
        companyListPanel.setBackground(new Color(8, 12, 19, 255));
        add(companyListPanel);

        // Company Information Panel
        // Its only visible when a company is selected
        CompanyInfoPanel companyInformationPanel = new CompanyInfoPanel();
        companyInformationPanel.setLayout(null);
        companyInformationPanel.setBounds(355, 35, MainWindow.WIDTH - 360, MainWindow.HEIGHT-40);
        companyInformationPanel.setCompany(null, null);
        add(companyInformationPanel);

        // JList of the Companies
        JList<Company> jList = new JList<>(UpdateCompanyList());
        jList.setCellRenderer(new CompanyRenderer());
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setBackground(new Color(8, 12, 19, 255));

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    Company selectedCompany = null;
                    UUID selectedId = null;

                    for(Map.Entry<UUID, Company> entry : App.companyMangger.getCompanies().entrySet()) {
                        if(entry.getValue().equals(jList.getSelectedValue())) {
                            selectedCompany = entry.getValue();
                            selectedId = entry.getKey();
                        }
                    }
                    companyInformationPanel.setCompany(selectedCompany, selectedId);
                }
            }
        });

        // Add buttons to button panel
        JRoundButton addCompanyButton = new JRoundButton("Add Company", 5);
        addCompanyButton.setBounds(5, 5, 190, 30);
        addCompanyButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter company name");
            if (name != null) {
                App.addCompany(new Company(name));
                jList.setModel(UpdateCompanyList());
            }
        });
        buttonPanel.add(addCompanyButton);

        JRoundButton removeCompanyButton = new JRoundButton("Remove Company", 5);
        removeCompanyButton.setBounds(5, 40, 190, 30);
        removeCompanyButton.addActionListener(e -> {
            if (jList.getSelectedIndex() != -1) {
                App.removeCompany(jList.getSelectedValue());
                jList.setModel(UpdateCompanyList());
            }else{
                JOptionPane.showMessageDialog(this, "Please select a company!");
            }
        });
        buttonPanel.add(removeCompanyButton);

        // Add company list to company list panel
        JLabel companyListLabel = new JLabel("Companies");;
        companyListLabel.setBounds(5, 5, companyListPanel.getWidth() - 5, 30);
        companyListLabel.setFont(new Font("Arial", Font.BOLD, 24));
        companyListLabel.setForeground(Color.WHITE);
        companyListLabel.setHorizontalAlignment(SwingConstants.CENTER);
        companyListLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        companyListPanel.add(companyListLabel);

        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setBounds(5, 35, companyListPanel.getWidth() - 5, companyListPanel.getHeight() - 40);
        jScrollPane.setBackground(new Color(8, 12, 19, 255));
        jScrollPane.setBorder(new RoundBorder(15, Color.WHITE));
        companyListPanel.add(jScrollPane);

    }

    private DefaultListModel<Company> UpdateCompanyList(){
        // Createing a new listModel
        DefaultListModel<Company> listModel = new DefaultListModel<>();

        // Adding the companies to the listModel
        App.companyMangger.getCompanies().forEach((k, v) -> {
            listModel.addElement(v);
        });

        // Sort the listModel
        for (int i = 0; i < listModel.getSize(); i++) {
            for (int j = 0; j < listModel.getSize() - i - 1; j++) {
                if (listModel.getElementAt(j).compareTo(listModel.getElementAt(j + 1)) > 0) {
                    Company temp = listModel.getElementAt(j);
                    listModel.setElementAt(listModel.getElementAt(j + 1), j);
                    listModel.setElementAt(temp, j + 1);
                }
            }
        }

        return listModel;
    }
}
