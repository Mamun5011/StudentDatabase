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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import static javafx.scene.input.KeyCode.S;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author Mamun
 */
public class AdmissionStudentController implements Initializable {
    @FXML
    private Button deletebutton;
    @FXML
    private Button addbutton;
    @FXML
    private Label msgbox;
    @FXML
    private TableView<admissionRecord> Table;
    @FXML
    private TableColumn<admissionRecord,Integer> roll;
    @FXML
    private TableColumn<admissionRecord,String> name;
    @FXML
    private TableColumn<admissionRecord,Double> marks;
    
   private final ObservableList<admissionRecord> data = FXCollections.observableArrayList();

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     TSform.count=5;
   
     
        addbutton.setOnAction(btnNewHandler);
     
     roll.setCellValueFactory(new PropertyValueFactory<admissionRecord, Integer>("studentroll"));     
     name.setCellValueFactory(new PropertyValueFactory<admissionRecord, String>("studentName"));
     marks.setCellValueFactory(new PropertyValueFactory<admissionRecord, Double>("studentmarks"));
     
     
      Table.setItems(getData()); 
      Table.setEditable(true);
      
 roll.setCellFactory(TextFieldTableCell.<admissionRecord, Integer>forTableColumn(new IntegerStringConverter()));
 name.setCellFactory(TextFieldTableCell.<admissionRecord>forTableColumn());
 marks.setCellFactory(TextFieldTableCell.<admissionRecord, Double>forTableColumn(new DoubleStringConverter()));
     
    }   
    
    
      EventHandler<ActionEvent> btnNewHandler = 
            new EventHandler<ActionEvent>()
     {
 
        @Override
        public void handle(ActionEvent t) 
        {
             
            int newId =TSform.count++;
            double a=0.00;
            admissionRecord newRec = new admissionRecord(newId,"Your name",a);
            data.add(newRec);
             
        }
    };  
      
      
      public ObservableList<admissionRecord> getData()
{

 // ObservableList<Record> studentInfo=FXCollections.observableArrayList();
        data.add(new admissionRecord(1,"Sahed",3.00));
        data.add(new admissionRecord(2,"Shakil",3.00));
        data.add(new admissionRecord(3,"Shakib",3.00));
         data.add(new admissionRecord(4,"Noman",3.00));
         return data;
  
}   
      
    
    
    
    



    @FXML
    private void deleteRowFromTable(ActionEvent event) {
        
         Table.getItems().removeAll(Table.getSelectionModel().getSelectedItem());
        
    }



    @FXML
    public void changeRollcellEvent(CellEditEvent editedCell)
{
    int oldValue=(int) editedCell.getOldValue();
    int newValue=(int) editedCell.getNewValue();
    
    admissionRecord recordSelected=Table.getSelectionModel().getSelectedItem();
    recordSelected.setStudentroll((int) editedCell.getNewValue());
    }

    @FXML
        public void changeNamecellEvent(CellEditEvent editedCell)
{
        admissionRecord recordSelected=Table.getSelectionModel().getSelectedItem();
        recordSelected.setStudentName((String) editedCell.getNewValue());
}

    @FXML
    private void changeMarkscellEvent(CellEditEvent editedCell)
    {       
    admissionRecord recordSelected=Table.getSelectionModel().getSelectedItem();
    recordSelected.setStudentmarks((Double) editedCell.getNewValue());
    
    }
    
    
     @FXML
    private void showdetailshandle(ActionEvent event) throws IOException
    {
        
         TSform.admissionStudentdetails=Table.getSelectionModel().getSelectedItem();
        if(TSform.admissionStudentdetails==null)System.out.println("Please select any row which you want to see in details ");
        else
        {
        TSform.root = FXMLLoader.load(getClass().getResource("admissionStudentDetails.fxml")); 
        Scene scene = new Scene(TSform.root);
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Student Details");
        }  
      
        
        
    }

    @FXML
    private void backbuttonhandle(ActionEvent event) throws IOException {
        
        TSform.root = FXMLLoader.load(getClass().getResource("principalHomepage.fxml")); 
        Scene scene = new Scene(TSform.root);
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            welcome");
        
    }   
    
}
