/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllar;

import Modal.Purchase;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
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

/**
 * FXML Controller class
 *
 * @author daniy
 */
public class DeletePurchaseDetailsController implements Initializable {

    @FXML
    private TableView<Purchase> table;

    @FXML
    private TableColumn<Purchase, String> id;
    @FXML
    private TableColumn<Purchase, String> customerName;
    @FXML
    private TableColumn<Purchase, String> purchaseDetails;
    @FXML
    private TableColumn<Purchase, String> date;
    @FXML
    private TableColumn<Purchase, String> debit;
    @FXML
    private TableColumn<Purchase, String> credit;

    @FXML
    public JFXButton delete;
    @FXML
    public JFXButton search;
    @FXML
    public TextField name;
    @FXML
    public Label notFound;
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<Integer> ids = new ArrayList<Integer>();
    boolean check = false;
    ObservableList<Purchase> list1 = FXCollections.observableArrayList();
    ResultSet rs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        table.setVisible(false);
        delete.setVisible(false);
        try {
            Statement st = PosSystem.con.createStatement();
            ResultSet rs = st.executeQuery("select CustomerName from Purchase");
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void search(ActionEvent event) throws SQLException {
        list1.removeAll(list1);
        for (int i = 0; i < list.size(); i++) {
            if (name.getText().toLowerCase().matches(list.get(i).toLowerCase())) {
                check = true;
            }
        }
        if (check == false) {
            notFound.setVisible(true);
        }
        if (check == true) {
            table.setVisible(true);
            delete.setVisible(true);
            notFound.setVisible(false);
            Statement st = PosSystem.con.createStatement();
            rs = st.executeQuery("select * from Purchase where CustomerName = '" + name.getText() + "'");
            while (rs.next()) {
                list1.add(new Purchase(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }

            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
            purchaseDetails.setCellValueFactory(new PropertyValueFactory<>("purchaseDetails"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            debit.setCellValueFactory(new PropertyValueFactory<>("debit"));
            credit.setCellValueFactory(new PropertyValueFactory<>("credit"));
            table.setItems(list1);
        }

    }

    public void delete(ActionEvent event) throws SQLException {
        Statement st = PosSystem.con.createStatement();
        rs = st.executeQuery(("select ID from Purchase"));
        while (rs.next()) {
            ids.add(rs.getInt(1));
        }

        String id = table.getSelectionModel().getSelectedItem().getId();
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
        st.executeUpdate("DELETE from Purchase WHERE ID = " + id);

        for (int i = Integer.parseInt(id); i < ids.size(); i++) {
            st.executeUpdate("UPDATE Purchase SET ID = " + i + " WHERE ID= " + (i + 1));
        }

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void Logout(ActionEvent event){
        
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(scene);
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
            stage.show();
            stage.centerOnScreen();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class
                    .getName()).log(Level.SEVERE, null, ex);

        }

    }
        
}
