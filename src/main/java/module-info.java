module com.example.ooplqb8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ooplqb8 to javafx.fxml;
    exports com.example.ooplqb8;
}