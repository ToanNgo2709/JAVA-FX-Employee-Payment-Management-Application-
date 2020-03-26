package org.FORM;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Admin extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("AdminForm.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setMaximized(true);
			primaryStage.setTitle("Admin");
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("org\\MULTIMEDIA\\iconfinder_People_132775.png"));
			primaryStage.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
