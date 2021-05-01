package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;
import org.loose.fis.sre.services.HouseService;
import org.loose.fis.sre.services.BookingService;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        initDirectory();
        UserService.initDatabase();
        HouseService.initDatabase();
        BookingService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("open_app.fxml"));
        primaryStage.setTitle("Agentie imobiliara");
        primaryStage.setScene(new Scene(root,600, 575));
        primaryStage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
        Path houseHomePath = FileSystemService.HOUSE_HOME_PATH;
        if(!Files.exists(houseHomePath))
            houseHomePath.toFile().mkdirs();
        Path bookingHomePath = FileSystemService.BOOKING_HOME_PATH;
        if(!Files.exists(bookingHomePath))
            bookingHomePath.toFile().mkdirs();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
