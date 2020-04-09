package org.FORM;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.MODELS.DBconnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

	private String usernameInfo;

	public String getUsernameInfo() {
		return usernameInfo;
	}

	public void setUsernameInfo(String usernameInfo) {
		this.usernameInfo = usernameInfo;
	}

	String getClientValue;
	// Initialize 3 choice box
	final ObservableList<String> clientChoiceBox = FXCollections.observableArrayList();
	final ObservableList<String> projectChoiceBox = FXCollections.observableArrayList();
	final ObservableList<String> taskChoiceBox = FXCollections.observableArrayList();

	public void initAddWork() {
		chbClient.setItems(clientChoiceBox);
		try {
			String query = "SELECT * FROM CLIENT";
			ResultSet rs = DBconnection.Query(query);
			while (rs.next()) {
				clientChoiceBox.add(rs.getString("Client_Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		chbClient.setOnAction(event -> {
			String clientInfo = chbClient.getSelectionModel().getSelectedItem().toString();
			try {
				String query = "SELECT CLIENT.ID FROM CLIENT INNER JOIN PROJECT ON CLIENT.ID = PROJECT.Client_ID WHERE Client_Name LIKE "
						+ "'" + clientInfo + "'";
				ResultSet rs = DBconnection.Query(query);
				chbProject.setItems(projectChoiceBox);
				projectChoiceBox.removeAll(projectChoiceBox);
				while (rs.next()) {
					int id = rs.getInt("ID");
					String getProject = "SELECT Project_Name FROM PROJECT WHERE Client_ID = " + id;
					ResultSet rs2 = DBconnection.Query(getProject);
					while (rs2.next()) {
						projectChoiceBox.add(rs2.getString("Project_Name"));
					}
				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		});
		chbProject.setOnAction(event -> {
			String projectInfo = chbProject.getSelectionModel().getSelectedItem().toString();
			try {
				String query2 = "SELECT PROJECT.ID FROM PROJECT INNER JOIN TASK ON PROJECT.ID = TASK.Project_ID WHERE Project_Name LIKE "
						+ "'" + projectInfo + "'";
				ResultSet rs3 = DBconnection.Query(query2);
				chbTask.setItems(taskChoiceBox);
				taskChoiceBox.removeAll(taskChoiceBox);
				while (rs3.next()) {
					int projectID = rs3.getInt("ID");
					String getTask = "SELECT Task_Name FROM TASK WHERE Project_ID = " + projectID;
					ResultSet rs4 = DBconnection.Query(getTask);
					while (rs4.next()) {
						taskChoiceBox.add(rs4.getString("Task_Name"));
					}
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		});
	}

	@FXML
	public void addWork(ActionEvent event) throws SQLException {
		String taskInfo = chbTask.getSelectionModel().getSelectedItem().toString();
		String query = "SELECT ID FROM TASK WHERE Task_Name = " + "'" + taskInfo + "'";
		ResultSet rs2 = DBconnection.Query(query);
		while (rs2.next()) {
			int taskId = rs2.getInt("ID");
			String query3 = "SELECT ID FROM EMPLOYEE WHERE Username = " + "'" + this.usernameInfo + "'";
			ResultSet rs = DBconnection.Query(query3);
			while (rs.next()) {
				String insert = "INSERT INTO WORK (Task_ID,Employee_ID) VALUES (?,?)";
				PreparedStatement prep = DBconnection.Connect().prepareStatement(insert);
				int employeeId = rs.getInt("ID");
				prep.setInt(1, taskId);
				prep.setInt(2, employeeId);
				prep.executeUpdate();
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.showAndWait();
			}
		}
	}

	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

}
