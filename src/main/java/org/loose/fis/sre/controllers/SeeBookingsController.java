package org.loose.fis.sre.controllers;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.loose.fis.sre.model.Booking;
import org.loose.fis.sre.controllers.LoginController;

import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.BookingAlreadyExistsException;
import org.loose.fis.sre.exceptions.IncorectCredentials;
import org.loose.fis.sre.exceptions.IncorrectDateException;
import org.loose.fis.sre.exceptions.HouseDoesNotExistsException;
import org.loose.fis.sre.services.BookingService;
public class SeeBookingsController {

    @FXML
    private Text seebooksmesage;
    @FXML
    private TextField Name;


    @FXML
    public void handleSeeBookings() {
        try {

            seebooksmesage.setText(BookingService.seeBookings(Name.getText()));
        } catch (IncorectCredentials e) {
            seebooksmesage.setText(e.getMessage());
        }

    }
}



