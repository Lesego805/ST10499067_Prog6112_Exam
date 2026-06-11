/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapplication1;

/**
 *
 * @author Student
 */
/**
 * Business logic processing engine implementing analytical calculations.
 */
/**
 * Business logic processing engine that implements your exact IFurnitureStorage interface.
 */
public class FurnitureStorage implements IFurnitureStorage {
    
    // Internal data storage arrays
    private final String[] towns;
    private final int[][] customerData;

    /**
     * Constructor to pass the arrays directly into the calculation engine.
     */
    public FurnitureStorage(String[] towns, int[][] customerData) {
        this.towns = towns;
        this.customerData = customerData;
    }

    /**
     * Calculates the total sum of all customers across all rows and columns.
     */
    @Override
    public int GetTotalCustomers() {
        int total = 0;
        for (int[] townRow : customerData) {
            for (int count : townRow) {
                total += count;
            }
        }
        return total;
    }

    /**
     * Calculates the mathematical average count based on the total elements (6 sectors).
     */
    @Override
    public double GetAverageCustomers() {
        int totalCustomers = GetTotalCustomers();
        int totalElements = towns.length * customerData[0].length; // 3 towns * 2 years = 6
        
        if (totalElements == 0) return 0;
        return (double) totalCustomers / totalElements;
    }

    /**
     * Scans single cell entries to find the absolute peak value.
     * Returns: "Cape Town (125)"
     */
    @Override
    public String GetMostPopularTown() {
        int maxCustomers = Integer.MIN_VALUE;
        String popularTown = "";

        for (int i = 0; i < towns.length; i++) {
            for (int j = 0; j < customerData[i].length; j++) {
                if (customerData[i][j] > maxCustomers) {
                    maxCustomers = customerData[i][j];
                    popularTown = towns[i];
                }
            }
        }
        return popularTown + " (" + maxCustomers + ")";
    }

    /**
     * Scans single cell entries to find the absolute lowest value.
     * Returns: "Durban (15)"
     */
    @Override
    public String GetLeastPopularTown() {
        int minCustomers = Integer.MAX_VALUE;
        String quietTown = "";

        for (int i = 0; i < towns.length; i++) {
            for (int j = 0; j < customerData[i].length; j++) {
                if (customerData[i][j] < minCustomers) {
                    minCustomers = customerData[i][j];
                    quietTown = towns[i];
                }
            }
        }
        return quietTown + " (" + minCustomers + ")";
    }
}