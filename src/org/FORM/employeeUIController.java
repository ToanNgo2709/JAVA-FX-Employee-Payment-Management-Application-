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

	}

	@FXML
	public void openManagerWork(ActionEvent event) {

	}

	@FXML
	public void openAddLeave(ActionEvent event) {

	}

	@FXML
	public void openManagerLeave(ActionEvent event) {

	}

	@FXML
	public void openSeePayment(ActionEvent event) {

	}

	@FXML
	public void signOut(ActionEvent event) {

	}
}
