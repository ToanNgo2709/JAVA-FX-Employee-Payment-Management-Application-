package org.FORM;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
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
	public void goToRegister(ActionEvent event) throws IOException {
		Parent registerViewPane = FXMLLoader.load(getClass().getResource("registerForm.fxml"));
		Scene registerViewScene = new Scene(registerViewPane);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(registerViewScene);
		window.show();
	}

	@FXML
	public void loginToUI(ActionEvent event) {
		String username = tfUsername.getText();
		String pw = pfPW.getText();
		// **set enter key
		btnLogin.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {
				btnLogin.fire();
			}
		});
		// open Employee Scene when login with Employee Account;
		if (username.equals("em") && pw.equals("em")) {
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
		}
	}

	// this method use to close window when click Cancel button
	@FXML
	public void cancel(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@FXML
	public void showPW(ActionEvent event) {

	}

}
