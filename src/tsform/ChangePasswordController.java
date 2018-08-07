/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsform;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    @FXML
    private Label labelmsg;
    @FXML
    private Label msgbox;

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
    private void confirmButton(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        
        int flag=1;
        String newPass=newPassword.getText();
        String cnewpass=confirmPassword.getText();
        String pass=currPassword.getText();
        if(!newPass.equals(cnewpass) || (newPass.equals("") && cnewpass.equals("")))
        {
             flag=0;
            labelmsg.setText("Pasword not match or empty");
        }
        
           Connection c = null;
      Statement stmt = null;
      ResultSet rs;
     Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
      stmt = c.createStatement();
               
 
        
        
    if( flag==1 && TSform.loginType.equals("teacher"))
      {
          
              String sql = "UPDATE Teacher " +
                        "SET Password= '"+newPass+"' WHERE Name='"+TSform.userName+"';"; 
              stmt.executeUpdate(sql); 
              
             TSform.root = FXMLLoader.load(getClass().getResource("teacherHomepage.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            Welcome");
    
      
      } 
    
    else if(flag==1)
    {
                  
              String sql = "UPDATE Login " +
                        "SET Password= '"+newPass+"' WHERE Name='"+TSform.userName+"' AND Type='Principal';";
              System.out.println("upadating for "+TSform.userName+" new pass:"+newPass+" old pass:"+pass);
              stmt.executeUpdate(sql);
        
             TSform.root = FXMLLoader.load(getClass().getResource("PrincipalHomepage.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            Welcome");
    
    
    } 
    c.close();
    stmt.close();
    }
    
}
