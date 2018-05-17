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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Mamun
 */
public class AdmissionStudentDetailsController implements Initializable {
    @FXML
    private Label marksfield;
    @FXML
    private Label namefield;
    @FXML
    private Label rollfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             admissionRecord Result=TSform.admissionStudentdetails;
        this.rollfield.setText(""+Result.getStudentroll());
        this.namefield.setText(""+Result.getStudentName());
        this.marksfield.setText(""+Result.getStudentmarks());
    }    

    @FXML
    private void backbuttonhandler(ActionEvent event) throws IOException
    {
        TSform.root = FXMLLoader.load(getClass().getResource("admissionStudent.fxml")); 
        Scene scene = new Scene(TSform.root);
        TSform.window.setScene(scene);
         TSform.window.setTitle("                                                                            Continious Evaluation");
          }  
    
}
