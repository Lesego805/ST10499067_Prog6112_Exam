/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapplication1;

/**
 *
 * @author Student
 */
public class FurnitureStorage implements IFurnitureStorage {
    
    // 1D array for the towns/columns
    private final String[] towns = {"Cape Town", "Durban", "Port Elizabeth"};
    
    // 2D array for the customer data (Rows = Years, Columns = Towns)
    private final int[][] customerData = {
        {90, 15, 50},  // Year 1
        {125, 55, 91}  // Year 2
    };

    @Override
    public int GetTotalCustomers() {
        int total = 0;
        for (int[] row : customerData) {
            for (int value : row) {
                total += value;
            }
        }
        return total;
    }

    @Override
    public double GetAverageCustomers() {
        int total = GetTotalCustomers();
        // Total elements = 2 rows * 3 columns = 6
        int totalElements = customerData.length * customerData[0].length;
        return (double) total / totalElements;
    }

    @Override
    public String GetMostPopularTown() {
        int maxCustomers = -1;
        String mostPopularTown = "";

        // Loop through each town (column)
        for (int col = 0; col < towns.length; col++) {
            int townTotal = 0;
            // Sum the values across all years (rows) for this town
            for (int row = 0; row < customerData.length; row++) {
                townTotal += customerData[row][col];
            }
            
            // Check if this town has the highest combined total
            if (townTotal > maxCustomers) {
                maxCustomers = townTotal;
                mostPopularTown = towns[col] + " (" + maxCustomers + ")";
            }
        }
        return mostPopularTown;
    }

    @Override
    public String GetLeastPopularTown() {
        int minCustomers = Integer.MAX_VALUE;
        String leastPopularTown = "";

        // Loop through each town (column)
        for (int col = 0; col < towns.length; col++) {
            int townTotal = 0;
            // Sum the values across all years (rows) for this town
            for (int row = 0; row < customerData.length; row++) {
                townTotal += customerData[row][col];
            }
            
            // Check if this town has the lowest combined total
            if (townTotal < minCustomers) {
                minCustomers = townTotal;
                leastPopularTown = towns[col] + " (" + minCustomers + ")";
            }
        }
        return leastPopularTown;
    }
}