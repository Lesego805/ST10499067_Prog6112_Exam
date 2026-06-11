/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapplication1;

/**
 *
 * @author Student
 */
public class PrintFurnitureStorage {

    public void printReport(IFurnitureStorage storage) {
        System.out.println("FURNITURE STORAGE REPORT - 2026");
        System.out.println("**************************************************");
        System.out.println("TOTAL CUSTOMERS: " + storage.GetTotalCustomers());
        
        // Math.round is used here to match the sample screenshot's integer formatting (71)
        System.out.println("AVERAGE CUSTOMERS: " + Math.round(storage.GetAverageCustomers()));
        
        System.out.println("TOWN WITH MOST CUSTOMERS: " + storage.GetMostPopularTown());
        System.out.println("TOWN WITH LEAST CUSTOMERS: " + storage.GetLeastPopularTown());
        System.out.println("**************************************************");
    }
}