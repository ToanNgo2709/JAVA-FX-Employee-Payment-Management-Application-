package application;
	



import java.awt.event.ActionEvent;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
			Parent root = FXMLLoader.load(getClass().getResource("Myscene.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setTitle("hello");
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	@FXML 
	private void clickHere(ActionEvent event)
	{
		System.out.println("HEllo Toàn");
	}


}
