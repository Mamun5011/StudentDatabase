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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import static tsform.TSform.window;

/**
 * FXML Controller class
 *
 * @author Mamun
 */
public class LOGINController implements Initializable {
    @FXML
    private Button loginAction;
    @FXML
    private Button signupaction;
    @FXML
    private Text welcomeText;
    @FXML
    private TextField usernamefield;
    @FXML
    private TextField paswwordfield;
    @FXML
    private RadioButton principalbutton;
    @FXML
    private RadioButton teacherbutton;
    @FXML
    private ToggleGroup principle;
    @FXML
    private Label labelmsg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoginHandler(ActionEvent event) throws IOException {
        
       // labelmsg.setText("login!! ");
        if(teacherbutton.isSelected())
        {
             TSform.loginType="teacher";
             TSform.root = FXMLLoader.load(getClass().getResource("teacherHomepage.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            welcome");
          } 
        else if(principalbutton.isSelected())
        {
            TSform.loginType="principal";
             TSform.root = FXMLLoader.load(getClass().getResource("PrincipalHomepage.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            welcome");
          }  
        else
        {
             labelmsg.setText(" please select your login type");
             TSform.loginType="none";
        }
           
            
        
      
    }
          
        
            

    

    @FXML
    private void signupHandler(ActionEvent event) throws IOException {
    
            TSform.root = FXMLLoader.load(getClass().getResource("SignUp.fxml")); 
        
           Scene scene = new Scene(TSform.root);
           
        TSform.window.setScene(scene);
         TSform.window.setTitle("                                                                            Registration");
          }
    
}
