/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ala
 */
public class AlimentDAO {
     public static List<Aliments> getAll() {
        List<Aliments> aliments = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diabety", "root", "")) {
            String sql = "SELECT * FROM Aliments";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nom = resultSet.getString("nom");
                        Float calories = resultSet.getFloat("calories");
                        Float proteins = resultSet.getFloat("proteines");
                        Float glucides = resultSet.getFloat("glucides");
                        String imagepath = resultSet.getString("imagepath");

                        aliments.add(new Aliments(id, nom, glucides, proteins,  calories,imagepath));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aliments;
    }
    
}
