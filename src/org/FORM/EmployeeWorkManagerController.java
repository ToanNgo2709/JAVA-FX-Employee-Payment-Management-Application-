package org.FORM;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.DAO.ManagerWorkTableModel;
import org.MODELS.DBconnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EmployeeWorkManagerController implements Initializable {
	@FXML
	private Button btnUpdate;
	@FXML
	private Button btnCancel;
	@FXML
	private TableView<ManagerWorkTableModel> myTable;
	@FXML
	private TableColumn<ManagerWorkTableModel, String> colClient;
	@FXML
	private TableColumn<ManagerWorkTableModel, String> colProject;
	@FXML
	private TableColumn<ManagerWorkTableModel, String> colTask;
	@FXML
	private TableColumn<ManagerWorkTableModel, Float> colNoHour;
	@FXML
	private TableColumn<ManagerWorkTableModel, String> colComment;
	@FXML
	private TableColumn<ManagerWorkTableModel, String> colStatus;

	ObservableList<ManagerWorkTableModel> oblist = FXCollections.observableArrayList();

	@FXML
	public void Update(ActionEvent event) {

	}

	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			String query = "SELECT * FROM CLIENT INNER JOIN PROJECT ON CLIENT.ID = PROJECT.Client_ID INNER JOIN TASK ON PROJECT.ID = TASK.Project_ID";
			ResultSet rs = DBconnection.Query(query);
			while (rs.next()) {
				oblist.add(new ManagerWorkTableModel(rs.getString("Client_Name"), rs.getString("Project_name"),
						rs.getString("Task_Name"), rs.getString("Task_Comment"), rs.getString("Task_Status"),
						rs.getFloat("Task_NoHour")));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		colClient.setCellValueFactory(new PropertyValueFactory<>("client_name"));
		colProject.setCellValueFactory(new PropertyValueFactory<>("project_name"));
		colTask.setCellValueFactory(new PropertyValueFactory<>("task_name"));
		colNoHour.setCellValueFactory(new PropertyValueFactory<>("noOfHour"));
		colComment.setCellValueFactory(new PropertyValueFactory<>("comment"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		myTable.setItems(oblist);
	}
}
