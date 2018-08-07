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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AddteacherController implements Initializable {
    @FXML
    private ChoiceBox<String> teacherlist;
    @FXML
    private ChoiceBox<String> courselist;
    @FXML
    private Button backbutton;
    
         /*  ObservableList<String>teachernameList=
            FXCollections.observableArrayList("Mr. Rahim","Mr. Karim","Mrs. rahima");
       
      ObservableList<String>coursenameList=
            FXCollections.observableArrayList("Bangla","English","Physics","Chemistry","Math");*/
    @FXML
    private Button createCoursebutton;
    
    ObservableList<String>teacherName=FXCollections.observableArrayList(); 
    ObservableList<String>courseName=FXCollections.observableArrayList(); 
    @FXML
    private ChoiceBox<String> classlist;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            
            Connection c = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                Class.forName("org.sqlite.JDBC");
                
                try {
                    c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
                } catch (SQLException ex) {
                    Logger.getLogger(AddteacherController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stmt = c.createStatement();
                rs = stmt.executeQuery( "SELECT * FROM Teacher;" );
                while(rs.next())
                {
                    String  nm = rs.getString("Name");
                    teacherName.add(nm);
                    
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddteacherController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AddteacherController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(teacherName.size()>0)teacherlist.setValue(teacherName.get(0));
            
            teacherlist.setItems(teacherName);
            classlist.setValue(TSform.classname.get(0));
            classlist.setItems(TSform.classname);
            
            
            
            try {
                rs = stmt.executeQuery( "SELECT * FROM Course;" );
            } catch (SQLException ex) {
                Logger.getLogger(AddteacherController.class.getName()).log(Level.SEVERE, null, ex);
            }
            while(rs.next())
            {
                String  nm = rs.getString("CourseName");
                courseName.add(nm);
                
            }
            
            if(courseName.size()>0) courselist.setValue(courseName.get(0));
            // courselist.setValue("Bangla");
            courselist.setItems(courseName);
            
            c.close();
            rs.close();
            stmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AddteacherController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }    

    @FXML
    private void backbuttonhandler(ActionEvent event) throws IOException 
    {
        
       TSform.root = FXMLLoader.load(getClass().getResource("PrincipalHomepage.fxml"));         
       Scene scene = new Scene(TSform.root);         
       TSform.window.setScene(scene);
       TSform.window.setTitle("                                                                            Welcome");
       
      }  


        


    @FXML
    private void createCoursebuttonhandler(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
        TSform.teacherName=teacherlist.getValue();  // Thus we get value
        TSform.courseName=courselist.getValue();
        TSform.clss=classlist.getValue();
        
        TSform.root = FXMLLoader.load(getClass().getResource("weightAdd.fxml")); 
        Scene scene = new Scene(TSform.root);          
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Welcome");
       

        

        
    } 

    @FXML
    private void changeWeightButton(ActionEvent event) throws IOException {
        
        TSform.teacherName=teacherlist.getValue();  // Thus we get value
        TSform.courseName=courselist.getValue();
        TSform.clss=classlist.getValue(); 
        
        TSform.root = FXMLLoader.load(getClass().getResource("newWeight.fxml")); 
        Scene scene = new Scene(TSform.root);          
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Welcome");
        


    } 

    
}
