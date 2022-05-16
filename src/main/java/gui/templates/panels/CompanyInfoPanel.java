package gui.templates.panels;

import gui.MainWindow;
import models.Company;

import javax.swing.*;
import java.awt.*;

/**
 * Company information panel.
 * it's shows the selected company information.
 */
public class CompanyInfoPanel extends JPanel {

    private Company company;

    private JLabel companyName;

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
    private void initComponents() {
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
    }

    public void setCompany(Company company) {
        this.company = company;

        if(company != null) {
            companyName.setText(company.getName());
            setVisible(true);
        }else{
            setVisible(false);
        }
    }
}
