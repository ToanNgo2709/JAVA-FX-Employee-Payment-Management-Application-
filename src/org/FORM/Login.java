package org.FORM;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Login extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Employee Payment Management Application");
			primaryStage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
