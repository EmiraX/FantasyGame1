module com.example.fantasygame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fantasygame to javafx.fxml;
    exports com.example.fantasygame;
}