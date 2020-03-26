package org.FORM;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EmployeeWorkManagerController {
	@FXML
	private Button btnUpdate;
	@FXML
	private Button btnCancel;
	
	@FXML
	public void Update(ActionEvent event) {
		
	}
	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	}
}
