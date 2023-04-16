package com.example.rangeestimatoremobility;

public class RangeEstimation {
    private double estimatedRange; // in km
    private ElectricVehicle electricVehicle;
    private DrivingConditions drivingConditions;

    // Constructor
    public RangeEstimation(double estimatedRange, ElectricVehicle electricVehicle, DrivingConditions drivingConditions) {
        this.estimatedRange = estimatedRange;
        this.electricVehicle = electricVehicle;
        this.drivingConditions = drivingConditions;
    }

    // Getters
    public double getEstimatedRange() {
        return estimatedRange;
    }

    public ElectricVehicle getElectricVehicle() {
        return electricVehicle;
    }

    public DrivingConditions getDrivingConditions() {
        return drivingConditions;
    }

    // Setters
    public void setEstimatedRange(double estimatedRange) {
        this.estimatedRange = estimatedRange;
    }

    public void setElectricVehicle(ElectricVehicle electricVehicle) {
        this.electricVehicle = electricVehicle;
    }

    public void setDrivingConditions(DrivingConditions drivingConditions) {
        this.drivingConditions = drivingConditions;
    }

    public void displayEstimation() {
        System.out.println("Estimated Range: " + String.format("%.2f", estimatedRange) + " km");
        System.out.println("Vehicle Details:");
        System.out.println("  Make: " + electricVehicle.getMake());
        System.out.println("  Model: " + electricVehicle.getModel());
        System.out.println("  Battery Capacity: " + electricVehicle.getBatteryCapacity() + " kWh");
        System.out.println("  Energy Consumption: " + electricVehicle.getEnergyConsumption() + " Wh/km");
        System.out.println("Driving Conditions:");
        System.out.println("  Weather: " + drivingConditions.getWeather());
        System.out.println("  Road Condition: " + drivingConditions.getRoadCondition());
        System.out.println("  Traffic Condition: " + drivingConditions.getTrafficCondition());
    }

}
