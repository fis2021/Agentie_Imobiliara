package org.loose.fis.sre.controllers;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Open_app_register {
    public void handleOpenRegister()
    {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
            Stage stage=new Stage();
            stage.setTitle("Agentie Imobiliara");
            stage.setScene(new Scene(root,400,375));
            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
