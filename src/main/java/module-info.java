module org.aconitum.analytics {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    opens org.aconitum.analytics to javafx.fxml;
    exports org.aconitum.analytics;
    exports org.aconitum.analytics.database;
}