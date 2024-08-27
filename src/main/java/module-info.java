module org.example.workshop2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.workshop2 to javafx.fxml;
    exports org.example.workshop2;
    exports org.example.workshop2.controllers;
    opens org.example.workshop2.controllers to javafx.fxml;
}