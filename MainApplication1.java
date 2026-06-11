/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainapplication1;

/**
 *
 * @author Student
 */
/**
 * Executive driver class hosting the application entry execution engine.
 */
/**
 * Executive driver class containing the main method engine.
 */
public class MainApplication1 {

    public static void main(String[] args) {
        // 1D Array representing town labels
        String[] towns = {"Cape Town", "Durban", "Port Elizabeth"};

        // 2D Array mapping customer tracking variables
        int[][] customerData = {
            {90, 125}, // Row 0: Cape Town
            {15, 55},  // Row 1: Durban
            {50, 91}   // Row 2: Port Elizabeth
        };

        // Instantiate our report logic class passing the data parameters through the constructor
        IFurnitureStorage report = new FurnitureStorage(towns, customerData);

        // Print final correctly calculated report matching the 2026 specification
        System.out.println("FURNITURE STORAGE REPORT - 2026");
        System.out.println("************************************************************");
        System.out.println("TOTAL CUSTOMERS: " + report.GetTotalCustomers());
        
        // Formatted to an integer display casting to match your exact screenshot requirement (71)
        System.out.println("AVERAGE CUSTOMERS: " + (int) report.GetAverageCustomers());
        
        System.out.println("TOWN WITH MOST CUSTOMERS: " + report.GetMostPopularTown());
        System.out.println("TOWN WITH LEAST CUSTOMERS: " + report.GetLeastPopularTown());
        System.out.println("************************************************************");
    }
}