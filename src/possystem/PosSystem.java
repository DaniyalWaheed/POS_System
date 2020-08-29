/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author daniy
 */
public class PosSystem extends Application {
    
    static Connection con;
    
    @Override
    public void start(Stage stage) {
        
        try{
            
        DatabaseCreation db = new DatabaseCreation();
        db.startDatabaseProcess();
        con = DriverManager.getConnection("jdbc:ucanaccess://posDb.accdb");
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(root,650,380);
        stage.setTitle(" Inventory Managemnet System");
        stage.getIcons().add(new Image("Resources/title.png"));
//        stage.getIcons().add(new Image("Resources/Shopping Cart Loaded_80px.png"));
        
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        
        stage.show();
        stage.centerOnScreen();
        
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println(e);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
