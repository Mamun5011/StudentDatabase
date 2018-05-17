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
import static tsform.TSform.window;


/**
 * FXML Controller class
 *
 * @author Mamun
 */
public class SignUPController implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private TextField passwordfield;
    @FXML
    private TextField confpasswordfield;
    @FXML
    private TextField numberfield;
    @FXML
    private TextField emailfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backbuttonHandler(ActionEvent event) throws IOException {
      
            TSform.root = FXMLLoader.load(getClass().getResource("LOGIN.fxml")); 
        
           Scene scene = new Scene(TSform.root);
           
        TSform.window.setScene(scene);
         TSform.window.setTitle("                                                                            Login");
          }  
        
        
    

    @FXML
    private void SignUpbuttonHandler(ActionEvent event) {
    }
    
}
