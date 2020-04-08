package org.FORM;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.DAO.LeaveManagerTableModels;
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

public class LeaveManagerController implements Initializable {
	@FXML
	private TableView<LeaveManagerTableModels> myTable;
	@FXML
	private TableColumn<LeaveManagerTableModels, Integer> colID;
	@FXML
	private TableColumn<LeaveManagerTableModels, String> colName;
	@FXML
	private TableColumn<LeaveManagerTableModels, String> colType;
	@FXML
	private TableColumn<LeaveManagerTableModels, Float> colNoHour;
	@FXML
	private TableColumn<LeaveManagerTableModels, String> colReason;
	@FXML
	private Button btnOpenRowInfo;
	@FXML
	private Button btnCancel;

	ObservableList<LeaveManagerTableModels> oblist = FXCollections.observableArrayList();

	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@FXML
	public void confirmRequest(ActionEvent event) {
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			String query = "SELECT Employee_ID,Name,Type_Name,Reason,No_Hour FROM LEAVE INNER JOIN EMPLOYEE ON LEAVE.Employee_ID = EMPLOYEE.ID ";
			ResultSet rs = DBconnection.Query(query);
			while (rs.next()) {
				oblist.add(new LeaveManagerTableModels(rs.getInt("Employee_ID"), rs.getString("Name"),
						rs.getString("Type_Name"), rs.getString("Reason"), rs.getFloat("No_Hour")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		colID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colType.setCellValueFactory(new PropertyValueFactory<>("type"));
		colReason.setCellValueFactory(new PropertyValueFactory<>("reason"));
		colNoHour.setCellValueFactory(new PropertyValueFactory<>("noHour"));
		myTable.setItems(oblist);
	}

}
