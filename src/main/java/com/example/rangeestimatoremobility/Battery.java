package com.example.rangeestimatoremobility;


public class Battery {
    private double capacity; // in kWh
    private double stateOfCharge; // percentage (0 - 100)
    private double dischargeRate; // in Wh/km

    // Constructor
    public Battery(double capacity, double stateOfCharge, double dischargeRate) {
        this.capacity = capacity;
        this.stateOfCharge = stateOfCharge;
        this.dischargeRate = dischargeRate;
    }

    // Getters
    public double getCapacity() {
        return capacity;
    }

    public double getStateOfCharge() {
        return stateOfCharge;
    }

    public double getDischargeRate() {
        return dischargeRate;
    }

    // Setters
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setStateOfCharge(double stateOfCharge) {
        this.stateOfCharge = stateOfCharge;
    }

    public void setDischargeRate(double dischargeRate) {
        this.dischargeRate = dischargeRate;
    }

    public double getRemainingEnergy() {
        return capacity * stateOfCharge / 100; // Convert percentage to energy in kWh
    }

    public double estimateRange(double energyConsumption) {
        double remainingEnergy = getRemainingEnergy(); // Get remaining energy in kWh
        double remainingEnergyInWh = remainingEnergy * 1000; // Convert kWh to Wh
        return remainingEnergyInWh / energyConsumption; // Calculate the estimated range in km
    }

}

