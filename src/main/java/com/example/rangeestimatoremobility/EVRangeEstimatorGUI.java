package com.example.rangeestimatoremobility;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EVRangeEstimatorGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Electric Vehicle Range Estimator");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label makeLabel = new Label("Vehicle Brand:");
        grid.add(makeLabel, 0, 0);
        TextField makeTextField = new TextField();
        grid.add(makeTextField, 1, 0);

        Label modelLabel = new Label("Vehicle Model:");
        grid.add(modelLabel, 0, 1);
        TextField modelTextField = new TextField();
        grid.add(modelTextField, 1, 1);

        Label batteryCapacityLabel = new Label("Battery Capacity (kWh):");
        grid.add(batteryCapacityLabel, 0, 2);
        TextField batteryCapacityTextField = new TextField();
        grid.add(batteryCapacityTextField, 1, 2);

        Label energyConsumptionLabel = new Label("Energy Consumption (Wh/km):");
        grid.add(energyConsumptionLabel, 0, 3);
        TextField energyConsumptionTextField = new TextField();
        grid.add(energyConsumptionTextField, 1, 3);

        Label weatherLabel = new Label("Weather:");
        grid.add(weatherLabel, 0, 4);
        ComboBox<String> weatherComboBox = new ComboBox<>(FXCollections.observableArrayList("sunny", "rainy", "snowy", "windy"));
        weatherComboBox.getSelectionModel().selectFirst();
        grid.add(weatherComboBox, 1, 4);

        Label roadConditionLabel = new Label("Road Condition:");
        grid.add(roadConditionLabel, 0, 5);
        ComboBox<String> roadConditionComboBox = new ComboBox<>(FXCollections.observableArrayList("flat", "uphill", "downhill", "rough"));
        roadConditionComboBox.getSelectionModel().selectFirst();
        grid.add(roadConditionComboBox, 1, 5);

        Label trafficConditionLabel = new Label("Traffic Condition:");
        grid.add(trafficConditionLabel, 0, 6);
        ComboBox<String> trafficConditionComboBox = new ComboBox<>(FXCollections.observableArrayList("light", "moderate", "heavy"));
        trafficConditionComboBox.getSelectionModel().selectFirst();
        grid.add(trafficConditionComboBox, 1, 6);

        Button submitButton = new Button("Estimate Range");
        HBox submitButtonBox = new HBox(10);
        submitButtonBox.setAlignment(Pos.BOTTOM_RIGHT);
        submitButtonBox.getChildren().add(submitButton);
        grid.add(submitButtonBox, 1, 7);

        submitButton.setOnAction(event -> {
            String make = makeTextField.getText();
            String model = modelTextField.getText();
            double batteryCapacity = Double.parseDouble(batteryCapacityTextField.getText());
            double energyConsumption = Double.parseDouble(energyConsumptionTextField.getText());
            String weather = weatherComboBox.getSelectionModel().getSelectedItem();
            String roadCondition = roadConditionComboBox.getSelectionModel().getSelectedItem();
            String trafficCondition = trafficConditionComboBox.getSelectionModel().getSelectedItem();


            Battery battery = new Battery(batteryCapacity, 100, energyConsumption);
            ElectricVehicle ev = new ElectricVehicle(make, model, batteryCapacity, energyConsumption, battery);
            DrivingConditions conditions = new DrivingConditions(weather, roadCondition, trafficCondition);
            RangeEstimation estimation = ev.getRangeEstimation(conditions);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Range Estimation");
            alert.setHeaderText("Estimated Range for " + make + " " + model);
            alert.setContentText("Estimated Range: " + estimation.getEstimatedRange() + " km\n" +
                    "Driving Conditions: " + conditions.getWeather() + ", " + conditions.getRoadCondition() + ", " + conditions.getTrafficCondition());
            alert.showAndWait();
        });

        Scene scene = new Scene(grid, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
