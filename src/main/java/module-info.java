module org.example.csc311_loancalculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.csc311_loancalculator to javafx.fxml;
    exports org.example.csc311_loancalculator;
}