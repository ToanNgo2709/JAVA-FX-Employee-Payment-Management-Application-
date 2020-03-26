package org.FORM;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddWorkController {
	@FXML
	private ChoiceBox<String> chbClient;
	@FXML
	private ChoiceBox<String> chbProject;
	@FXML
	private ChoiceBox<String> chbTask;
	@FXML
	private TextField tfNoHour;
	@FXML 
	private Button btnAdd;
	@FXML
	private Button btnCancel;
	
	@FXML
	public void addWork(ActionEvent event) {
		
	}
	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	}
	
}
