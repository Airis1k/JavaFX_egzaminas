package com.example.javafx_dakar.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/restaurant";

    public static void order(Order order) {
        String query = "INSERT INTO restaurant.order\n" +
                "(name, dish_name, quantity)\n" +
                "VALUES (?, ?, ?);";

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, order.getName());
            preparedStatement.setString(2, order.getDishName());
            preparedStatement.setInt(3, order.getQuantity());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
            System.out.println("Order has been submitted successfully!");
            System.out.println("You have ordered" +
                    " name: " + order.getName() +
                    ", dish name: " + order.getDishName() +
                    ", quantity: " + order.getQuantity());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
