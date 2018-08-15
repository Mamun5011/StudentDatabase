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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import static tsform.TSform.window;

/**
 * FXML Controller class
 *
 * @author Mamun
 */
public class LOGINController implements Initializable {
    @FXML
    private Button loginAction;
    @FXML
    private Button signupaction;
    @FXML
    private Text welcomeText;
    @FXML
    private TextField usernamefield;
    @FXML
    private TextField paswwordfield;
    @FXML
    private RadioButton principalbutton;
    @FXML
    private RadioButton teacherbutton;
    @FXML
    private ToggleGroup principle;
    @FXML
    private Label labelmsg;
    @FXML
    private ImageView leftImage;
    @FXML
    private ImageView rightImage;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    TSform.loginType="none";
    // this.leftImage =  new ImageView(new Image(getClass().getResourceAsStream("src\\tsform\\logo.jpg")));
    
       // Image image = new Image("resources\\img\\logo.jpg");
       // leftImage.setImage(image);
       // leftImage.setCache(true);
      Image i=new Image("resources\\img\\logo.jpg");
    //leftImage.setImage(new Image("..\\..\\resources\\img\\logo.jpg"));
       
        
        
      
     try {
         
     Connection c = null;
      Statement stmt = null;
      ResultSet rs;
     Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
      stmt = c.createStatement();
               
                        //String sql = "INSERT INTO Login " +
             // String sql = "DELETE FROM Login;";
                       // "VALUES ('Mamun1', '1234','Teacher');"; 
        // stmt.executeUpdate(sql);
         
       rs = stmt.executeQuery( "SELECT * FROM Login;" );
      while(rs.next())
      {
          String  name = rs.getString("Name");
           String  pass = rs.getString("Password");
          System.out.println("name: "+name);
          System.out.println("password: "+pass);
      }
      
           rs.close();
      stmt.close();
      c.close();
  


     } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
    }    

    @FXML
    private void LoginHandler(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        
       // labelmsg.setText("login!! ");
      Connection c = null;
      Statement stmt = null;
      ResultSet rs;
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:src\\tsform\\TSFORM");
      stmt = c.createStatement();
        
        
          String userName= usernamefield.getText();
          String password=paswwordfield.getText();
           
          int flag=0;
          
        if(teacherbutton.isSelected())
        {
           String tp="Teacher";
          rs = stmt.executeQuery( "SELECT * FROM Teacher;" );
          
          
                while ( rs.next() ) {
         // i++;
         
           String  name = rs.getString("Name");
           String  pass = rs.getString("Password");
          

           if(name.equals(userName) && pass.equals(password))
           {
           
            TSform.userName=userName;
             TSform.loginType="teacher";
             TSform.root = FXMLLoader.load(getClass().getResource("teacherHomepage.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            welcome");
             flag=1;
             break;
           }
           
           
           
        
      }
      rs.close();
      stmt.close();
      c.close();
          
         if(flag==0)labelmsg.setText(" please enter your info correctly");  
        
        } 
        else if(principalbutton.isSelected())
        {
            
        rs = stmt.executeQuery( "SELECT * FROM Login;" );
            String tp="Principal";
          
          
                while ( rs.next() ) {
         // i++;
         
           String  name = rs.getString("Name");
           String  pass = rs.getString("Password");
           String  type = rs.getString("Type");

           if(name.equals(userName) && pass.equals(password) && type.equals(tp))
           {    
            TSform.userName=userName;
            TSform.loginType="principal";
             TSform.root = FXMLLoader.load(getClass().getResource("PrincipalHomepage.fxml")); 
             Scene scene = new Scene(TSform.root);
             TSform.window.setScene(scene);
             TSform.window.setTitle("                                                                            welcome");
            flag=1;
             break;
           }  
           
                }
                
       rs.close();
      stmt.close();
      c.close();
            
            if(flag==0)labelmsg.setText(" please enter your info correctly");    
        }
        
        else
        {
            if(TSform.loginType=="none") labelmsg.setText(" please select your login type");
            else if(flag==0)labelmsg.setText(" please enter your info correctly");
           
            
             
        }
           
            
        
      
    }
          
        
            

    

    @FXML
    private void signupHandler(ActionEvent event) throws IOException {
    
            TSform.root = FXMLLoader.load(getClass().getResource("SignUp.fxml")); 
        
           Scene scene = new Scene(TSform.root);
           
        TSform.window.setScene(scene);
         TSform.window.setTitle("                                                                            Registration");
          }
    
}
