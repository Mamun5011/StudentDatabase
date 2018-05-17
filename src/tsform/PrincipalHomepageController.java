/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsform;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import static tsform.TSform.window;



/**
 * FXML Controller class
 *
 * @author Mamun
 */
public class PrincipalHomepageController implements Initializable {
    @FXML
    private Label msgfield;
    private TextField classtextfield;
    @FXML
    private ChoiceBox<String> classchoicebox;
    
    ObservableList<String>classList=
            FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
    @FXML
    private Label namemsgbox;
    @FXML
    private Label coursemsgbox;
    @FXML
    private TextField teachernamefield;
    @FXML
    private TextField coursenamefield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                classchoicebox.setValue("1");
        classchoicebox.setItems(classList);
        String S1=classchoicebox.getValue();
    }    

    @FXML
    private void showlistbuttonhandler(ActionEvent event) throws IOException {
        
        
//        if(classtextfield.getText().equals(""))msgfield.setText("Please enter which class you want to see from 1 to 10");
//        else if(Integer.parseInt(classtextfield.getText())<1 ||Integer.parseInt(classtextfield.getText())>10 )
//                     msgfield.setText("Please enter a valid class from 1 to 10");
//        else
//        {
 
           TSform.root = FXMLLoader.load(getClass().getResource("class3table.fxml")); 
        
           Scene scene = new Scene(TSform.root);
           
        TSform.window.setScene(scene);
         TSform.window.setTitle("                                                                            welcome");
        //  }  
    }

    @FXML
    private void assigncourseteacher(ActionEvent event) throws IOException {
        TSform.root = FXMLLoader.load(getClass().getResource("addteacher.fxml"));      
        Scene scene = new Scene(TSform.root);  
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            welcome");
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

    @FXML
    private void Admission(ActionEvent event) throws IOException {
        
              
        TSform.root = FXMLLoader.load(getClass().getResource("admissionStudent.fxml")); 
        Scene scene = new Scene(TSform.root);
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            welcome");
         
        
    }

    @FXML
    private void addTeacher(ActionEvent event) {
        
        if(teachernamefield.getText().equals(""))namemsgbox.setText("Name Here!!!");
        
        
    }

    @FXML
    private void addCourse(ActionEvent event) 
    {
        
       if(coursenamefield.getText().equals(""))coursemsgbox.setText("Course Here!!!");
    }

    @FXML
    private void MeritListHandler(ActionEvent event) {
    }

    @FXML
    private void clearDataHandler(ActionEvent event) throws IOException 
    {
        
        
              TSform.root = FXMLLoader.load(getClass().getResource("confirmPassword.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            Welcome");
          } 
    
}
