package org.aconitum.analytics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.aconitum.analytics.database.DatabaseManager;

import java.io.IOException;

public class AnalyticsApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // TRIGGER DATABASE CREATION HERE
        DatabaseManager.initialize();

        FXMLLoader fxmlLoader = new FXMLLoader(AnalyticsApp.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Acanitum Analytics");
        stage.setScene(scene);
        stage.show();
    }
}
