package org.FORM;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class employeeUIController implements Initializable {
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

	public String username;

	public void getData(String username1) {
		username = username1;
	}

	@FXML
	public void openPersonInfo(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("personalInfoForm.fxml"));
			Parent perInfoViewPane = (Parent) loader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(perInfoViewPane));
			personalInfoController controller = loader.getController();
			controller.getUsername(this.username);
			stage.setTitle("Personal Infomation");
			stage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
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
			stage.setTitle("Add work");
			stage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
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
			stage.setTitle("Manager Work");
			stage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
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
			stage.setTitle("Add Leave");
			AddLeaveController controller = loader.getController();
			controller.getUsername(this.username);
			stage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
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
			stage.setTitle("Manager Leave");
			stage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
			stage.show();
		} catch (Exception e) {
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
			stage.setTitle("See Payment");
			SeePaymentController controller = loader.getController();
			controller.getUsername(this.username);
			stage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
			stage.show();
		} catch (Exception e) {
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
			Stage stage2 = new Stage();
			stage2.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
			stage2.setTitle("Login");
			stage2.setScene(new Scene(signOutPane));
			stage2.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
}
