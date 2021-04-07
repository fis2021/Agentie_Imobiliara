package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import exceptions.UserNameAlreadyExistsException;
import services.UserService;

public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Buyer", "Agent");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(fullNameField.getText(),phoneNumberField.getText(),usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (UserNameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}

