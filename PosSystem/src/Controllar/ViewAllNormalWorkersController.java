/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllar;

import Modal.NormalWorker;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Application.PosSystem;

/**
 * FXML Controller class
 *
 * @author daniy
 */
public class ViewAllNormalWorkersController implements Initializable {

    @FXML
    private TableView<NormalWorker> table;

    @FXML
    private TableColumn<NormalWorker, String> id;
    @FXML
    private TableColumn<NormalWorker, String> workerName;
    @FXML
    private TableColumn<NormalWorker, String> date;
    @FXML
    private TableColumn<NormalWorker, String> phoneNumber;
    @FXML
    private TableColumn<NormalWorker, String> amount;
    ObservableList<NormalWorker> list = FXCollections.observableArrayList();

    ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        try {
            // TODO
            Statement st = PosSystem.con.createStatement();
            rs = st.executeQuery("select * from NormalWorker order by ID");
            while (rs.next()) {

                list.add(new NormalWorker(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5)));
            }
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            workerName.setCellValueFactory(new PropertyValueFactory<>("workerName"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
            amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
            table.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(ViewProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Logout(ActionEvent event){
        
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                
//                stage.resizableProperty().setValue(Boolean.FALSE);
                stage.show();
                stage.centerOnScreen();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                
        }
        
    }


    
    public void Products(ActionEvent event){
        
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/Products.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                
//                stage.resizableProperty().setValue(Boolean.FALSE);
                stage.show();
                stage.centerOnScreen();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                
        }
        
    }
    
    public void Dashboard(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);

//                stage.resizableProperty().setValue(Boolean.FALSE);
            stage.show();
            stage.centerOnScreen();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
    
    public void Stock(ActionEvent event){
        
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/Stock.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                
//                stage.resizableProperty().setValue(Boolean.FALSE);
                stage.show();
                stage.centerOnScreen();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                
        }
        
    }


    public void Settings(ActionEvent event){
        
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/Settings.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                
//                stage.resizableProperty().setValue(Boolean.FALSE);
                stage.show();
                stage.centerOnScreen();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                
        }
        
    }    
    
    public void Purchase(ActionEvent event){
        
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/Purchase.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                stage.centerOnScreen();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                
        }
        
    }    
    public void Sales(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Sales.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);

//                stage.resizableProperty().setValue(Boolean.FALSE);
            stage.show();
            stage.centerOnScreen();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);

        }

    }
    
    public void Worker(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Worker.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);

//                stage.resizableProperty().setValue(Boolean.FALSE);
            stage.show();
            stage.centerOnScreen();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);

        }

    }
        
}
