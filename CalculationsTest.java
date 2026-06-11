/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.furniturestoragegui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        // Arrange: Price of 1000, duration of 3 months
        double price = 1000.0;
        int duration = 3;
        Calculations calc = new Calculations(price, duration);
        
        // Act: Run target function 
        double actualVat = calc.GetVat();
        
        // Assert: 15% of 1000 is 150
        double expectedVat = 150.0;
        assertEquals(expectedVat, actualVat, 0.001, "The VAT calculation should return 15% of the base price.");
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        // Arrange: Price of 1000, duration of 3 months
        double price = 1000.0;
        int duration = 3;
        Calculations calc = new Calculations(price, duration);
        
        // Act: Run target function
        double actualTotal = calc.GetTotal();
        
        // Assert: (1000 + 150) * 3 = 3450
        double expectedTotal = 3450.0;
        assertEquals(expectedTotal, actualTotal, 0.001, "The Total calculation should equal (Price + VAT) * Duration.");
    }
}