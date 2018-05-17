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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(TSform.teachernameList.size()>0)teacherlist.setValue(TSform.teachernameList.get(0));
        
        teacherlist.setItems(TSform.teachernameList);
        
        String S1=teacherlist.getValue();  // Thus we get value
        
         if(TSform.coursenameList.size()>0) courselist.setValue(TSform.coursenameList.get(0));
       // courselist.setValue("Bangla");
        courselist.setItems(TSform.coursenameList);
        
        
        
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
    private void createCoursebuttonhandler(ActionEvent event) throws IOException {
        TSform.root = FXMLLoader.load(getClass().getResource("addWeight.fxml")); 
        Scene scene = new Scene(TSform.root);          
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Welcome");
        
    } 

    @FXML
    private void changeWeightButton(ActionEvent event) throws IOException {
        TSform.root = FXMLLoader.load(getClass().getResource("ChangeWeight.fxml")); 
        Scene scene = new Scene(TSform.root);          
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Welcome");
        
    } 

    
}
