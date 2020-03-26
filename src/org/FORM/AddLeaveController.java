package org.FORM;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddLeaveController {
	@FXML
	private RadioButton rdbHours;
	@FXML
	private RadioButton rdbDays;
	@FXML
	private TextField tfNoToRequest;
	@FXML
	private TextArea taReason;
	@FXML
	private Button btnRequest;
	@FXML
	private Button btnCancel;
	
	@FXML
	public void requestToAdmin(ActionEvent event) {
		
	}
	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	}
	
}
