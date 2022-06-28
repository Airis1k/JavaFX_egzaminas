package com.example.javafx_dakar.controller;

import com.example.javafx_dakar.Main;
import com.example.javafx_dakar.model.Order;
import com.example.javafx_dakar.model.OrderDAO;
import com.example.javafx_dakar.model.Restaurant;
import com.example.javafx_dakar.model.RestaurantDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientController {
    @FXML
    private TextField nameSearchField;
    @FXML
    private TextField nameOrderField;
    @FXML
    private TextField dishNameField;
    @FXML
    private TextField quantityField;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn codeColumn;
    @FXML
    private TableColumn addressColumn;
    @FXML
    private TableColumn foodTypeColumn;
    @FXML
    private TableColumn dishNameColumn;
    @FXML
    private TableColumn dishTextColumn;

    ObservableList<Restaurant> list = FXCollections.observableArrayList();

    @FXML
    protected void onOrderButtonClick() {
        String nameOrder = nameOrderField.getText();
        String dishName = dishNameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());

        Order order = new Order(nameOrder, dishName, quantity);
        OrderDAO.order(order);
    }

    @FXML
    protected void onSearchButtonClick() {
        list.clear();

        List<Restaurant> restaurantList = new ArrayList<>();
        if (nameSearchField.getText().equals("")) {
            restaurantList = RestaurantDAO.printAll();
        } else {
            restaurantList = RestaurantDAO.printByName(nameSearchField.getText());
        }

        for (Restaurant restaurant : restaurantList) {
            // Is DB saraso sudedame elementus i ObservableList (kad juos galetume matyti GUI).
            list.add(new Restaurant(restaurant.getName(), restaurant.getCode(), restaurant.getAddress(), restaurant.getFoodType(), restaurant.getDishName(), restaurant.getDishText()));

            // Priskiriame lenteles stulpeliams reiksmes is DB.
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
            addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
            foodTypeColumn.setCellValueFactory(new PropertyValueFactory<>("food_type"));
            dishNameColumn.setCellValueFactory(new PropertyValueFactory<>("dish_name"));
            dishTextColumn.setCellValueFactory(new PropertyValueFactory<>("dish_text"));
        }

        tableView.setItems(list);
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
