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
public class TeacherHomepageController implements Initializable {
    @FXML
    private ChoiceBox<String> classchoicebox;
    @FXML
    private Button confirmbutton;
    @FXML
    private Button backbutton;
    
        //ObservableList<String>classList=FXCollections.observableArrayList("3","7","9","10");
            ObservableList<String>classList=FXCollections.observableArrayList();
            ObservableList<String>subjectList=FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> subjectchoicebox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            // classchoicebox.setValue("3");
            Connection c = null;
            Statement stmt = null;
            ResultSet rs = null;
        
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
            stmt = c.createStatement();
            
            
            rs = stmt.executeQuery( "SELECT DISTINCT Class FROM AssignCourse WHERE TeacherName='"+TSform.userName+"';" );

            while(rs.next())
            {
                String  nm = rs.getString("Class");
                classList.add(nm);
                
            }
            if(classList.size()>0) classchoicebox.setValue(classList.get(0));
            classchoicebox.setItems(classList);
            
            rs.close();
        ResultSet rs1 = stmt.executeQuery( "SELECT DISTINCT CourseName FROM AssignCourse WHERE TeacherName='"+TSform.userName+"';" );

            while(rs1.next())
            {
                String  nm = rs1.getString("CourseName");
                subjectList.add(nm);
               // System.out.println("YEs-------------------------------->>>>");
               // System.out.println(""+nm);
                
            }
            if(subjectList.size()>0) subjectchoicebox.setValue(subjectList.get(0));
            subjectchoicebox.setItems(subjectList); 
            rs1.close();
            stmt.close();
            c.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TeacherHomepageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TeacherHomepageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
    }    

    @FXML
    private void confirmbuttonhandler(ActionEvent event) throws IOException {
        TSform.subject=subjectchoicebox.getValue();
        TSform.clss=classchoicebox.getValue();
        
        TSform.root = FXMLLoader.load(getClass().getResource("class3table.fxml")); 
        Scene scene = new Scene(TSform.root);          
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Welcome");
        
    } 

    @FXML
    private void backbuttonhandler(ActionEvent event) throws IOException {
        TSform.root = FXMLLoader.load(getClass().getResource("LOGIN.fxml")); 
        Scene scene = new Scene(TSform.root);          
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Welcome");
        
    } 

    @FXML
    private void changePassword(ActionEvent event) throws IOException 
    {
             TSform.root = FXMLLoader.load(getClass().getResource("changePassword.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            Welcome");
     } 
    
}
