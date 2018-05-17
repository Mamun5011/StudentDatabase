/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsform;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mamun
 */
public class AddWeightController implements Initializable {
    @FXML
    private TextField ct1;
    @FXML
    private TextField ct2;
    @FXML
    private TextField ct3;
    @FXML
    private TextField term1;
    @FXML
    private TextField term2;
    @FXML
    private TextField term3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmButton(ActionEvent event) throws IOException {
        TSform.root = FXMLLoader.load(getClass().getResource("Courseaddsuccessfully.fxml")); 
        Scene scene = new Scene(TSform.root);          
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Welcome");
        
    } 

    @FXML
    private void BackButton(ActionEvent event) throws IOException {
        TSform.root = FXMLLoader.load(getClass().getResource("Addteacher.fxml")); 
        Scene scene = new Scene(TSform.root);          
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Welcome");
        
    } 
    
}
