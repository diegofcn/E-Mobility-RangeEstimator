package com.example.rangeestimatoremobility;

public class DrivingConditions {
    private String weather;
    private String roadCondition;
    private String trafficCondition;

    // Constructor
    public DrivingConditions(String weather, String roadCondition, String trafficCondition) {
        this.weather = weather;
        this.roadCondition = roadCondition;
        this.trafficCondition = trafficCondition;
    }

    // Getters
    public String getWeather() {
        return weather;
    }

    public String getRoadCondition() {
        return roadCondition;
    }

    public String getTrafficCondition() {
        return trafficCondition;
    }

    // Setters
    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setRoadCondition(String roadCondition) {
        this.roadCondition = roadCondition;
    }

    public void setTrafficCondition(String trafficCondition) {
        this.trafficCondition = trafficCondition;
    }

    public double getEnergyConsumptionAdjustmentFactor() {
        double weatherFactor = getWeatherFactor();
        double roadConditionFactor = getRoadConditionFactor();
        double trafficConditionFactor = getTrafficConditionFactor();

        return weatherFactor * roadConditionFactor * trafficConditionFactor;
    }

    private double getWeatherFactor() {
        switch (weather.toLowerCase()) {
            case "rainy":
                return 1.1;
            case "snowy":
                return 1.3;
            case "windy":
                return 1.05;
            default: // "sunny" or any other condition
                return 1.0;
        }
    }

    private double getRoadConditionFactor() {
        switch (roadCondition.toLowerCase()) {
            case "uphill":
                return 1.2;
            case "downhill":
                return 0.9;
            case "rough":
                return 1.1;
            default: // "flat" or any other condition
                return 1.0;
        }
    }

    private double getTrafficConditionFactor() {
        switch (trafficCondition.toLowerCase()) {
            case "heavy":
                return 1.1;
            case "moderate":
                return 1.05;
            default: // "light" or any other condition
                return 1.0;
        }
    }
}
