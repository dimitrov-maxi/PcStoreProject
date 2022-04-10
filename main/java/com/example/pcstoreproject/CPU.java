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
    //    public CPU(int CPUid, String manufacturer, String model, float baseFrequency, float boostFrequency, int coreCount, int threadCount, int chipsetID, int quantity, int price){
//        this.CPUid = CPUid;
//        Manufacturer = manufacturer;
//        Model = model;
//        BaseFrequency = baseFrequency;
//        BoostFrequency = boostFrequency;
//        CoreCount = coreCount;
//        ThreadCount = threadCount;
//        ChipsetID = chipsetID;
//        this.Quantity = quantity;
//        this.Price = price;
//    }


    public CPU(String CPUName, int CPUQuantity, double CPUPrice){
        this.Model = CPUName;
        this.Quantity = CPUQuantity;
        this.Price = CPUPrice;
    }

//    public CPU(TableColumn<CPU, String> CPUName, TableColumn<CPU, Integer> CPUQuantity, TableColumn<CPU, Double> CPUPrice) {
//        this.Model = String.valueOf(CPUName);
//        this.Quantity = Integer.parseInt(String.valueOf(CPUQuantity));
//        this.Price = Double.parseDouble(String.valueOf(CPUPrice));
//    }
}
