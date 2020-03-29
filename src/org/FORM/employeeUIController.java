package org.FORM;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class employeeUIController {
	@FXML
	private MenuBar myMenubar;
	@FXML
	private MenuItem mnitPersonInfo;
	@FXML
	private MenuItem mnitAddWork;
	@FXML
	private MenuItem mnitManagerWork;
	@FXML
	private MenuItem mnitAddLeave;
	@FXML
	private MenuItem mnitManagerLeave;
	@FXML
	private MenuItem mnitSeePayment;
	@FXML
	private MenuItem mnitSignout;

	@FXML
	public void openPersonInfo(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("personalInfoForm.fxml"));
			Parent perInfoViewPane = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(perInfoViewPane));
			stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void openAddWork(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddWorkForm.fxml"));
			Parent openAddWordPane = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(openAddWordPane));
			stage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void openManagerWork(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EmployeeWorkManagerForm.fxml"));
			Parent openManagerWordPane = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(openManagerWordPane));
			stage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void openAddLeave(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddLeaveForm.fxml"));
			Parent addLeaveViewPane = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(addLeaveViewPane));
			stage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void openManagerLeave(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("LeaveHistoryForm.fxml"));
			Parent openManagerLeaveViewPane = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(openManagerLeaveViewPane));
			stage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void openSeePayment(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SeePaymentForm.fxml"));
			Parent openSeePaymentPane = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(openSeePaymentPane));
			stage.show();
		} catch (Exception e) {
			// TODO: handle exception
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
