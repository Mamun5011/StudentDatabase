/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsform;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import static tsform.TSform.window;
import static tsform.TSform.studentdetails;


public class Class3tableController implements Initializable {



    @FXML
    private Label msgbox;
    @FXML
    private Button addbutton;
    @FXML
    private TableColumn<Record,Integer> roll;
    @FXML
    private TableColumn<Record,String> Name;
    @FXML
    private TableColumn<Record,Double> CT1;
    @FXML
    private TableColumn<Record,Double> CT2;
    @FXML
    private TableColumn<Record,Double> CT3;
    @FXML
    private TableColumn<Record,Double>  TERM1;
    @FXML
    private TableColumn<Record,Double> TERM2;
  
    @FXML
    private TableColumn<Record,Double> TERM3;
    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<Record> table ;
    private final ObservableList<Record> data = FXCollections.observableArrayList();
    @FXML
    private Button deletebutton;
    int flag=0;
    String Pressed="";
    
   
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     msgbox.setText("Continuous Evaluation"); 
     TSform.count=5;
   
     
        addbutton.setOnAction(btnNewHandler);
     
     roll.setCellValueFactory(new PropertyValueFactory<Record, Integer>("studentroll")); 
 
     Name.setCellValueFactory(new PropertyValueFactory<Record, String>("studentName"));
     CT1.setCellValueFactory(new PropertyValueFactory<Record, Double>("studentCt1"));
     CT2.setCellValueFactory(new PropertyValueFactory<Record, Double>("studentCt2"));
     CT3.setCellValueFactory(new PropertyValueFactory<Record, Double>("studentCt3"));
     TERM1.setCellValueFactory(new PropertyValueFactory<Record, Double>("studentTerm1"));
     TERM2.setCellValueFactory(new PropertyValueFactory<Record, Double>("studentTerm2"));
     TERM3.setCellValueFactory(new PropertyValueFactory<Record, Double>("studentTerm3"));
     
      
      table.setItems(getData()); 
      table.setEditable(true);
      
 roll.setCellFactory(TextFieldTableCell.<Record, Integer>forTableColumn(new IntegerStringConverter()));
 Name.setCellFactory(TextFieldTableCell.<Record>forTableColumn());
 CT1.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
 CT2.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
 CT3.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
  TERM1.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
 TERM2.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
 TERM3.setCellFactory(TextFieldTableCell.<Record, Double>forTableColumn(new DoubleStringConverter()));
 
 
table.getSelectionModel().setCellSelectionEnabled(true);
 table.setOnKeyPressed(new EventHandler<KeyEvent>() {
    @Override
    public void handle(KeyEvent event) {
        //Put your awesome application specific logic here
        
      if (event.getCode() == KeyCode.RIGHT) {
                table.getSelectionModel().selectRightCell();
                event.consume();
            } else if (event.getCode() == KeyCode.LEFT) {
                table.getSelectionModel().selectLeftCell();
                event.consume();
            } else if (event.getCode() == KeyCode.UP) {
                table.getSelectionModel().selectAboveCell();
                event.consume();
            } else if (event.getCode() == KeyCode.DOWN) {
                table.getSelectionModel().selectBelowCell();
                event.consume();
            }
            else if(event.getCode()==KeyCode.ENTER)
            {
               flag=1;

               
              
               
            }
       
    }
});
 

 final ObservableList<TablePosition> selectedCells = table.getSelectionModel().getSelectedCells();
selectedCells.addListener(new ListChangeListener<TablePosition>() {
    @Override
    public void onChanged(Change change) {
        for (TablePosition pos : selectedCells) {
      
            if(flag==1 && pos.getColumn()==0)
            {
               // System.out.println("Cell selected in row "+pos.getRow()+" and column "+pos.getColumn());
               // System.out.println("0");
                              
               
            }
            
            else if(flag==1 && pos.getColumn()==1)
            {
               System.out.println("1");
            }
            else if(flag==1 && pos.getColumn()==2)
            {
               System.out.println("2");
            }
             else if(flag==1 && pos.getColumn()==3)
            {
               System.out.println("3");
            }
              else if(flag==1 && pos.getColumn()==4)
            {
               System.out.println("4");
            }
             else if(flag==1 && pos.getColumn()==5)
            {
               System.out.println("5");
            }
              else if(flag==1 && pos.getColumn()==6)
            {
               System.out.println("6");
            }   
               else if(flag==1 && pos.getColumn()==6)
            {
               System.out.println("7");
            }           
            
          flag=0;
        }
    }
});



          table.setOnKeyPressed(new EventHandler<KeyEvent>() {
            
              @Override
              public void handle(KeyEvent t) {
                  
                        Pressed+=t.getText();                

                  if (t.getCode() == KeyCode.ENTER) {
                    
                      System.out.println("You pressed "+Pressed);
                      Pressed="";
                      //System.out.print(""+t.getCharacter());
                      
                      
                  }
                      
                  
              }
          });


    
}
    
    
    EventHandler<ActionEvent> btnNewHandler = 
            new EventHandler<ActionEvent>(){
 
        @Override
        public void handle(ActionEvent t) {
             
            //generate new Record with random number
            int newId =TSform.count++;
            double a=0.00;
            Record newRec = new Record(
                    newId,"Your name",a,a,a,a,a,a);
                      data.add(newRec);
             
        }
    };
    
    
    public ObservableList<Record> getData()
{

 // ObservableList<Record> studentInfo=FXCollections.observableArrayList();
        data.add(new Record(1,"Raj",3.00,4.00,5.00,6.00,7.00,1.00));
        data.add(new Record(2,"Rahul",3.00,4.00,5.00,6.00,7.00,1.00));
        data.add(new Record(3,"Kiron",3.00,4.00,5.00,6.00,7.00,1.00));
        data.add(TSform.testRecord);
        return data;
  
}
    
    @FXML
    public void changeRollcellEvent(CellEditEvent editedCell)
{
    int oldValue=(int) editedCell.getOldValue();
    int newValue=(int) editedCell.getNewValue();
    
    Record recordSelected=table.getSelectionModel().getSelectedItem();
    recordSelected.setStudentroll((int) editedCell.getNewValue());
    
//        for(Record tab : data)
//      {
//            if(tab.getStudentroll().equals(oldValue))
//            {
//               tab.setStudentroll((int) editedCell.getNewValue());
//               // System.out.println(""+tab.getStudentName()+""+tab.getStudentCt1());
//               table.getItems().clear();
//               table.setItems(getData());
//               break;
//            }
//       }
    
   
}
    
    
    @FXML
        public void changeNamecellEvent(CellEditEvent editedCell)
{
        Record recordSelected=table.getSelectionModel().getSelectedItem();
    recordSelected.setStudentName((String) editedCell.getNewValue());
}
        
    @FXML
         public void changeCT1cellEvent(CellEditEvent editedCell)
{
        Record recordSelected=table.getSelectionModel().getSelectedItem();
    recordSelected.setStudentCt1((Double) editedCell.getNewValue());
}  
         
    @FXML
         public void changeCT2cellEvent(CellEditEvent editedCell)
{
        Record recordSelected=table.getSelectionModel().getSelectedItem();
    recordSelected.setStudentCt2((Double) editedCell.getNewValue());
}  
         
    @FXML
          public void changeCT3cellEvent(CellEditEvent editedCell)
{
        Record recordSelected=table.getSelectionModel().getSelectedItem();
    recordSelected.setStudentCt3((Double) editedCell.getNewValue());
}  
          
          
    @FXML
          public void changeTERM1cellEvent(CellEditEvent editedCell)
{
        Record recordSelected=table.getSelectionModel().getSelectedItem();
    recordSelected.setStudentTerm1((Double) editedCell.getNewValue());
}  
          
    @FXML
          public void changeTERM2cellEvent(CellEditEvent editedCell)
{
        Record recordSelected=table.getSelectionModel().getSelectedItem();
    recordSelected.setStudentTerm2((Double) editedCell.getNewValue());
}  
          
          
 
    @FXML
                   public void changeTERM3cellEvent(CellEditEvent editedCell)
{
        Record recordSelected=table.getSelectionModel().getSelectedItem();
    recordSelected.setStudentTerm3((Double) editedCell.getNewValue());
}  

    @FXML
    private void deleteRowFromTable(ActionEvent event) {
        
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void backbuttonhandle(ActionEvent event) throws IOException {
      if(TSform.loginType.equals("principal"))
      {
        TSform.root = FXMLLoader.load(getClass().getResource("principalHomepage.fxml")); 
        Scene scene = new Scene(TSform.root);
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            welcome");
        
      } 
      else
      {
     
        TSform.root = FXMLLoader.load(getClass().getResource("TeacherHomepage.fxml")); 
        Scene scene = new Scene(TSform.root);
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            welcome");
        
      } 
      
    }

    @FXML
    private void showdetailshandle(ActionEvent event) throws IOException {
           
        TSform.studentdetails=table.getSelectionModel().getSelectedItem();
        if(TSform.studentdetails==null)System.out.println("Please select any row which you want to see in details ");
        else
        {
        TSform.root = FXMLLoader.load(getClass().getResource("resultDetails.fxml")); 
        Scene scene = new Scene(TSform.root);
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            Student Details");
          }  
}
    }



 