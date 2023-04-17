/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import entities.Aliments;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ala
 */
public class RepasController implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private TableColumn<Aliments, String> alimentsid;
    
    @FXML
    private TableView<Aliments> tableviewid;
  private ObservableList<Aliments> AlimentsList;
    @FXML
    private TableColumn<?, ?> selectid;
    @FXML
    private Button btn_aliments;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* alimentsid.setCellValueFactory(new PropertyValueFactory<>("nom"));

        // Obtenir la liste des aliments depuis la base de données
        List<Aliments> aliments = // récupérer la liste des aliments depuis la base de données
        
        // Créer des CheckBoxes pour chaque aliment
        List<CheckBox> CheckBox = Aliments.stream().map(Aliments -> {
            CheckBox checkBox = new CheckBox(aliments.getNom());
            checkBox.setOnAction(event -> {
                // traiter l'événement lorsque la case à cocher est cochée ou décochée
            });
            return checkBox;
        }).collect(Collectors.toList());

        // Ajouter les CheckBoxes à la colonne des actions
        alimentsid.setCellFactory(column -> new TableCell<Aliments, String>() {
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    int index = getIndex();
                    Aliments aliments = tableviewid.getItems().get(index);

                    // Ajouter la case à cocher correspondante à l'aliment
                    CheckBox checkBox = CheckBox.get(index);
                    setGraphic(checkBox);
                }
            }
        });

        // Ajouter les aliments à la table
        tableviewid.getItems().addAll(aliments);*/
    }

    @FXML
    private void aliments(ActionEvent event) {
    }

   
    }
        
     
    
    

