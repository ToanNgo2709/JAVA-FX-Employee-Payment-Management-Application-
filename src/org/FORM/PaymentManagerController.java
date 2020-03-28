package org.FORM;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PaymentManagerController {
	@FXML
	private Button btnPrint;
	@FXML
	private Button btnClose;

	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	public void Print(ActionEvent event) {

	}
}
