/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 *
 * @author Ala
 */
public class Fmain extends Application {
    
    private Stage stage;
    private Parent parent;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage= new Stage();
        parent=FXMLLoader.load(getClass().getResource("Aliments.fxml"));
        Scene scene=new Scene(parent);
        stage.setScene(scene);
        stage.show();   
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
