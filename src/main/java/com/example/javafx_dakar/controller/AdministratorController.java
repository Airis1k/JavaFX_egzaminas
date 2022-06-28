package com.example.javafx_dakar.controller;

import com.example.javafx_dakar.Main;
import com.example.javafx_dakar.model.Restaurant;
import com.example.javafx_dakar.model.RestaurantDAO;
import com.example.javafx_dakar.model.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdministratorController {
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField codeField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField foodTypeField;
    @FXML
    private TextField dishNameField;
    @FXML
    private TextField dishTextField;
    @FXML
    private Label errorLabel;

    @FXML
    protected void onCreateButtonClick() {
        String name = nameField.getText();
        String code = codeField.getText();
        String address = addressField.getText();
        String foodType = foodTypeField.getText();
        String dishName = dishNameField.getText();
        String dishText = dishTextField.getText();

        int userId = 1;

        try {
            if (name.equals("")) {
                errorLabel.setText("Name must not be empty!");
            } else if (code.equals("")) {
                errorLabel.setText("Code must not be empty!");
            } else if (address.equals("")) {
                errorLabel.setText("Address must not be empty!");
            } else if (foodType.equals("")) {
                errorLabel.setText("Food type must not be empty!");
            } else if (dishName.equals("")) {
                errorLabel.setText("Dish name must not be empty!");
            } else if (dishText.equals("")) {
                errorLabel.setText("Dish text must not be empty!");
            } else {
                Restaurant restaurant = new Restaurant(name, code, address, foodType, dishName, dishText, userId);
                RestaurantDAO.insert(restaurant);
                errorLabel.setText("Record has been created!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("Error.");
        }
    }

    @FXML
    protected void onUpdateButtonClick() {
        String id = idField.getText();
        String name = nameField.getText();
        String code = codeField.getText();
        String address = addressField.getText();
        String foodType = foodTypeField.getText();
        String dishName = dishNameField.getText();
        String dishText = dishTextField.getText();

        try {
            if (id.equals(null)) {
                errorLabel.setText("Id must not be empty!");
            }
            if (name.equals("")) {
                errorLabel.setText("Name must not be empty!");
            } else if (code.equals("")) {
                errorLabel.setText("Code must not be empty!");
            } else if (address.equals("")) {
                errorLabel.setText("Address must not be empty!");
            } else if (foodType.equals("")) {
                errorLabel.setText("Food type must not be empty!");
            } else if (dishName.equals("")) {
                errorLabel.setText("Dish name must not be empty!");
            } else if (dishText.equals("")) {
                errorLabel.setText("Dish text must not be empty!");
            } else {
                Restaurant restaurant = new Restaurant(Integer.parseInt(id), name, code, address, foodType, dishName, dishText);
                RestaurantDAO.update(restaurant);
                errorLabel.setText("Records has been updated!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("Error");
        }
    }

    @FXML
    protected void onSearchButtonClick() {

    }

    @FXML
    protected void onDeleteButtonClick() {
        int id = Integer.parseInt(idField.getText());

        try {
            RestaurantDAO.deleteById(id);
            errorLabel.setText("You have deleted record!");
        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("Error");
        }
    }

    @FXML
    protected void onLogOutButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("login-view.fxml"));
        Stage loginWindow = new Stage();
        loginWindow.setTitle("Login window");
        loginWindow.setScene(new Scene(root, 600, 400));
        // Lango parodymas.
        loginWindow.show();
        // Kodas reikalingas paslepti pries tai buvusi langa.
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
