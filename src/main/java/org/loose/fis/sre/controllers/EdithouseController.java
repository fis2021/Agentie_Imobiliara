package org.loose.fis.sre.controllers;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.loose.fis.sre.model.House;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.HouseDoesNotExistsException;
import org.loose.fis.sre.services.HouseService;


public class EdithouseController {

    @FXML
    private Text edithouseMessage;
    @FXML
    private TextField Address;
    @FXML
    private TextField Size;
    @FXML
    private TextField Rooms;
    @FXML
    private TextField Baths;
    @FXML
    private TextField Floors;
    @FXML
    private TextField Special;


    @FXML
    public void handleEditHouseAction(){
        try
        {
            HouseService.searchHouse(Address.getText());
            edithouseMessage.setText("Changes saved successfully!");
        }
        catch (HouseDoesNotExistsException e) {
            edithouseMessage.setText(e.getMessage());
        }
    }
}