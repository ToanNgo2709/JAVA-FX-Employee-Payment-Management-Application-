package org.FORM;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.DAO.LeaveHistoryTableModels;
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

public class LeaveHistoryController implements Initializable {
	@FXML
	private Button btnClose;
	@FXML
	private TableView<LeaveHistoryTableModels> myTable;

	@FXML
	private TableColumn<LeaveHistoryTableModels, String> colType;
	@FXML
	private TableColumn<LeaveHistoryTableModels, Float> colNoHour;
	@FXML
	private TableColumn<LeaveHistoryTableModels, String> colReason;
	@FXML
	private TableColumn<LeaveHistoryTableModels, String> colStatus;

	String username;

	public void getUsername(String username) {

	}

	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	ObservableList<LeaveHistoryTableModels> oblist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String username = "toan158n";
		String query = "SELECT * FROM EMPLOYEE WHERE Username = " + "'" + username + "'";
		ResultSet r2 = DBconnection.Query(query);

		try {
			while (r2.next()) {
				int id = r2.getInt("ID");
				ResultSet rs = DBconnection.Query("SELECT * FROM LEAVE WHERE Employee_ID =" + id);
				while (rs.next()) {
					oblist.add(new LeaveHistoryTableModels(rs.getString("Type_Name"), rs.getString("Reason"),
							rs.getString("Leave_Status"), rs.getFloat("No_Hour")));
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		colType.setCellValueFactory(new PropertyValueFactory<>("type"));
		colNoHour.setCellValueFactory(new PropertyValueFactory<>("noHour"));
		colReason.setCellValueFactory(new PropertyValueFactory<>("reason"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		myTable.setItems(oblist);

	}
}
