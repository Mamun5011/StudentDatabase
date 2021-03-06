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
public class NewWeightController implements Initializable {
    @FXML
    private TextField CT1;
    @FXML
    private TextField CT2;
    @FXML
    private TextField CT3;
    @FXML
    private TextField TERM1;
    @FXML
    private TextField TERM2;
    @FXML
    private TextField TERM3;
    @FXML
    private TextField LAB;
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
    private void backbuttonhandler(ActionEvent event) throws IOException {
        
                TSform.root = FXMLLoader.load(getClass().getResource("Addteacher.fxml")); 
        Scene scene = new Scene(TSform.root);          
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Welcome");
        
    
    }

    @FXML
    private void confirmHandler(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
     
             int flag=1,val;
            val=Integer.parseInt(CT1.getText()) + Integer.parseInt(CT2.getText())+Integer.parseInt(CT3.getText())+Integer.parseInt(TERM1.getText())+Integer.parseInt(TERM2.getText())+Integer.parseInt(TERM3.getText())+Integer.parseInt(LAB.getText()); 
             
             
        if(CT1.getText().equals("")|| CT2.getText().equals("") || CT3.getText().equals("") || 
                TERM1.getText().equals("") || TERM2.getText().equals("") || TERM3.getText().equals("") || LAB.getText().equals(""))
        {
           flag=0; 
           msgbox.setText("fill Up All weight");
        }
        else if(val>100 ||val<100)
        {
            flag=0;
            msgbox.setText("Total weight will be 100");
        }
        else
        {   
      Connection c = null;
      Statement stmt = null;
      ResultSet rs;
     Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
      stmt = c.createStatement();
          
              String sql = "UPDATE AssignCourse " +
                        "SET CT1weight='"+CT1.getText()+"', CT2weight='"+CT2.getText()+"',CT3weight='"+CT3.getText()+"',TERM1weight='"+TERM1.getText()+"',TERM2weight='"+TERM2.getText()+"',TERM3weight='"+TERM3.getText()+"',LABweight='"+LAB.getText()+"' WHERE TeacherName='"+TSform.teacherName+"' AND CourseName= '"+ TSform.courseName+"' AND Class='"+TSform.clss+"';"; 
              stmt.executeUpdate(sql);  
        
    }
        
   if(flag==1)
   {
      TSform.root = FXMLLoader.load(getClass().getResource("Courseaddsuccessfully.fxml")); 
        Scene scene = new Scene(TSform.root);          
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Welcome");
        
    }

    
}
    
    
}