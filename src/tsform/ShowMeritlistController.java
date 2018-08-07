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
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mamun
 */
public class ShowMeritlistController implements Initializable {
    @FXML
    private Label msgbox;
    @FXML
    private TableColumn<meritListRecord,Integer> ROLL;
    @FXML
    private TableColumn<meritListRecord,String> NAME;
    @FXML
    private TableColumn<meritListRecord,Double> CT1;
    @FXML
    private TableColumn<meritListRecord,Double> CT2;
    @FXML
    private TableColumn<meritListRecord,Double> CT3;
    @FXML
    private TableColumn<meritListRecord,Double> TERM1;
    @FXML
    private TableColumn<meritListRecord,Double> TERM2;
    @FXML
    private TableColumn<meritListRecord,Double> TERM3;
    @FXML
    private TableColumn<meritListRecord,Double> LAB;
    @FXML
    private TableColumn<meritListRecord,Double> MARKS;
    @FXML
    private TableView<meritListRecord> table;
    
    String className;
     private final ObservableList<meritListRecord> data = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        msgbox.setText("Merit List For Class "+TSform.clss+" in "+TSform.subject);
        
        
        
             ROLL.setCellValueFactory(new PropertyValueFactory<meritListRecord, Integer>("studentroll")); 
 
     NAME.setCellValueFactory(new PropertyValueFactory<meritListRecord, String>("studentName"));
     CT1.setCellValueFactory(new PropertyValueFactory<meritListRecord, Double>("studentCt1"));
     CT2.setCellValueFactory(new PropertyValueFactory<meritListRecord, Double>("studentCt2"));
     CT3.setCellValueFactory(new PropertyValueFactory<meritListRecord, Double>("studentCt3"));
     TERM1.setCellValueFactory(new PropertyValueFactory<meritListRecord, Double>("studentTerm1"));
     TERM2.setCellValueFactory(new PropertyValueFactory<meritListRecord, Double>("studentTerm2"));
     TERM3.setCellValueFactory(new PropertyValueFactory<meritListRecord, Double>("studentTerm3"));
     LAB.setCellValueFactory(new PropertyValueFactory<meritListRecord, Double>("studentLab"));
     MARKS.setCellValueFactory(new PropertyValueFactory<meritListRecord, Double>("studentMarks"));
     
     
        try {
            table.setItems(getData());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowMeritlistController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ShowMeritlistController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     
    } 
    
    
        public ObservableList<meritListRecord> getData() throws ClassNotFoundException, SQLException
{

 // ObservableList<Record> studentInfo=FXCollections.observableArrayList();
      Connection c = null;
      Statement stmt = null;
      ResultSet rs = null;
     Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
      stmt = c.createStatement();
      
      String ct1 = null,ct2 = null,ct3 = null,term1 = null,term2 = null,term3 = null,lab = null;
      int i=0;
     rs = stmt.executeQuery( "SELECT DISTINCT TeacherName,CT1weight,CT2weight,CT3weight,TERM1weight,TERM2weight,TERM3weight, LABweight FROM AssignCourse WHERE CourseName='"+TSform.subject+"' AND CLASS='"+TSform.clss+"';" );

     while(rs.next())
     {
         i++;
         ct1=rs.getString("CT1weight");
         ct2=rs.getString("CT2weight");
         ct3=rs.getString("CT3weight");
         term1=rs.getString("TERM1weight");
         term2=rs.getString("TERM2weight");
         term3=rs.getString("TERM3weight");
         lab=rs.getString("LABweight");
         if(i>0)break;
     }
     if(i==0)
     {
         msgbox.setText("Teacher is not assigned For Class "+TSform.clss+" in "+TSform.subject);
     }
     else
     {
        rs = stmt.executeQuery( "SELECT * FROM Class"+TSform.clss+" WHERE Subject='"+TSform.subject+"' AND CLASS='"+TSform.clss+"';" );
         
      while(rs.next())
      {
         
          String  className = rs.getString("CLASS");
          String subj=rs.getString("Subject");
          if(className.equals(TSform.clss) && subj.equals(TSform.subject) )
          {
              int id=rs.getInt("Roll");
              String name=rs.getString("studentName");
              
              String CT1=rs.getString("CT1");
              double ct1num=Double.parseDouble(CT1)*(Double.parseDouble(ct1)*1.0/100);
               ct1num=Double.parseDouble(new DecimalFormat("##.##").format(ct1num));
              
              String CT2=rs.getString("CT2");
              double ct2num=Double.parseDouble(CT2)*(Double.parseDouble(ct2)*1.0/100);
               ct2num=Double.parseDouble(new DecimalFormat("##.##").format(ct2num));
              
              String CT3=rs.getString("CT3");
              double ct3num=Double.parseDouble(CT3)*(Double.parseDouble(ct3)*1.0/100);
               ct3num=Double.parseDouble(new DecimalFormat("##.##").format(ct3num));
              
              String TERM1=rs.getString("TERM1");
              double term1num=Double.parseDouble(TERM1)*(Double.parseDouble(term1)*1.0/100);
               term1num=Double.parseDouble(new DecimalFormat("##.##").format(term1num));
              
              String TERM2=rs.getString("TERM2");
              double term2num=Double.parseDouble(TERM2)*(Double.parseDouble(term2)*1.0/100);
               term2num=Double.parseDouble(new DecimalFormat("##.##").format(term2num));
              
              String TERM3=rs.getString("TERM3");
              double term3num=Double.parseDouble(TERM3)*(Double.parseDouble(term3)*1.0/100);
               term3num=Double.parseDouble(new DecimalFormat("##.##").format(term3num));
              
              String LAB=rs.getString("LAB");
              double labnum=Double.parseDouble(LAB)*(Double.parseDouble(lab)*1.0/100);
              labnum=Double.parseDouble(new DecimalFormat("##.##").format(labnum));
              
              double marks=ct1num+ct2num+ct3num+term1num+term2num+term3num+labnum;
                marks=Double.parseDouble(new DecimalFormat("##.##").format(marks));
              
              
              meritListRecord S=new meritListRecord(id,name,ct1num,ct2num,ct3num,term1num,term2num,term3num,labnum,marks);
              data.add(S);
          }
          
          
      
      }
      
      rs.close();
      stmt.close();
      c.close();
      
     }
     
     
     // Comparator<meritListRecord>comparator=Comparator.comparingInt(meritListRecord::getStudentMarks );
     if(data.size()>0)Collections.sort(data, new sortListdone());

    
       // data.add(new Record(1,"Raj",3.00,4.00,5.00,6.00,7.00,1.00,25.00));
        //data.add(new Record(2,"Rahul",3.00,4.00,5.00,6.00,7.00,1.00,25.00));
       // data.add(new Record(3,"Kiron",3.00,4.00,5.00,6.00,7.00,1.00,25.00));
       // data.add(TSform.testRecord);
        return data;
        
  
}

    @FXML
    private void pdfhandler(ActionEvent event) {
        
        
        
    }

    @FXML
    private void backbuttonhandler(ActionEvent event) throws IOException {
        
       TSform.root = FXMLLoader.load(getClass().getResource("PrincipalHomepage.fxml"));         
       Scene scene = new Scene(TSform.root);         
       TSform.window.setScene(scene);
       TSform.window.setTitle("                                                                            Welcome");
       
      }  
    
  class sortListdone implements Comparator<meritListRecord>
{

          public int compare(meritListRecord x, meritListRecord y)
          {
              if(x.getStudentMarks()>y.getStudentMarks())return -1;
              if(x.getStudentMarks()<y.getStudentMarks())return 1;
              return 0;
          }
}  
    
    
}


