package com.modreniraq.cdms.controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.modreniraq.cdms.models.db.dao.UserDetailsDao;
import com.modreniraq.cdms.models.db.type.UsersType;
import com.modreniraq.cdms.models.db.vo.UserDetailsVo;
import com.modreniraq.cdms.models.db.vo.UsersVo;
import com.modreniraq.cdms.validation.Validation;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
//import javafx.stage.Stage;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ali alshara
 */
public class UserViewController implements Initializable {

    @FXML
    private TableColumn<UserDetailsVo, String> colFatherName;

    @FXML
    private JFXTextField txtMobile;

    @FXML
    private TableColumn<UserDetailsVo, String> colUserType;

    @FXML
    private JFXComboBox comboUserType;

    @FXML
    private JFXTextField txtFatherName;

    @FXML
    private TableColumn<UserDetailsVo, String> colMobile;

    @FXML
    private TableColumn<UserDetailsVo, String> colFirstName;

    @FXML
    private TableColumn<UserDetailsVo, String> colSpecialization;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXComboBox comboSpecialization;

    @FXML
    private TableColumn<UserDetailsVo, String> colPassword;

    @FXML
    private TableColumn<UserDetailsVo, Integer> colID;

    @FXML
    private JFXTextField txtFirstName;

    @FXML
    private TableColumn<UserDetailsVo, String> colUsername;

    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private BorderPane borderUser;
//    @FXML
//    private Label lbl;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private TableView<UserDetailsVo> TableUsers;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        LoadALL();

    }

    private void LoadALL() {
        try {
            ObservableList<UserDetailsVo> users = UserDetailsDao.getInstance().loadAll();
            colID.setCellValueFactory(c -> c.getValue().getUsersVo().IdProperty().asObject());
            colUsername.setCellValueFactory(c -> c.getValue().getUsersVo().UserNameProperty());
            colPassword.setCellValueFactory(c -> c.getValue().getUsersVo().PasswordProperty());
            colFirstName.setCellValueFactory(c -> c.getValue().FirstNameProperty());
            colFatherName.setCellValueFactory(c -> c.getValue().FatherNameProperty());
            colMobile.setCellValueFactory(c -> c.getValue().MobileProperty());
            colSpecialization.setCellValueFactory(c -> c.getValue().SpecializationProperty());
            colUserType.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getUsersVo().getUsersType().getType()));
            TableUsers.setItems(users);
        } catch (Exception ex) {
            Logger.getLogger(UserViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @FXML
//    private void onmouseclose(MouseEvent event) {
//        Stage stage = (Stage) lbl.getScene().getWindow();
//        stage.close();
//    }

    @FXML
    private void onAdd(ActionEvent event) {
        boolean isLetter = Validation.isLetter(txtFirstName.getText(), txtFatherName.getText(), (String) comboUserType.getSelectionModel().getSelectedItem(), (String) comboSpecialization.getSelectionModel().getSelectedItem());
        if (isLetter == false) {
            JOptionPane.showMessageDialog(null, "some text is empty or not letters");
            return;
        }
        boolean isDigit = Validation.isDigit(txtID.getText(), txtMobile.getText());
        if (isDigit == false) {
            JOptionPane.showMessageDialog(null, "some text is empty or not digit");
            return;
        }
        boolean isDigitAndLetterAndChar = Validation.isDigitAndLetterAndChar(txtUsername.getText(), txtPassword.getText());
        if (isDigitAndLetterAndChar == false) {
            JOptionPane.showMessageDialog(null, "some text is empty");
            return;
        }
        int id = Integer.valueOf(txtID.getText());
        String userName = txtUsername.getText();
        String password = txtPassword.getText();
        // UsersType usersType = UsersType.getUserstypeByType((String) comboUserType.getSelectionModel().getSelectedItem());
        UsersType usersType1 = UsersType.getUsersTypeById(comboUserType.getSelectionModel().getSelectedIndex() + 1);
        // System.err.println(usersType);
        UsersVo usersVo = new UsersVo();
        usersVo.setId(id);
        usersVo.setUserName(userName);
        usersVo.setPassword(password);
        usersVo.setUsersType(usersType1);
        String firstName = txtFirstName.getText();
        String fatherName = txtFatherName.getText();
        String mobile = txtMobile.getText();
        String specialization = (String) comboSpecialization.getSelectionModel().getSelectedItem();
        System.err.println(specialization);
        UserDetailsVo userDetailsVo = new UserDetailsVo();
        userDetailsVo.setUsersVo(usersVo);
        userDetailsVo.setFirstName(firstName);
        userDetailsVo.setFatherName(fatherName);
        userDetailsVo.setMobile(mobile);
        userDetailsVo.setSpecialization(specialization);
        // userDetailsVo.setImage(ImageByte);
        try {
            // int UserCount = UsersDao.getInstance().insert(usersVo);
            int Count = UserDetailsDao.getInstance().insert(userDetailsVo);
            if (Count == 1) {
                System.out.println("inserted successfully");
                Validation.resetTextField(txtID, txtUsername, txtPassword, txtFirstName, txtFatherName, txtMobile);
                Validation.resetCombo(comboUserType, comboSpecialization);
            } else {
                System.out.println("inserted not successfully");
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        LoadALL();
    }

    @FXML
    private void onEdit(ActionEvent event) {
        boolean isLetter = Validation.isLetter(txtFirstName.getText(), txtFatherName.getText(), (String) comboUserType.getSelectionModel().getSelectedItem(), (String) comboSpecialization.getSelectionModel().getSelectedItem());
        if (isLetter == false) {
            JOptionPane.showMessageDialog(null, "some text is empty or not letters");
            return;
        }
        boolean isDigit = Validation.isDigit(txtID.getText(), txtMobile.getText());
        if (isDigit == false) {
            JOptionPane.showMessageDialog(null, "some text is empty or not digit");
            return;
        }
        boolean isDigitAndLetterAndChar = Validation.isDigitAndLetterAndChar(txtUsername.getText(), txtPassword.getText());
        if (isDigitAndLetterAndChar == false) {
            JOptionPane.showMessageDialog(null, "some text is empty");
            return;
        }
        int id = Integer.valueOf(txtID.getText());
        String userName = txtUsername.getText();
        String password = txtPassword.getText();
        // UsersType usersType = UsersType.getUserstypeByType((String) comboUserType.getSelectionModel().getSelectedItem());
        UsersType usersType1 = UsersType.getUsersTypeById(comboUserType.getSelectionModel().getSelectedIndex() + 1);
        // System.err.println(usersType);
        UsersVo usersVo = new UsersVo();
        usersVo.setId(id);
        usersVo.setUserName(userName);
        usersVo.setPassword(password);
        usersVo.setUsersType(usersType1);
        String firstName = txtFirstName.getText();
        String fatherName = txtFatherName.getText();
        String mobile = txtMobile.getText();
        String specialization = (String) comboSpecialization.getSelectionModel().getSelectedItem();
        // System.err.println(specialization);
        UserDetailsVo userDetailsVo = new UserDetailsVo();
        userDetailsVo.setUsersVo(usersVo);
        userDetailsVo.setFirstName(firstName);
        userDetailsVo.setFatherName(fatherName);
        userDetailsVo.setMobile(mobile);
        userDetailsVo.setSpecialization(specialization);
        // userDetailsVo.setImage(ImageByte);

        try {
            // int UserCount = UsersDao.getInstance().insert(usersVo);
            int Count = UserDetailsDao.getInstance().update(userDetailsVo);
            if (Count == 1) {
                System.out.println("update successfully");
                Validation.resetTextField(txtID, txtUsername, txtPassword, txtFirstName, txtFatherName, txtMobile);
                Validation.resetCombo(comboUserType, comboSpecialization);
            } else {
                System.out.println("update not successfully");
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        LoadALL();
    }

    @FXML
    private void onDelete(ActionEvent event) {
    }

}
