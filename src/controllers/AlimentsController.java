/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;
import GUI.getData;
import java.sql.SQLException;
import services.AlimentsFCRUD;
import entities.Aliments;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import utils.DataBase;

/**
 * FXML Controller class
 *
 * @author Ala
 */
public class AlimentsController implements Initializable {

    @FXML
    private Button ajoutbtn;
    
    @FXML
    private TextField caloriest;

    @FXML
    private TextField glucidest;

    @FXML
    private TextField nomt;

    @FXML
    private TextField proteinst;
    private Connection con;

    
    @FXML
    private Button imagebtn;
    @FXML
    private AnchorPane main_form;
    @FXML
    private TableView<Aliments> aliments_table;
    @FXML
    private TableColumn<Aliments, String> nom_col;
    @FXML
    private TableColumn<Aliments, String> proteines_col;
    @FXML
    private TableColumn<Aliments, String> calories_col;
    @FXML
    private TableColumn<Aliments, String> image_col;
    @FXML
    private TableColumn<Aliments, String> glucides_col;
    @FXML
    private Button modbtn;
    @FXML
    private Button supbtn;
    @FXML
    private TableColumn<Aliments, String> idcol;
    @FXML
    private TextField idt;
    @FXML
    private Text ajoutid;
    @FXML
    private Button viderid;
    @FXML
    private ImageView imageiv;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            AlimentsShowListData();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    

@FXML
    void add(ActionEvent event) throws SQLException {
        AlimentsFCRUD s = new AlimentsFCRUD();
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");
        Aliments a = new Aliments(
        nomt.getText(),
        Float.parseFloat(glucidest.getText()),
        Float.parseFloat(proteinst.getText()),
        Float.parseFloat(caloriest.getText()),
        uri); // set the image path to an empty string for now
        // call the AlimentsService to insert the new object to the database
        try{
             Alert alert;
         if (nomt.getText().isEmpty() || glucidest.getText().isEmpty()|| proteinst.getText().isEmpty()|| caloriest.getText().isEmpty() || getData.path == null || "".equals(getData.path)) {
        // If any of the input fields are empty, show an error message
         alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs");
                alert.showAndWait();
         }if (Float.parseFloat(glucidest.getText())<0||Float.parseFloat(proteinst.getText())<=0 ||Float.parseFloat(caloriest.getText())<=0 ) {
        // If any of the input fields are empty, show an error message
         alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("les aliments ne doivent pas etre null oui negative");
                alert.showAndWait();
         }
         
         else{
        s.ajouteraliments(a);
        System.out.println("Aliment ajouté avec succès !");
//      
        
        
        AlimentsShowListData();
         }
        }catch (Exception e) {
            e.printStackTrace();
        }
//        
//        

    }
    
    @FXML
    private void insererImage(ActionEvent event) {
        FileChooser open = new FileChooser();
        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {
            getData.path = file.getAbsolutePath();

            
            
        }
        
    }
    public ObservableList<Aliments> AlimentsListData() throws SQLException {

        return new AlimentsFCRUD().afficheraliments();
    }
    
    private ObservableList<Aliments> AlimentsList;
    
    public void AlimentsShowListData() throws SQLException {
        AlimentsList = AlimentsListData();
        
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));

        nom_col.setCellValueFactory(new PropertyValueFactory<>("nom"));
        glucides_col.setCellValueFactory(new PropertyValueFactory<>("glucides"));
        proteines_col.setCellValueFactory(new PropertyValueFactory<>("proteins"));
        calories_col.setCellValueFactory(new PropertyValueFactory<>("calories"));
        image_col.setCellValueFactory(new PropertyValueFactory<>("imagepath"));
       
        

        aliments_table.setItems(AlimentsList);
        

    }

@FXML
    private void edit(ActionEvent event) {
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");
        
        String uri2 = getData.path;
        uri2 = uri2.replace("\\", "\\\\");

        

        String req = "UPDATE Aliments SET nom = '"
                +nomt.getText() + "', glucides = '"
                + glucidest.getText() + "', proteins = '"
                + proteinst.getText() + "', calories = '"
                + caloriest.getText() + "', imagepath = '"
                + uri + "' WHERE id ='"
                + idt.getText() + "'";

       
            con = DataBase.getInstance().getConnection();
         try {
            Alert alert;
            if (
                     nomt.getText().isEmpty()
                    || glucidest.getText().isEmpty()
                    || proteinst.getText().isEmpty()
                    ||caloriest.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Message de confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE aliment: " + idt.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    Statement st = con.createStatement();
                    st.executeUpdate(req);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    AlimentsShowListData();
                    
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void delete(ActionEvent event)throws SQLException{
        Aliments m=aliments_table.getSelectionModel().getSelectedItem();
        if (m!=null){
            AlimentsFCRUD a=new AlimentsFCRUD();
            a.supprimeraliments(m.getId());
            AlimentsShowListData();
            
        }else{
            System.out.println("aucun aliment selectionné");
        }
//        reset();
    }
    
    @FXML
    public void AlimentsSelect() {
        Aliments m = aliments_table.getSelectionModel().getSelectedItem();
        int num = aliments_table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        idt.setText(String.valueOf(m.getId()));

        nomt.setText(m.getNom());
        glucidest.setText(String.valueOf(m.getGlucides()));
        
        caloriest.setText(String.valueOf(m.getCalories()));
        proteinst.setText(String.valueOf(m.getProteins()));
        
    
        getData.path = m.getImagepath();

        String uri = "file:" + m.getImagepath();

        Image image = new Image(uri,101,127,false,true);
        
        imageiv.setImage(image);
        
        

        
    }

    @FXML
    private void reset(ActionEvent event) {
        nomt.setText("");
        glucidest.setText("");
        proteinst.setText("");
        caloriest.setText("");
        getData.path="";
    }


    
   
}
