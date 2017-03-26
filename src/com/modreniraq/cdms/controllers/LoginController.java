/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modreniraq.cdms.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.modreniraq.cdms.models.db.dao.UsersDao;
import com.modreniraq.cdms.models.db.vo.UsersVo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author ali alshara
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    public void Login(ActionEvent event) {
        StringProperty username = txtUsername.textProperty();
        StringProperty password = txtPassword.textProperty();
        UsersVo usersVo = new UsersVo();
        usersVo.setUserName(username.getValue());
        usersVo.setPassword(password.getValue());
        try {
            UsersVo uv = UsersDao.getInstance().getData(usersVo);
            if (uv == null) {
                System.err.println("enter valid user name and password");
            } else {
                System.out.println(uv.getUserName() + "  " + uv.getPassword()+"  "+uv.getUsersType().getId());
               Parent root = FXMLLoader.load(getClass().getResource("/com/modreniraq/cdms/views/HomeView.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setMaximized(true);
               // stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
//                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // TODO
    }

}
