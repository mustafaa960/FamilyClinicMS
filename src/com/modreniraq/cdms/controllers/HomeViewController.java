/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modreniraq.cdms.controllers;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ali alshara
 */
public class HomeViewController implements Initializable {

    @FXML
    private JFXHamburger hambBtn;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private StackPane stackPaneHome;

    @FXML
    private BorderPane borderPaneHome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            VBox box = FXMLLoader.load(getClass().getResource("/com/modreniraq/cdms/views/HomeBarView.fxml"));
            drawer.setSidePane(box);
            

            for (Node node : box.getChildren()) {
                if (node.getId() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {

                        switch (node.getId()) {
                            case "userView":

                                FXMLLoader fXMLLoader = new FXMLLoader();
                                try {
                                    fXMLLoader.load(getClass().getResource("/com/modreniraq/cdms/views/UserView.fxml").openStream());
                                    
                                    BorderPane borderPane = fXMLLoader.getRoot();
//                                    Scene scene = new Scene(borderPane);
//                                    Stage stage=new Stage();
//                                    stage.initStyle(StageStyle.UNDECORATED);
//                                    stage.setScene(scene);
                                    
                                    stackPaneHome.getChildren().clear();
                                    stackPaneHome.getChildren().add(borderPane);
                                } catch (IOException ex) {
                                    Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            case "2":
                                System.out.println("2");
                        }
                    });
                }
            }

            HamburgerNextArrowBasicTransition transition = new HamburgerNextArrowBasicTransition(hambBtn);
            transition.setRate(-1);
            hambBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                transition.setRate(transition.getRate() * -1);
                transition.play();
                if (drawer.isShown()) {
                    drawer.close();
                    
                } else {
                    drawer.open();
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
