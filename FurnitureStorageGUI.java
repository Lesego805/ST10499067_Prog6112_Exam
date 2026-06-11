/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.furniturestoragegui;

/**
 *
 * @author Student
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FurnitureStorageGUI extends JFrame {
    // Form components
    private JTextField txtCustomerName;
    private JComboBox<Integer> cmbDuration;
    private JTextField txtPrice;
    private JButton btnProcess;
    private JButton btnSave;

    public FurnitureStorageGUI() {
        // Set up the Frame windows
        setTitle("Furniture Storage");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Create and add the menu bar system
        setJMenuBar(createMenuBar());

        // Layout layout constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 0: Customer Name
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Customer Name:"), gbc);
        gbc.gridx = 1;
        txtCustomerName = new JTextField(15);
        add(txtCustomerName, gbc);

        // Row 1: Duration
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Duration:"), gbc);
        gbc.gridx = 1;
        Integer[] durations = {3, 6, 12};
        cmbDuration = new JComboBox<>(durations);
        add(cmbDuration, gbc);

        // Row 2: Price
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Price:"), gbc);
        gbc.gridx = 1;
        txtPrice = new JTextField(15);
        add(txtPrice, gbc);

        // Row 3: Buttons
        gbc.gridx = 0; gbc.gridy = 3;
        btnProcess = new JButton("PROCESS");
        add(btnProcess, gbc);

        gbc.gridx = 1;
        btnSave = new JButton("SAVE");
        add(btnSave, gbc);

        // Wire ActionListeners to both buttons and menu items
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processData();
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
    }

    // Helper method to assemble the JMenuBar layout
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        // Tools Menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem saveItem = new JMenuItem("Save");

        processItem.addActionListener(e -> processData());
        saveItem.addActionListener(e -> saveData());

        toolsMenu.add(processItem);
        toolsMenu.add(saveItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        return menuBar;
    }

    // Method to capture inputs, run the calculation logic, and show dialog popup
    private void processData() {
        try {
            String name = txtCustomerName.getText().trim();
            int duration = (int) cmbDuration.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText().trim());

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a customer name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Calculations calc = new Calculations(price, duration);

            String message = String.format(
                    "Customer Name: %s\nStorage Duration: %d\nVAT: R %.1f\nTOTAL: R %.1f",
                    name, duration, calc.GetVat(), calc.GetTotal()
            );

            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric value for price.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to output calculated fields directly out to text log file
    private void saveData() {
        try {
            String name = txtCustomerName.getText().trim();
            int duration = (int) cmbDuration.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText().trim());

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a customer name before saving.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Calculations calc = new Calculations(price, duration);

            try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", false))) {
                writer.println("DATA LOG");
                writer.println("***************************");
                writer.println("Customer Name: " + name);
                writer.println("Storage Duration: " + duration);
                writer.println("VAT: R " + calc.GetVat());
                writer.println("TOTAL: R " + calc.GetTotal());
                writer.println("***************************");
                
                JOptionPane.showMessageDialog(this, "Data successfully saved to data.txt!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid information before saving.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioEx) {
            JOptionPane.showMessageDialog(this, "An error occurred while saving the file.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Run the GUI thread safely
        SwingUtilities.invokeLater(() -> {
            new FurnitureStorageGUI().setVisible(true);
        });
    }
}