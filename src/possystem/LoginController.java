/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author daniy
 */
public class LoginController implements Initializable {

    
    String username,pass;
    @FXML
    private TextField name;
    @FXML
    private PasswordField password;
    @FXML
    private Label error;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            // TODO
            error.setVisible(false);
            Statement st = PosSystem.con.createStatement();
            ResultSet rs = st.executeQuery("select * from User");
            rs.next();
            username = rs.getString("UserName");
            pass = rs.getString("Password");
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    
    @FXML
    public void Login(ActionEvent event) throws InterruptedException{
        
        if(name.getText().matches(username)&&password.getText().matches(pass)){
            try {
                
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.resizableProperty().setValue(Boolean.FALSE);
                
                stage.show();
                stage.centerOnScreen();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        else
        {
            error.setVisible(true);
            error.setText("Enter Username and Password First");
        }
    }
}
    
    

