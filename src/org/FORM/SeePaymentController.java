package org.FORM;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SeePaymentController {
	@FXML
	private Button btnConfirm;
	@FXML
	private Button btnClose;
	@FXML
	private TextField tfOfftime;
	@FXML
	private TextField tfWages;
	@FXML
	private TextField tfTax;
	@FXML
	private TextField tfToTal;

	public void confirmSendToAdmin(ActionEvent event) {

	}

	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

}
