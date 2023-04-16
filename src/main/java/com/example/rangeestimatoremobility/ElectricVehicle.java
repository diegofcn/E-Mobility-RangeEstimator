package com.example.rangeestimatoremobility;

public class ElectricVehicle {
    private String make;
    private String model;
    private double batteryCapacity; // in kWh
    private double energyConsumption; // in Wh/km
    private Battery battery; // Add a Battery attribute

    // Constructor
    public ElectricVehicle(String make, String model, double batteryCapacity, double energyConsumption, Battery battery) {
        this.make = make;
        this.model = model;
        this.batteryCapacity = batteryCapacity;
        this.energyConsumption = energyConsumption;
        this.battery = battery; // Initialize the Battery attribute
    }

    // Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    // Setters
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public RangeEstimation getRangeEstimation(DrivingConditions conditions) {
        // Calculate the adjusted energy consumption based on driving conditions
        double adjustedEnergyConsumption = energyConsumption * conditions.getEnergyConsumptionAdjustmentFactor();

        // Calculate the estimated range using the Battery object's estimateRange() method
        double estimatedRange = battery.estimateRange(adjustedEnergyConsumption);

        // Create a RangeEstimation object and return it
        return new RangeEstimation(estimatedRange, this, conditions);
    }
}
