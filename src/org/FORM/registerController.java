package org.FORM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.MODELS.DBconnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class registerController {
	@FXML
	private TextField tfFullName;
	@FXML
	private Button btnRegister;
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnBackToLogin;
	@FXML
	private TextField tfUsername;
	@FXML
	private PasswordField pfPW;
	@FXML
	private PasswordField pfRePW;

	// *this method use to switch scene from controller class
	@FXML
	public void goToLogin(ActionEvent event) {
		try {
			Parent loginViewPane = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
			Scene scene = new Scene(loginViewPane);
			// This line gets the Stage Information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@FXML
	public void Register() {
		try {
			String username = tfUsername.getText();
			String sqlQuery = "SELECT Username FROM EMPLOYEE";
			ResultSet rs = DBconnection.Query(sqlQuery);
			while (rs.next()) {
				if (username.equals(rs.getString("Username"))) {
					Alert alertAlreadyExist = new Alert(AlertType.ERROR);
					alertAlreadyExist.setTitle("ERROR");
					alertAlreadyExist.setHeaderText("Can't register");
					alertAlreadyExist.setContentText("Account already exists");
					alertAlreadyExist.showAndWait();
					break;
				} else if (pfPW.getText().equals(pfRePW.getText()) == false) {
					Alert notMatchPW = new Alert(AlertType.WARNING);
					notMatchPW.setTitle("Error");
					notMatchPW.setHeaderText("Result");
					notMatchPW.setContentText("Password not match to each other!");
					notMatchPW.showAndWait();
					pfPW.setText("");
					pfRePW.setText("");
				} else {
					PreparedStatement prep = DBconnection.Connect().prepareStatement(
							"INSERT INTO EMPLOYEE (Username,PW,Approve_status,Name) VALUES (?,?,?,?)");
					prep.setString(1, tfUsername.getText());
					prep.setString(2, pfPW.getText());
					prep.setString(3, "No");
					prep.setString(4, tfFullName.getText());
					prep.executeUpdate();
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Register");
					alert.setHeaderText("Register Successfully");
					alert.setContentText("Please wait for admin approval to login ");
					alert.showAndWait();
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
