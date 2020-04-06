package org.FORM;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.MODELS.DBconnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddWorkController implements Initializable {
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

	// Initialize 3 choice box
	final ObservableList<String> clientChoiceBox = FXCollections.observableArrayList();
	final ObservableList<String> projectChoiceBox = FXCollections.observableArrayList();
	final ObservableList<String> taskChoiceBox = FXCollections.observableArrayList();

	@FXML
	public void addWork(ActionEvent event) {
		String getClientValue = chbClient.getSelectionModel().getSelectedItem();
		String getProjectValue = chbProject.getSelectionModel().getSelectedItem();
		String getTaskValue = chbTask.getSelectionModel().getSelectedItem();

		String clientID = null;
		String projectID = null;
		String TaskID = null;

		String selectID = "SELECT * FROM CLIENT INNER JOIN PROJECT ON Client.ID = PROJECT.Client_ID INNER JOIN TASK ON PROJECT.ID = TASK.Project_ID WHERE Client_Name = "
				+ "'" + getClientValue + "'";
		ResultSet rs = DBconnection.Query(selectID);

	}

	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		chbClient.setItems(clientChoiceBox);
		try {
			String query = "SELECT * FROM CLIENT";
			ResultSet rs = DBconnection.Query(query);
			while (rs.next()) {
				clientChoiceBox.add(rs.getString("Client_Name"));
			}
			DBconnection.Connect().close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		chbProject.setItems(projectChoiceBox);
		try {
			String query = "SELECT * FROM PROJECT";
			ResultSet rs = DBconnection.Query(query);
			while (rs.next()) {
				projectChoiceBox.add(rs.getString("Project_Name"));
			}
			DBconnection.Connect().close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		chbTask.setItems(taskChoiceBox);
		try {
			String query = "SELECT * FROM TASK";
			ResultSet rs = DBconnection.Query(query);
			while (rs.next()) {
				taskChoiceBox.add(rs.getString("Task_Name"));
			}
			DBconnection.Connect().close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
