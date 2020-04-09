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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
	private Label lblNotification;

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
		while (rs != null && rs.next()) {
			if (username.equals(rs.getString("Username")) && pw.equals(rs.getString("PW"))) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("employeeUIForm.fxml"));
					Parent employeeViewPane = (Parent) loader.load();
					Scene employeeViewScene = new Scene(employeeViewPane);

					employeeUIController controller = loader.getController();
					controller.getData(username);

					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
					window.setScene(employeeViewScene);
					window.setTitle("Employee");
					window.setMaximized(true);
					window.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
			} else if (username.equals("sa") && pw.equals("sa")) {
				try {
					Parent adminViewPane = FXMLLoader.load(getClass().getResource("AdminForm.fxml"));
					Scene adminViewScene = new Scene(adminViewPane);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
					window.setTitle("Admin");
					window.setScene(adminViewScene);
					window.setMaximized(true);
					window.show();
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				lblNotification.setText("Account not approval or not exist");
				lblNotification.setStyle("-fx-text-fill: red");
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
