module com.example.spellinggame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spellinggame to javafx.fxml;
    exports com.example.spellinggame;
}