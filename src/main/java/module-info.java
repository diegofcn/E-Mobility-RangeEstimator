module com.example.rangeestimatoremobility {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.rangeestimatoremobility to javafx.fxml;
    exports com.example.rangeestimatoremobility;
}