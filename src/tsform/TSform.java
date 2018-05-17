/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsform;

import java.io.IOException;
import java.net.Socket;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TSform extends Application {
    
    public static Parent root;
    public static Stage window;
    public static Record studentdetails;
     public static admissionRecord admissionStudentdetails;
     public static ObservableList<String>teachernameList=FXCollections.observableArrayList("Mr. Rahim","Mr. Karim","Mrs. rahima");;
     public static ObservableList<String>coursenameList= FXCollections.observableArrayList("Bangla","English","Physics","Chemistry","Math");;

    public static Record testRecord=new Record(4,"Raj",3.00,4.00,5.00,6.00,7.00,1.00);
    public static String loginType;
    public static int count=1;
    public static String S="Student Evaluation System";

    
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("LOGIN.fxml")); 
        
        Scene scene = new Scene(root);   
        window = primaryStage;
        window.setScene(scene);
        window.setTitle(S);
       window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
