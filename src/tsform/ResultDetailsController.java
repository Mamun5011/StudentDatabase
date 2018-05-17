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
import static tsform.TSform.studentdetails;
import static tsform.TSform.window;

/**
 * FXML Controller class
 *
 * @author Mamun
 */
public class ResultDetailsController implements Initializable {
    @FXML
    private Label rollfield;
    @FXML
    private Label namefield;
    @FXML
    private Label ct1field;
    @FXML
    private Label ct2field;
    @FXML
    private Label ct3field;
    @FXML
    private Label term1field;
    @FXML
    private Label term2field;
    @FXML
    private Label term3field;
    @FXML
    private Label teacherfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Record Result=TSform.studentdetails;
        this.rollfield.setText(""+TSform.studentdetails.getStudentroll());
        this.namefield.setText(""+TSform.studentdetails.getStudentName());
        this.ct1field.setText(""+TSform.studentdetails.getStudentCt1());
        this.ct2field.setText(""+TSform.studentdetails.getStudentCt2());
        this.ct3field.setText(""+TSform.studentdetails.getStudentCt3());
        this.term1field.setText(""+TSform.studentdetails.getStudentTerm1());
        this.term2field.setText(""+TSform.studentdetails.getStudentTerm2());
        this.term3field.setText(""+TSform.studentdetails.getStudentTerm3());
    }    

    @FXML
    private void backbuttonhandler(ActionEvent event) throws IOException {

           TSform.root = FXMLLoader.load(getClass().getResource("class3table.fxml")); 
        
           Scene scene = new Scene(TSform.root);
           
        TSform.window.setScene(scene);
         TSform.window.setTitle("                                                                            Continious Evaluation");
          }  
    
}
