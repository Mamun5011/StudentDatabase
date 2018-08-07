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
public class ClearDatapageController implements Initializable {
    @FXML
    private TextField currpassword;
    @FXML
    private TextField conpassword;
    @FXML
    private Label msgbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmhandler(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        
                int flag=1;
        String cnewpass=conpassword.getText();
        String pass=currpassword.getText();
        if(!pass.equals(cnewpass)|| (pass.equals("") && cnewpass.equals("")))
        {
             flag=0;
            msgbox.setText("Pasword not match");
        }
        
           Connection c = null;
      Statement stmt = null;
      ResultSet rs;
     Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
      stmt = c.createStatement();
      
     if(flag==1)
    {
                  
              String sql = "DELETE FROM Teacher;";
              stmt.executeUpdate(sql);
               sql = "DELETE FROM Student;";
              stmt.executeUpdate(sql);
              sql = "DELETE FROM Mark;";
              stmt.executeUpdate(sql);
              sql = "DELETE FROM Login;";
              stmt.executeUpdate(sql);
               sql = "DELETE FROM Course;";
              stmt.executeUpdate(sql);
              sql = "DELETE FROM Class6;";
              stmt.executeUpdate(sql); 
              sql = "DELETE FROM Class7;";
              stmt.executeUpdate(sql);
              sql = "DELETE FROM Class8;";
              stmt.executeUpdate(sql);
                            sql = "DELETE FROM Class9;";
              stmt.executeUpdate(sql);
                            sql = "DELETE FROM Class10;";
              stmt.executeUpdate(sql);
                            sql = "DELETE FROM AssignCourse;";
              stmt.executeUpdate(sql);
                            sql = "DELETE FROM Admission;";
              stmt.executeUpdate(sql);
              
              
        
             TSform.root = FXMLLoader.load(getClass().getResource("PrincipalHomepage.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            Welcome");
    
    
    } 
    c.close();
    stmt.close();
      
    }

    @FXML
    private void backbuttonhandler(ActionEvent event) throws IOException {
        
          
        TSform.root = FXMLLoader.load(getClass().getResource("principalHomepage.fxml")); 
        Scene scene = new Scene(TSform.root);
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            welcome");
        
    }
    
}
