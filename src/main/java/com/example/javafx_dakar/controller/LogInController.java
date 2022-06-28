package com.example.javafx_dakar.controller;

import com.example.javafx_dakar.Main;
import com.example.javafx_dakar.model.UserDAO;
import com.example.javafx_dakar.model.UserSingleton;
import com.example.javafx_dakar.utils.BCryptPassword;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws Exception {
        String bCryptPassword = UserDAO.getBCryptPassword(usernameField.getText());

        if (usernameField.getText().equals("")) {
            errorLabel.setText("Please input a username!");
        } else if (passwordField.getText().equals("")) {
            errorLabel.setText("Please input a password!");
        } else if (bCryptPassword.equals("")) {
            errorLabel.setText("Username or password was not found in database");
        } else {
            boolean isValidPassword = BCryptPassword.checkPassword(passwordField.getText(), bCryptPassword);
            if (isValidPassword) {
                UserSingleton userSingleton = UserSingleton.getInstance();
                userSingleton.setUsername(usernameField.getText());

                if (UserDAO.checkIfAdmin(usernameField.getText()) == 0) {
                    Parent root = FXMLLoader.load(Main.class.getResource("client-view.fxml"));
                    Stage clientWindow = new Stage();
                    clientWindow.setTitle("Library");
                    clientWindow.setScene(new Scene(root, 980, 530));
                    clientWindow.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } else if (UserDAO.checkIfAdmin(usernameField.getText()) == 1) {
                    Parent root = FXMLLoader.load(Main.class.getResource("administrator-view.fxml"));
                    Stage adminWindow = new Stage();
                    adminWindow.setTitle("Admin");
                    adminWindow.setScene(new Scene(root, 980, 530));
                    adminWindow.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                }
            } else {
                errorLabel.setText("The username or password is incorrect!");
            }
        }
    }

    @FXML
    protected void onRegisterButtonClick(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("register-view.fxml"));
        Stage registerWindow = new Stage();
        registerWindow.setTitle("Register window");
        registerWindow.setScene(new Scene(root, 600, 400));
        registerWindow.show();
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}