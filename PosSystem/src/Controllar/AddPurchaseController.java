/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllar;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Application.PosSystem;

/**
 * FXML Controller class
 *
 * @author daniy
 */
public class AddPurchaseController implements Initializable {

    @FXML
    public JFXTextField customerName;
    @FXML
    public JFXTextField purchaseDetails;
    @FXML
    public JFXDatePicker date;
    @FXML
    public JFXTextField debit;
    @FXML
    public JFXTextField credit;
    @FXML
    public Label emptyErrorMessage;
    ArrayList<Integer> list = new ArrayList<Integer>();

    Statement st;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        emptyErrorMessage.setVisible(false);

        try {
            st = PosSystem.con.createStatement();
            ResultSet rs = st.executeQuery("select ID from Purchase");
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
//            oldUser = rs.getString(1);

        } catch (SQLException ex) {
            Logger.getLogger(ChangeUsernameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AddPurchase(ActionEvent evt) throws SQLException {
        String sql;
        String updDate = "" + date.getValue();
        String[] n = updDate.split("-");
        String dbDate;
        if ((!customerName.getText().isEmpty() && !purchaseDetails.getText().isEmpty() && date.getValue() != null && !debit.getText().isEmpty() && !credit.getText().isEmpty())) {
            dbDate = n[2] + "-" + n[1] + "-" + n[0];
            if (list.size() == 0) {
                sql = "insert into Purchase values(1"+ ",'" + customerName.getText() + "','" + purchaseDetails.getText() + "','" + dbDate + "'," + Integer.parseInt(debit.getText()) + "," + Integer.parseInt(credit.getText()) + ");";
            } else {
                sql = "insert into Purchase values(" + (list.get(list.size() - 1) + 1) + ",'" + customerName.getText() + "','" + purchaseDetails.getText() + "','" + dbDate + "'," + Integer.parseInt(debit.getText()) + "," + Integer.parseInt(credit.getText()) + ");";
            }
            Statement st = PosSystem.con.createStatement();
            st.executeUpdate(sql);

            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/Dashboard.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.resizableProperty().setValue(Boolean.FALSE);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AddNewProductController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            emptyErrorMessage.setVisible(true);
        }
    }

    public void Logout(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
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

    public void Products(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Products.fxml"));
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

    public void Stock(ActionEvent event) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Stock.fxml"));
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
            Parent root = FXMLLoader.load(getClass().getResource("/View/Settings.fxml"));
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
            Parent root = FXMLLoader.load(getClass().getResource("/View/Purchase.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
