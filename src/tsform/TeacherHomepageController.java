/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsform;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

/**
 * FXML Controller class
 *
 * @author Mamun
 */
public class TeacherHomepageController implements Initializable {
    @FXML
    private ChoiceBox<String> classchoicebox;
    @FXML
    private Button confirmbutton;
    @FXML
    private Button backbutton;
    
        ObservableList<String>classList=
            FXCollections.observableArrayList("3","7","9","10");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                        classchoicebox.setValue("3");
                        classchoicebox.setItems(classList);
                        String S1=classchoicebox.getValue();
    }    

    @FXML
    private void confirmbuttonhandler(ActionEvent event) throws IOException {
        TSform.root = FXMLLoader.load(getClass().getResource("class3table.fxml")); 
        Scene scene = new Scene(TSform.root);          
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Welcome");
        
    } 

    @FXML
    private void backbuttonhandler(ActionEvent event) throws IOException {
        TSform.root = FXMLLoader.load(getClass().getResource("LOGIN.fxml")); 
        Scene scene = new Scene(TSform.root);          
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Welcome");
        
    } 

    @FXML
    private void changePassword(ActionEvent event) throws IOException 
    {
             TSform.root = FXMLLoader.load(getClass().getResource("changePassword.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            Welcome");
     } 
    
}
