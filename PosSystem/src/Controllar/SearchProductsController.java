/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllar;

import Modal.Products;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Application.PosSystem;
//import static sun.util.logging.LoggingSupport.log;

/**
 * FXML Controller class
 *
 * @author daniy
 */
public class SearchProductsController implements Initializable {

    @FXML
    private TableView<Products> table;

    @FXML
    private TableColumn<Products, String> id;
    @FXML
    private TableColumn<Products, String> prodname;
    @FXML
    private TableColumn<Products, String> volume;
    @FXML
    private TableColumn<Products, String> rate;
    @FXML
    private TableColumn<Products, String> quantity;
    @FXML
    private TableColumn<Products, String> amount;

    @FXML
    public JFXButton search;
    @FXML
    public JFXTextField name;
    @FXML
    public Label notFound;

    ArrayList<String> list = new ArrayList<String>();

    boolean check = false;
    ObservableList<Products> list1 = FXCollections.observableArrayList();
    ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        try {
            Statement st = PosSystem.con.createStatement();
            ResultSet rs = st.executeQuery("select ProductName from Products");
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void search(ActionEvent event) throws SQLException {

        for (int i = 0; i < list.size(); i++) {
            if (name.getText().toLowerCase().matches(list.get(i).toLowerCase())) {
                check = true;
            }
        }
        if (check == false) {
            notFound.setVisible(true);
        }
        if (check == true) {
//            System.out.println("Check " + check);
            table.setVisible(true);
            search.setVisible(false);
            notFound.setVisible(false);
            Statement st = PosSystem.con.createStatement();
            rs = st.executeQuery("select * from Products where ProductName = '" + name.getText() + "'");
            while (rs.next()) {
                list1.add(new Products(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }

            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            prodname.setCellValueFactory(new PropertyValueFactory<>("name"));
            volume.setCellValueFactory(new PropertyValueFactory<>("volume"));
            rate.setCellValueFactory(new PropertyValueFactory<>("rate"));
            quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
            amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
            table.setItems(list1);
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
