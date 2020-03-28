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
			Parent PerInfoViewPane = FXMLLoader.load(getClass().getResource("personalInfoForm.fxml"));
			Scene PerInfoViewScene = new Scene(PerInfoViewPane);
			Stage window = (Stage) myMenubar.getScene().getWindow();
			window.setScene(PerInfoViewScene);
			window.setMaximized(true);
			window.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void openAddWork(ActionEvent event) {
		try {
			Parent AddWorkPane = FXMLLoader.load(getClass().getResource("AddWorkForm.fxml"));
			Scene AddWorkScene = new Scene(AddWorkPane);
			Stage window = (Stage) myMenubar.getScene().getWindow();
			window.setScene(AddWorkScene);
			window.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void openManagerWork(ActionEvent event) {
		try {
			Parent ManagerWorkPane = FXMLLoader.load(getClass().getResource("EmployeeWorkManagerForm.fxml"));
			Scene ManagerWorkScene = new Scene(ManagerWorkPane);
			Stage window = (Stage) myMenubar.getScene().getWindow();
			window.setScene(ManagerWorkScene);
			window.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void openAddLeave(ActionEvent event) {
		try {
			Parent AddLeavePane = FXMLLoader.load(getClass().getResource("AddLeaveForm.fxml"));
			Scene AddLeaveScene = new Scene(AddLeavePane);
			Stage window = (Stage) myMenubar.getScene().getWindow();
			window.setScene(AddLeaveScene);
			window.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void openManagerLeave(ActionEvent event) {
		try {
			Parent ManagerLeavePane = FXMLLoader.load(getClass().getResource("LeaveHistoryForm.fxml"));
			Scene ManagerLeaveScene = new Scene(ManagerLeavePane);
			Stage window = (Stage) myMenubar.getScene().getWindow();
			window.setScene(ManagerLeaveScene);
			window.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void openSeePayment(ActionEvent event) {
		try {
			Parent SeePaymentPane = FXMLLoader.load(getClass().getResource("SeePaymentForm.fxml"));
			Scene SeePaymentScene = new Scene(SeePaymentPane);
			Stage window = (Stage) myMenubar.getScene().getWindow();
			window.setScene(SeePaymentScene);
			window.show();
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
