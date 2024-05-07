module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;



    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.apache.poi.ooxml;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}