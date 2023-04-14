/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package diabety2;

import entities.Aliments;
import java.sql.SQLException;
import services.AlimentsFCRUD;

/**
 *
 * @author Ala
 */
public class Diabety2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Aliments a = new Aliments(111,"aa",3,3,3,"aa");
        AlimentsFCRUD as = new AlimentsFCRUD();
        as.ajouteraliments(a);
        as.supprimeraliments(90);
    }
    
}
