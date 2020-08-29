/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

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

/**
 * FXML Controller class
 *
 * @author daniy
 */
public class DeleteProductController implements Initializable {

    
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
    public JFXButton delete;
    @FXML
    public JFXButton search;
    @FXML
    public TextField name;
    @FXML
    public Label notFound;
    ArrayList<String> list=new ArrayList<String>();
    ArrayList<Integer> ids=new ArrayList<Integer>();
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
            // TODO
//            table1 = table;
            Statement st = PosSystem.con.createStatement();
            ResultSet rs = st.executeQuery("select ProductName from Products");
//            rs.next();
//            productName = rs.getString("UserName");
            while(rs.next()){
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
    
    public void search(ActionEvent event) throws SQLException{
        
        for(int i=0;i<list.size();i++){
            if(name.getText().toLowerCase().matches(list.get(i).toLowerCase())){
//                System.out.println(name.getText());
//                System.out.println(list.get(i));
                check= true;
            }
//            System.out.println(list.get(i));
            
        }
        if(check==false){
            notFound.setVisible(true);
        }
        if(check==true){
            table.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
//            table.setEditable(true);
//            table.getSelectionModel().cellSelectionEnabledProperty().set(true);
//            table.getSelectionModel().getSelectedItems();
//            table1.getSelectionModel().getSelectedItem();
            notFound.setVisible(false);
            Statement st = PosSystem.con.createStatement();
            rs = st.executeQuery("select * from Products where ProductName = '"+name.getText()+"'");
            while (rs.next()) {
                list1.add(new Products(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),rs.getString(6)));
            }
            
            id.setCellValueFactory(new PropertyValueFactory<Products, String>("id"));
            prodname.setCellValueFactory(new PropertyValueFactory<Products, String>("name"));
            volume.setCellValueFactory(new PropertyValueFactory<Products, String>("volume"));
            rate.setCellValueFactory(new PropertyValueFactory<Products, String>("rate"));
            quantity.setCellValueFactory(new PropertyValueFactory<Products, String>("quantity"));
            amount.setCellValueFactory(new PropertyValueFactory<Products, String>("amount"));
            table.setItems(list1);
        }
        
    }
    
    public void delete(ActionEvent event) throws SQLException{
        Statement st = PosSystem.con.createStatement();
        rs=st.executeQuery(("select ID from Products"));
        while(rs.next()){
            ids.add(rs.getInt(1));
        }
        
        String id = table.getSelectionModel().getSelectedItem().getId();
        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
        st.executeUpdate("DELETE from Products WHERE ID = "+id);
        
        for(int i=Integer.parseInt(id);i<ids.size();i++){
            st.executeUpdate("UPDATE Products SET ID = "+i+" WHERE ID= "+(i+1));
        }
        
        try {
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
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
    
    
    public void Logout(ActionEvent event){
        
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
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
    
    public void Dashboard(ActionEvent event){
        
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("Products.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("Stock.fxml"));
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
    public void Sales(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Sales.fxml"));
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
    
    public void Purchase(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Purchase.fxml"));
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
    
    public void Settings(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
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
    public void Worker(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
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
    
}
