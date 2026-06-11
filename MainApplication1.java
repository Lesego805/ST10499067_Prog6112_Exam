/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainapplication1;

/**
 *
 * @author Student
 */
public class MainApplication1 {
    public static void main(String[] args) {
        // Instantiate the core business logic class
        IFurnitureStorage storageReport = new FurnitureStorage();
        
        // Instantiate the printing class
        PrintFurnitureStorage printer = new PrintFurnitureStorage();
        
        // Print out the finalized dataset summary matching the design layout
        printer.printReport(storageReport);
    }
}
