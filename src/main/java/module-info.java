module org.example.laba22222222 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.laba22222222 to javafx.fxml;
    exports org.example.laba22222222;

    opens org.example.laba22222222.lab2 to javafx.fxml;
    exports org.example.laba22222222.lab2;
}