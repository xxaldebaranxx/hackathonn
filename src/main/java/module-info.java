module com.example.space_learn {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.space_learn to javafx.fxml;
    exports com.example.space_learn;
}