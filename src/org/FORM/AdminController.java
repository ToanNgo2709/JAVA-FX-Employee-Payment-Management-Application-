package org.FORM;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AdminController {
	@FXML
	private MenuBar myMenubar;
	@FXML
	private MenuItem mnitManagerRegistration;
	@FXML
	private MenuItem mnitLeaveManager;
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
			stage.setTitle("Registration Management");
			stage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void openLeaveManager(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LeaveManagerForm.fxml"));
			Parent leaveManagerViewPane = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(leaveManagerViewPane));
			stage.setTitle("Leave Management");
			stage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
			stage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void openAddProject(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProjectForm.fxml"));
			Parent addProjectViewPane = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(addProjectViewPane));
			stage.setTitle("Add Client,Project,Task");
			stage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
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
			stage.setTitle("Payment Management");
			stage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
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
			stage1.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
			stage1.setTitle("Login");
			stage1.setScene(new Scene(signOutPane));
			stage1.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
