package org.FORM;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class EmployeeUI extends Preloader {
	
	public void start(Stage primaryStage){
		try {
			Parent root  = FXMLLoader.load(getClass().getResource("employeeUIForm.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Employee");
			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		launch(args);
	}
}
