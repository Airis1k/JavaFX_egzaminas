package com.example.javafx_dakar.model;

import javafx.fxml.FXML;

import java.sql.*;
import java.util.ArrayList;

public class RestaurantDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/restaurant";

    @FXML
    public static void insert(Restaurant restaurant) {
        String query = "INSERT INTO istaiga\n" +
                "(name, code, address, food_type, dish_name, dish_text, user_id)\n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, restaurant.getName());
            preparedStatement.setString(2, restaurant.getCode());
            preparedStatement.setString(3, restaurant.getAddress());
            preparedStatement.setString(4, restaurant.getFoodType());
            preparedStatement.setString(5, restaurant.getDishName());
            preparedStatement.setString(6, restaurant.getDishText());
            preparedStatement.setInt(7, restaurant.getUserId());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Restaurant restaurant) {
        String query = "UPDATE istaiga\n" +
                "SET name = ?,\n" +
                "\tcode = ?,\n" +
                "    address = ?,\n" +
                "    food_type = ?,\n" +
                "    dish_name = ?,\n" +
                "    dish_text = ?\n" +
                "WHERE id = ?;";

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, restaurant.getName());
            preparedStatement.setString(2, restaurant.getCode());
            preparedStatement.setString(3, restaurant.getAddress());
            preparedStatement.setString(4, restaurant.getFoodType());
            preparedStatement.setString(5, restaurant.getDishName());
            preparedStatement.setString(6, restaurant.getDishText());
            preparedStatement.setInt(7, restaurant.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(int id) {
        String query = "DELETE FROM istaiga WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String searchByName(String name) {
        String query = "SELECT * FROM istaiga\n" +
                "WHERE name LIKE ?;";

        String name2 = "";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                name2 = resultSet.getString("name");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return name2;
    }

    public static ArrayList<Restaurant> printAll() {
        String query = "SELECT * FROM istaiga";
        ArrayList<Restaurant> list = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Restaurant(
                        resultSet.getString("name"),
                        resultSet.getString("code"),
                        resultSet.getString("address"),
                        resultSet.getString("food_type"),
                        resultSet.getString("dish_name"),
                        resultSet.getString("dish_text")
                ));
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            return list;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public static ArrayList<Restaurant> printByName(String name) {
        String query = "SELECT * FROM istaiga WHERE name LIKE '%" + name + "%';";
        ArrayList<Restaurant> list = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Restaurant(
                        resultSet.getString("name"),
                        resultSet.getString("code"),
                        resultSet.getString("address"),
                        resultSet.getString("food_type"),
                        resultSet.getString("dish_name"),
                        resultSet.getString("dish_text")
                ));
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
