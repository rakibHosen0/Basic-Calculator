module com.bd.edu.seu {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.bd.edu.seu to javafx.fxml;
    exports com.bd.edu.seu;
}