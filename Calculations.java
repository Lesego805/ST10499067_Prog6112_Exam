/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.furniturestoragegui;

/**
 *
 * @author Student
 */
public class Calculations implements ICalculations {
    private final double price;
    private final int duration;
    
    // Constant for VAT (15%)
    private static final double VAT_RATE = 0.15;

    public Calculations(double price, int duration) {
        this.price = price;
        this.duration = duration;
    }

    @Override
    public double GetVat() {
        return price * VAT_RATE;
    }

    @Override
    public double GetTotal() {
        return (price + GetVat()) * duration;
    }
}