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
import org.loose.fis.sre.exceptions.HouseDoesNotExistsException;
import org.loose.fis.sre.services.BookingService;


public class BookingController {
    @FXML
    private Text make_bookingMessage;
    @FXML
    private TextField address;
    @FXML
    private TextField special_req;
    @FXML
    private ChoiceBox day;
    @FXML
    private ChoiceBox hour;
    @FXML
    private ChoiceBox agent_book;
    @FXML
    private TextField username;

    @FXML
    public void initialize() {
        day.getItems().addAll("Monday", "Tuesday", "Wednsday", "Thursday", "Friday");
        hour.getItems().addAll("9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00");
        agent_book.getItems().addAll("Angela", "Agnes" ,"Angelo", "Agel");
    }


    @FXML
    public void handleBookingAction(){
        try
        {
            BookingService.addBooking(address.getText(),(String) day.getValue(),(String) hour.getValue(),
                    (String) agent_book.getValue(),special_req.getText(),username.getText());
            make_bookingMessage.setText("Booking saved successfully!");
        }
        catch (BookingAlreadyExistsException e) {
            make_bookingMessage.setText(e.getMessage());
       }
        catch (IncorectCredentials e) {
            make_bookingMessage.setText(e.getMessage());
        }
        catch (HouseDoesNotExistsException e) {
            make_bookingMessage.setText(e.getMessage());
        }
    }
}