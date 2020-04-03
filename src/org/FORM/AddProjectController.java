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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProjectController implements Initializable {
	@FXML
	private TextField tfClientName;
	@FXML
	private TextArea taClientAddress;
	@FXML
	private TextField tfClientEmail;
	@FXML
	private TextField tfPhone;
	@FXML
	private Button btnSearchClient;
	@FXML
	private Button btnAddClient;
	@FXML
	private Button btnCancel;
	@FXML
	private ChoiceBox<String> chbClient;
	@FXML
	private TextField tfProjectName;
	@FXML
	private TextArea taProjectDes;
	@FXML
	private Button btnSearchProject;
	@FXML
	private Button btnAddProject;
	@FXML
	private ChoiceBox<String> chbProject;
	@FXML
	private TextField tfTaskName;
	@FXML
	private TextField tfNoOfHour;
	@FXML
	private TextField tfPayHour;
	@FXML
	private TextArea taTaskDescription;
	@FXML
	private Button btnSearchTask;
	@FXML
	private Button btnAddTask;

	/* User ObservableList to fetch data to TableView or ChoiceBox, Combobox */
	final ObservableList<String> clientDrop = FXCollections.observableArrayList();
	final ObservableList<String> projectDrop = FXCollections.observableArrayList();

	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@FXML
	public void addClient(ActionEvent event) {
		try {
			String addClientQuery = "INSERT INTO CLIENT(Client_Name,Client_Address,Client_Email,Client_Phone) VALUES (?,?,?,?)";
			PreparedStatement prep = DBconnection.Connect().prepareStatement(addClientQuery);
			prep.setString(1, tfClientName.getText());
			prep.setString(2, taClientAddress.getText());
			prep.setString(3, tfClientEmail.getText());
			prep.setString(4, tfPhone.getText());
			prep.executeUpdate();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Add Client Successful");
			alert.showAndWait();

			// DBconnection.Connect().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void searchClient(ActionEvent event) {
		String ClientName = tfClientName.getText();
		ResultSet rs = DBconnection.Query("SELECT * FROM CLIENT WHERE Client_Name LIKE " + "'" + ClientName + "'");
		try {
			while (rs.next()) {
				tfClientName.setText(rs.getString("Client_Name"));
				taClientAddress.setText(rs.getString("Client_Address"));
				tfClientEmail.setText(rs.getString("Client_Email"));
				tfPhone.setText(rs.getString("Client_Phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * // Use this method to SELECT value from a table and Insert it into another
	 * table
	 * 
	 */
	@FXML
	public void addProject(ActionEvent event) {
		try {
			String getClientValue = chbClient.getSelectionModel().getSelectedItem();
			String selectClientIDQuery = "SELECT ID FROM CLIENT WHERE Client_Name = " + "'" + getClientValue + "'";
			String clientID = null;
			ResultSet rs = DBconnection.Query(selectClientIDQuery);
			String addProjectQuery = "INSERT INTO PROJECT(Project_Name,Project_Description,Client_ID) VALUES (?,?,?)";
			PreparedStatement prep = DBconnection.Connect().prepareStatement(addProjectQuery);
			while (rs.next()) {
				clientID = rs.getString("ID");
				prep.setString(1, tfProjectName.getText());
				prep.setString(2, taProjectDes.getText());
				prep.setString(3, clientID);
				prep.executeUpdate();
			}
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Thành công");
			alert.showAndWait();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@FXML
	public void searchProject(ActionEvent event) {
		try {
			String name = tfProjectName.getText();
			String query = "SELECT * FROM PROJECT WHERE Project_Name LIKE " + "'" + name + "'";
			ResultSet rs = DBconnection.Query(query);
			while (rs.next()) {
				tfProjectName.setText(rs.getString("Project_Name"));
				taProjectDes.setText(rs.getString("Project_Description"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void addTask(ActionEvent event) {
		try {
			// This is use to get SELECTED ITEM in CHOICEBOX
			String getProjectValue = chbProject.getSelectionModel().getSelectedItem();
			String selectProjectIDQuery = "SELECT ID FROM PROJECT WHERE Project_Name = " + "'" + getProjectValue + "'";
			String projectID = null;
			ResultSet rs = DBconnection.Query(selectProjectIDQuery);
			String addTaskQuery = "INSERT INTO TASK(Task_Name,Task_NoHour,Task_PayPerHours,Task_Status,Project_ID) VALUES (?,?,?,?,?)";
			PreparedStatement prep = DBconnection.Connect().prepareStatement(addTaskQuery);

			while (rs.next()) {
				projectID = rs.getString("ID");
				prep.setString(1, tfTaskName.getText());
				prep.setString(2, tfNoOfHour.getText());
				prep.setString(3, tfPayHour.getText());
				prep.setString(4, taTaskDescription.getText());
				prep.setString(5, projectID);
				prep.executeUpdate();
			}
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Add Client Successful");
			alert.showAndWait();

			DBconnection.Connect().close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void searchTask(ActionEvent event) {
		try {
			String name = tfTaskName.getText();
			String query = "SELECT * FROM TASK WHERE Task_Name LIKE " + "'" + name + "'";
			ResultSet rs = DBconnection.Query(query);
			while (rs.next()) {
				tfTaskName.setText(rs.getString("Task_Name"));
				tfNoOfHour.setText(rs.getString("Task_NoHour"));
				tfPayHour.setText(rs.getString("Task_PayPerHours"));
				taTaskDescription.setText(rs.getString("Task_Status"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		chbClient.setItems(clientDrop);
		try {
			String query = "SELECT * FROM CLIENT";
			ResultSet rs = DBconnection.Query(query);
			while (rs.next()) {
				clientDrop.add(rs.getString("Client_Name"));
			}
			DBconnection.Connect().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		chbProject.setItems(projectDrop);
		try {
			String query1 = "SELECT * FROM PROJECT";
			ResultSet rs1 = DBconnection.Query(query1);
			while (rs1.next()) {
				projectDrop.add(rs1.getString("Project_Name"));
			}
			DBconnection.Connect().close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
