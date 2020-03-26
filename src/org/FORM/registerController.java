package org.FORM;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class registerController {
	
	@FXML
	private Button btnRegister;
	@FXML
	private Button btnCancel;
	@FXML
	private Button btnBackToLogin;
	
	//*this method use to switch scene from controller class
	@FXML
	public void goToLogin(ActionEvent event) {
		try {
			Parent loginViewPane = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
			Scene scene = new Scene(loginViewPane);
			
			//This line gets the Stage Information
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
	}
	public void Register() {
		
	}
	
}
