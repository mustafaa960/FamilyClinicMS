/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modreniraq.cdms.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ali alshara
 */
public class WelcomeViewController implements Initializable {

    @FXML
    private StackPane stackPaneWelcome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        new welcomeScreen().start();
        
    }

    class welcomeScreen extends Thread {

        public void run() {
            try {
                Thread.sleep(5000);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/com/modreniraq/cdms/views/Login.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(WelcomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setTitle("Login");
                        stage.setResizable(false);
//                        stage.setMaximized(true);
//                        stage.setFullScreen(true);
//                        stage.initModality(Modality.WINDOW_MODAL);
                        stage.centerOnScreen();
                        stage.setScene(scene);
                        stage.show();
                        stackPaneWelcome.getScene().getWindow().hide();

                    }
                });

            } catch (InterruptedException ex) {
                Logger.getLogger(WelcomeViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
