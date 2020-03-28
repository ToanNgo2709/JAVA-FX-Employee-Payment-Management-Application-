package org.FORM;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class AdminController {
	@FXML
	private MenuBar myMenubar;
	@FXML
	private MenuItem mnitManagerRegistration;
	@FXML
	private MenuItem mnitAddProject;
	@FXML
	private MenuItem mnitPaymentManager;
	@FXML
	private MenuItem mnitSignout;

	@FXML
	public void openManagerRegistration(ActionEvent event) {
		try {
			Parent ManagerRegistrationPane = FXMLLoader.load(getClass().getResource("RegistrationManagerForm.fxml"));
			Scene ManagerRegistrationScene = new Scene(ManagerRegistrationPane);
			Stage window = (Stage) myMenubar.getScene().getWindow();
			window.setScene(ManagerRegistrationScene);
			window.setMaximized(true);
			window.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void openAddProject(ActionEvent event) {
		try {
			Parent AddProjectPane = FXMLLoader.load(getClass().getResource("AddProjectForm.fxml"));
			Scene AddProjectScene = new Scene(AddProjectPane);
			Stage window = (Stage) myMenubar.getScene().getWindow();
			window.setScene(AddProjectScene);
			window.setMaximized(true);
			window.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void openPaymentManager(ActionEvent event) {
		try {
			Parent PaymentManagerPane = FXMLLoader.load(getClass().getResource("PaymentManagerForm.fxml"));
			Scene PaymentManagerScene = new Scene(PaymentManagerPane);
			Stage window = (Stage) myMenubar.getScene().getWindow();
			window.setScene(PaymentManagerScene);
			window.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void signOut(ActionEvent event) {
		Stage stage = (Stage) myMenubar.getScene().getWindow();
		stage.close();
		try {
			Parent LoginPane = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
			Scene LoginScene = new Scene(LoginPane);
			Stage window = (Stage) myMenubar.getScene().getWindow();
			window.setScene(LoginScene);
			window.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
