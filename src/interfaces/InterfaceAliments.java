/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entities.Aliments;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Ala
 */
public interface InterfaceAliments {
   public void ajouteraliments (Aliments a);
   public void modifieraliments(Aliments a);
   public void supprimeraliments(int id)throws SQLException;
   public List<Aliments> afficheraliments() throws SQLException; 
}
