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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Mamun
 */
public class CourseaddsuccessfullyController implements Initializable {
    @FXML
    private Label msgfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        msgfield.setText(TSform.userName+" you have Successfully changed the weight for class "+TSform.clss);
    }    

    @FXML
    private void okbuttonhandler(ActionEvent event) throws IOException {
        
                   TSform.root = FXMLLoader.load(getClass().getResource("PrincipalHomepage.fxml")); 
        
           Scene scene = new Scene(TSform.root);
           
        TSform.window.setScene(scene);
         TSform.window.setTitle("                                                                            Continious Evaluation");
          }  
    
    
}
