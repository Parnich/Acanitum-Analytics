module org.aconitum.analytics {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.aconitum.analytics to javafx.fxml;
    exports org.aconitum.analytics;
}