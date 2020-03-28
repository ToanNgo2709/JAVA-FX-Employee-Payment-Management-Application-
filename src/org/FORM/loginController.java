package org.FORM;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {
	@FXML
	private Button btnGoToRegister;
	@FXML
	private Button btnLogin;
	@FXML
	private CheckBox showPWChck;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField tfUsername;
	@FXML
	private PasswordField pfPW;
	@FXML
	private Label lblShowPW;

	@FXML
	public void goToRegister(ActionEvent event) throws IOException {
		Parent registerViewPane = FXMLLoader.load(getClass().getResource("registerForm.fxml"));
		Scene registerViewScene = new Scene(registerViewPane);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(registerViewScene);
		window.show();
	}

	@FXML
	public void loginToUI(ActionEvent event) throws SQLException {
		String username = tfUsername.getText();
		String pw = pfPW.getText();
		// open Employee Scene when login with Employee Account;
		String strQuery = "SELECT * FROM EMPLOYEE WHERE Approve_status = 'Yes'";
		ResultSet rs = DBconnection.Query(strQuery);
		while (rs.next()) {
			if (username.equals(rs.getString("Username")) && pw.equals(rs.getString("PW"))) {
				try {
					Parent employeeViewPane = FXMLLoader.load(getClass().getResource("employeeUIForm.fxml"));
					Scene employeeViewScene = new Scene(employeeViewPane);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(employeeViewScene);
					window.setMaximized(true);
					window.show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// open Admin Scene when login with Admin Account;
			} else if (username.equals("sa") && pw.equals("sa")) {
				try {
					Parent adminViewPane = FXMLLoader.load(getClass().getResource("AdminForm.fxml"));
					Scene adminViewScene = new Scene(adminViewPane);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(adminViewScene);
					window.setMaximized(true);
					window.show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Alert alert2 = new Alert(AlertType.ERROR);
				alert2.setTitle("Error");
				alert2.setHeaderText("Can't login to application");
				alert2.setContentText("The account is not registered,not approved or does not exist");
				alert2.showAndWait();
				tfUsername.setText("");
				pfPW.setText("");
			}
		}
		DBconnection.Connect().close();
	}

	// this method use to close window when click Cancel button
	@FXML
	public void cancel(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@FXML
	public void showPW(ActionEvent event) {
		if (showPWChck.isSelected()) {
			String pw = pfPW.getText();
			lblShowPW.setText(pw);
		} else {
			lblShowPW.setText("");
		}
	}

}
