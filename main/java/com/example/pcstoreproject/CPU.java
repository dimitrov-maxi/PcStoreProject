package com.example.pcstoreproject;

public class CPU {
    int CPUid;
    String Manufacturer;
    String Model;
    float BaseFrequency;
    float BoostFrequency;
    int CoreCount;
    int ThreadCount;
    int ChipsetID;
    int Quantity;
    double Price;

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public CPU(String CPUName, int CPUQuantity, double CPUPrice){
        this.Model = CPUName;
        this.Quantity = CPUQuantity;
        this.Price = CPUPrice;
    }
}
