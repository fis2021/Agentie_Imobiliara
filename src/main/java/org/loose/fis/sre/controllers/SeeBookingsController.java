package org.loose.fis.sre.controllers;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.loose.fis.sre.exceptions.*;
import org.loose.fis.sre.model.Booking;
import org.loose.fis.sre.controllers.LoginController;

import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.services.BookingService;
public class SeeBookingsController {

    @FXML
    private Text editbooking;
    @FXML
    private Text seebooksmesage;
    @FXML
    private TextField Name;
    @FXML
    private TextField Name2;
    @FXML
    private TextField Hour;
    @FXML
    private TextField Day;
    @FXML
    private TextField Month;
    @FXML
    private TextField Year;






    @FXML
    public void handleSeeBookings() {
        try {

            seebooksmesage.setText(BookingService.seeBookings(Name.getText()));
        } catch (NoBookigsExectpion e) {
            seebooksmesage.setText(e.getMessage());
        }

    }
    public void handleApprove()
    {
        try{
            BookingService.approveBooking(Name2.getText(),Hour.getText(),Day.getText(),Month.getText(),Year.getText());
            editbooking.setText("Booking approved!");
        }
        catch (IncorrectDateException e) {
            editbooking.setText(e.getMessage());
        }
        catch (AgentDoesNotExistException e) {
            editbooking.setText(e.getMessage());
        }
        catch (BookingNotFoundException e) {
            editbooking.setText(e.getMessage());
        }

    }
    public void handleReject()
    {
        try{
            BookingService.rejectBooking(Name2.getText(),Hour.getText(),Day.getText(),Month.getText(),Year.getText());
            editbooking.setText("Booking rejected!");
        }
        catch (IncorrectDateException e) {
            editbooking.setText(e.getMessage());
        }
        catch (AgentDoesNotExistException e) {
            editbooking.setText(e.getMessage());
        }
    }

}



