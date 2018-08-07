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
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
   int i;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     TSform.count=5;
     i=1;
   
     
        addbutton.setOnAction(btnNewHandler);
     
     roll.setCellValueFactory(new PropertyValueFactory<admissionRecord, Integer>("studentroll"));     
     name.setCellValueFactory(new PropertyValueFactory<admissionRecord, String>("studentName"));
     marks.setCellValueFactory(new PropertyValueFactory<admissionRecord, Double>("studentmarks"));
     
     
        try { 
            Table.setItems(getData());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdmissionStudentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdmissionStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            
                            
            try {
                Connection c = null;
                Statement stmt = null;            
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
                stmt = c.createStatement();
                
                int newId =TSform.count++;
                double a=0.00;
                admissionRecord newRec = new admissionRecord(i++,"Your name",a);
                data.add(newRec);
                int K=i-1;
                
                String sql = "INSERT INTO Admission " +
                        "VALUES ("+K+",'Your Name','not updated','not updated','0.00');";
                // String sql = "INSERT INTO Login (Name,Password,Type,Contact,Email) " + "VALUES (name,pass,tp,contact,email);";
                stmt.executeUpdate(sql);
                stmt.close();
                c.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdmissionStudentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdmissionStudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
    };  
      
      
      public ObservableList<admissionRecord> getData() throws ClassNotFoundException, SQLException
{

 // ObservableList<Record> studentInfo=FXCollections.observableArrayList();
    
          Connection c = null;
      Statement stmt = null;
      ResultSet rs = null;
     Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
      stmt = c.createStatement();
     rs = stmt.executeQuery( "SELECT * FROM Admission;" );
          while(rs.next())
      {
              i++;
              int id=Integer.parseInt(rs.getString("Id"));
              String name=rs.getString("Name");
              String mark=rs.getString("Mark");
              Double d=Double.parseDouble(mark);
    
              
              
              admissionRecord S=new admissionRecord(id,name,d);
              data.add(S);
          
      
      }
      
      rs.close();
      stmt.close();
      c.close();
      
      if(data.size()>0)Collections.sort(data, new sortListdone());
      
       // data.add(new admissionRecord(1,"Sahed",3.00));
        //data.add(new admissionRecord(2,"Shakil",3.00));
      //  data.add(new admissionRecord(3,"Shakib",3.00));
        // data.add(new admissionRecord(4,"Noman",3.00));
         return data;
  
}   
      
    
    
    
    



    @FXML
    private void deleteRowFromTable(ActionEvent event) throws ClassNotFoundException, SQLException
    {
        
                      Connection c = null;
      Statement stmt = null;
      ResultSet rs = null;
     Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
     stmt = c.createStatement();
    
    admissionRecord ss=Table.getSelectionModel().getSelectedItem();
    
                  String sql = "DELETE FROM Admission WHERE Id= '"+ss.getStudentroll()+"';";
                 stmt.executeUpdate(sql);
                 c.close();
                 stmt.close();   
        
        
         Table.getItems().removeAll(Table.getSelectionModel().getSelectedItem());
        
    }



    @FXML
    public void changeRollcellEvent(CellEditEvent editedCell) throws ClassNotFoundException, SQLException
{
    int oldValue=(int) editedCell.getOldValue();
    int newValue=(int) editedCell.getNewValue();
    
                Connection c = null;
      Statement stmt = null;
      ResultSet rs = null;
     Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
     stmt = c.createStatement();
    
    admissionRecord ss=Table.getSelectionModel().getSelectedItem();
    String val=""+editedCell.getNewValue();
                  String sql = "UPDATE Admission " +
                        "SET Id= '"+val+"' WHERE Id= '"+ss.getStudentroll()+"' ;";
                 stmt.executeUpdate(sql);
                 c.close();
                 stmt.close(); 
    
    
    
    admissionRecord recordSelected=Table.getSelectionModel().getSelectedItem();
    recordSelected.setStudentroll((int) editedCell.getNewValue());
    }

    @FXML
        public void changeNamecellEvent(CellEditEvent editedCell) throws ClassNotFoundException, SQLException
{
    
      Connection c = null;
      Statement stmt = null;
      ResultSet rs = null;
     Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
     stmt = c.createStatement();
    
    admissionRecord ss=Table.getSelectionModel().getSelectedItem();
    String val=(String)editedCell.getNewValue();
                  String sql = "UPDATE Admission " +
                        "SET Name= '"+val+"' WHERE  Id= '"+ss.getStudentroll()+"' ;";
                 stmt.executeUpdate(sql);
                 c.close();
                 stmt.close();
        admissionRecord recordSelected=Table.getSelectionModel().getSelectedItem();
        recordSelected.setStudentName((String) editedCell.getNewValue());
}

    @FXML
    private void changeMarkscellEvent(CellEditEvent editedCell) throws ClassNotFoundException, SQLException
    {   
            Connection c = null;
      Statement stmt = null;
      ResultSet rs = null;
     Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
     stmt = c.createStatement();
    
    admissionRecord ss=Table.getSelectionModel().getSelectedItem();
                    String val=""+editedCell.getNewValue();
                  String sql = "UPDATE Admission " +
                        "SET Mark= '"+val +"' WHERE Id= '"+ss.getStudentroll()+"' ;";
                 stmt.executeUpdate(sql);
                 c.close();
                 stmt.close();  
        
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
    
      class sortListdone implements Comparator<admissionRecord>
{

          public int compare(admissionRecord x, admissionRecord y)
          {
              if(x.getStudentmarks()>y.getStudentmarks())return -1;
              if(x.getStudentmarks()<y.getStudentmarks())return 1;
              return 0;
          }
} 
    
}
