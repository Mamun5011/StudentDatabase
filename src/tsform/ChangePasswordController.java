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
public class ChangePasswordController implements Initializable {
    @FXML
    private TextField currPassword;
    @FXML
    private TextField newPassword;
    @FXML
    private TextField confirmPassword;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BackButton(ActionEvent event) throws IOException {
        
          if(TSform.loginType.equals("teacher"))
      {
             TSform.root = FXMLLoader.load(getClass().getResource("teacherHomepage.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            Welcome");
     } 
    
   else
    {
             TSform.root = FXMLLoader.load(getClass().getResource("PrincipalHomepage.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            Welcome");
     }   
 
        
    }

    @FXML
    private void confirmButton(ActionEvent event) throws IOException {
        
    if(TSform.loginType.equals("teacher"))
      {
             TSform.root = FXMLLoader.load(getClass().getResource("teacherHomepage.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            Welcome");
     } 
    
   else
    {
             TSform.root = FXMLLoader.load(getClass().getResource("PrincipalHomepage.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            Welcome");
     } 
    }
    
}
