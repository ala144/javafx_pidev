/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;



import entities.Aliments;
import interfaces.InterfaceAliments;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author Ala
 */
public class AlimentsFCRUD implements InterfaceAliments {
    Connection con;
    public AlimentsFCRUD(){
        con=DataBase.getInstance().getConnection();
    }

    
    @Override
    public void ajouteraliments(Aliments a) {
        try{
            Statement st = con.createStatement();
            String req =" insert into aliments (id, nom ,  glucides, proteins, calories, imagepath)"+ "values ('" +a.getId()+ "' , '"+a.getNom()+" ' ,'"+a.getGlucides()+" ' ,'"+a.getProteins()+" ' , '"+a.getCalories() + " ' , '"+a.getImagepath()+"')"; 
            st.executeUpdate(req);
            System.out.println("aliment ajouté");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
           
    
    }
    @Override
    public void modifieraliments (Aliments a){
        String req= "UPDATE aliments SET Nom=?, Glucides=?, Proteins=?, Calories=?, ImagePath=? where id=? ";
        try {
            PreparedStatement pst = con.prepareStatement(req);
            pst.setInt(1,a.getId()); 
            pst.setString(2,a.getNom());
            pst.setFloat(3,a.getGlucides());
            pst.setFloat(4,a.getProteins());
            pst.setFloat(5,a.getCalories());
            pst.setString(6,a.getImagepath());
            pst.executeUpdate();
            System.out.println("aliment modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }  
    @Override
    public void supprimeraliments(int id)throws SQLException {
//        String req = "DELETE FROM Aliments WHERE id="+id;
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM Aliments WHERE id="+id);
            pst.executeUpdate();
            System.out.println("Aliment supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
  
        
    
    
    
    
    
    }

    @Override
    public ObservableList<Aliments> afficheraliments() throws SQLException{
        ObservableList<Aliments> ls = FXCollections.observableArrayList();
            Statement st = con.createStatement();
            
            String req = "select * from aliments";
            ResultSet rs = st.executeQuery(req);
            
            while(rs.next()){
                int id =rs.getInt("id");
                String nom = rs.getString("nom");
                Float glucides = rs.getFloat("glucides");
                Float proteins = rs.getFloat("proteins");
                Float calories = rs.getFloat("calories");
                String imagepath = rs.getString("imagepath");
                
                
                
                Aliments a = new Aliments(id,nom ,  glucides,proteins ,calories, imagepath);
                ls.add(a);
                
            }
            
          
        
        return ls;
    }

    

    
    
    
        
        
        
}

    
    
    
    
        

  
    

   
  
    
        
    
    
        
        
        
