module org.example.potoki2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.test to javafx.fxml;
    exports org.example.test;

    opens org.example.test.potoki2 to javafx.fxml;
    exports org.example.test.potoki2;
}