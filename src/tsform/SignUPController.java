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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    private void backbuttonHandler(ActionEvent event) throws IOException {
      
        TSform.root = FXMLLoader.load(getClass().getResource("LOGIN.fxml")); 
        Scene scene = new Scene(TSform.root);        
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Login");
         
    }  
        
        
    

    @FXML
    private void SignUpbuttonHandler(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        
         int flag=1;
        String name= nameField.getText();
        String pass=passwordfield.getText() ;
        String cpass=confpasswordfield.getText();
        String contact = numberfield.getText();
        String email= emailfield.getText();
        String tp = null;
       
        
       if(!pass.equals(cpass))
       {
           labelmsg.setText("Password mismatch!!!");
           flag=0;
       }
       
 
       
       
       if(flag==1)
       {
      Connection c = null;
      Statement stmt = null;
     
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
      stmt = c.createStatement();  
      ResultSet rs = stmt.executeQuery( "SELECT * FROM Login;" );
      while(rs.next())
      {
          String  nm = rs.getString("Name");
          if(nm.equals(name))
          {
              flag=0;
              break;
          }
      }
      rs.close();
      if(flag==1)
      {
                              String sql = "INSERT INTO Login " +
             // String sql = "DELETE FROM Login;";
                        "VALUES ('"+name+"','"+pass+"','"+tp+"','"+contact+"','"+email+"');"; 
     // String sql = "INSERT INTO Login (Name,Password,Type,Contact,Email) " + "VALUES (name,pass,tp,contact,email);"; 
         stmt.executeUpdate(sql);
         stmt.close();
        
        
        TSform.root = FXMLLoader.load(getClass().getResource("LOGIN.fxml")); 
        Scene scene = new Scene(TSform.root);        
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Login");
          
      } 
        c.close();   
       }
    }
    
}
