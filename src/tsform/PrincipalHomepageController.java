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
            FXCollections.observableArrayList("6","7","8","9","10");
    @FXML
    private Label namemsgbox;
    @FXML
    private Label coursemsgbox;
    @FXML
    private TextField teachernamefield;
    @FXML
    private TextField coursenamefield;
    @FXML
    private ChoiceBox<String> subjchoicebox;
    @FXML
    private Label msgfield1;
    
   ObservableList<String>courseName=FXCollections.observableArrayList(); 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            classchoicebox.setValue("6");
            classchoicebox.setItems(classList);
            String S1=classchoicebox.getValue();
            
            
            // TODO
            
            Connection c = null;
            Statement stmt = null;
            ResultSet rs = null;
        
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
            stmt = c.createStatement();
            
            
            rs = stmt.executeQuery( "SELECT * FROM Course;" );

            while(rs.next())
            {
                String  nm = rs.getString("CourseName");
                courseName.add(nm);
                
            }
            
            if(courseName.size()>0) subjchoicebox.setValue(courseName.get(0));
            // courselist.setValue("Bangla");
            subjchoicebox.setItems(courseName);
            
            c.close();
            rs.close();
            stmt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrincipalHomepageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalHomepageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
        
        
        
    }    

    @FXML
    private void showlistbuttonhandler(ActionEvent event) throws IOException {
        
       
        
        TSform.subject=subjchoicebox.getValue();
        TSform.clss=classchoicebox.getValue();
           TSform.root = FXMLLoader.load(getClass().getResource("class3table.fxml")); 
        
           Scene scene = new Scene(TSform.root);
           
        TSform.window.setScene(scene);
         TSform.window.setTitle("                                                                            welcome");
        
    }

    @FXML
    private void assigncourseteacher(ActionEvent event) throws IOException {
        TSform.root = FXMLLoader.load(getClass().getResource("addteacher.fxml"));      
        Scene scene = new Scene(TSform.root);  
        TSform.window.setScene(scene);
        TSform.window.setTitle("                                                                            welcome");
          }  

    @FXML
    private void backbuttonhandler(ActionEvent event) throws IOException 
    {
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
    private void addTeacher(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        if(teachernamefield.getText().equals(""))namemsgbox.setText("Name Here!!!");
        else
        {
        String name=teachernamefield.getText();
        
              Connection c = null;
      Statement stmt = null;
     int flag=1,idno = 1;
     
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
      stmt = c.createStatement();  
      ResultSet rs = stmt.executeQuery( "SELECT * FROM Teacher;" );
      while(rs.next())
      {
          String  nm = rs.getString("Name");
           idno=rs.getInt("Id");
          idno++;
          System.out.println("Name: "+nm);
          if(nm.equals(name))
          {
              flag=0;
              namemsgbox.setText("not unique");
              break;
          }
      }
      
      if(flag==1)
      {
              String sql = "INSERT INTO Teacher " +        
                        "VALUES ("+idno+",'"+name+"','1234');"; 
     // String sql = "INSERT INTO Login (Name,Password,Type,Contact,Email) " + "VALUES (name,pass,tp,contact,email);"; 
         stmt.executeUpdate(sql);
         stmt.close();
           
          teachernamefield.setText("");
      }
      
       c.close(); 
       rs.close();
        
        } 
    }

    @FXML
    private void addCourse(ActionEvent event) throws ClassNotFoundException, SQLException 
    {
        
       if(coursenamefield.getText().equals(""))coursemsgbox.setText("Course Here!!!");
            else
        {
        String name=coursenamefield.getText();
        
              Connection c = null;
      Statement stmt = null;
     int flag=1,courseno = 1;
     
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
      stmt = c.createStatement();  
      ResultSet rs = stmt.executeQuery( "SELECT * FROM Course;" );
      while(rs.next())
      {
          String  nm = rs.getString("CourseName");
           courseno=rs.getInt("Id");
          courseno++;
          System.out.println("Name: "+nm);
          if(nm.equals(name))
          {
              flag=0;
              coursemsgbox.setText("not unique");
              break;
          }
      }
      
      if(flag==1)
      {
                                      String sql = "INSERT INTO Course " +
             // String sql = "DELETE FROM Login;";
                        "VALUES ("+courseno+",'"+name+"');"; 
     // String sql = "INSERT INTO Login (Name,Password,Type,Contact,Email) " + "VALUES (name,pass,tp,contact,email);"; 
         stmt.executeUpdate(sql);
         stmt.close();
         coursenamefield.setText("");
           
          
      }
      
       c.close(); 
       rs.close();
        
        } 
       
       
    }

    @FXML
    private void MeritListHandler(ActionEvent event) throws IOException {
        
         TSform.subject=subjchoicebox.getValue();
        TSform.clss=classchoicebox.getValue();
                TSform.root = FXMLLoader.load(getClass().getResource("showMeritlist.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            Welcome");
          } 

    @FXML
    private void clearDataHandler(ActionEvent event) throws IOException 
    {
        
        
              TSform.root = FXMLLoader.load(getClass().getResource("clearDatapage.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            Welcome");
          } 
    
}
