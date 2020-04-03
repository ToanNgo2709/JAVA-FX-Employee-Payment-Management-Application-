package org.FORM;

import java.io.IOException;

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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrationManagerForm.fxml"));
			Parent managerRegistrationViewPane = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(managerRegistrationViewPane));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void openAddProject(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProjectForm.fxml"));
			Parent addProjectViewPane = (Parent) loader.load();
			AddProjectController controller = loader.getController();
			Stage stage = new Stage();
			stage.setScene(new Scene(addProjectViewPane));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void openPaymentManager(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PaymentManagerForm.fxml"));
			Parent openPaymentViewPane = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(openPaymentViewPane));
			stage.show();
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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("loginForm.fxml"));
			Parent signOutPane = (Parent) loader.load();
			Stage stage1 = new Stage();
			stage1.setScene(new Scene(signOutPane));
			stage1.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
