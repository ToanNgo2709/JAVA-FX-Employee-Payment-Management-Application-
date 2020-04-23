package org.FORM;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.DAO.RegistrationManagerTableModels;
import org.MODELS.DBconnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RegistrationManagerController implements Initializable {
	@FXML
	private Button btnClose;
	@FXML
	private Button btnOpenRow;
	@FXML
	private Button btnRefresh;
	@FXML
	private TableView<RegistrationManagerTableModels> myTable;
	@FXML
	private TableColumn<RegistrationManagerTableModels, String> colEmID;
	@FXML
	private TableColumn<RegistrationManagerTableModels, String> colUsername;
	@FXML
	private TableColumn<RegistrationManagerTableModels, String> colPassword;
	@FXML
	private TableColumn<RegistrationManagerTableModels, String> colStatus;

	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	ObservableList<RegistrationManagerTableModels> oblist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			ResultSet rs = DBconnection.Query("SELECT ID,Username,PW,Approve_status FROM EMPLOYEE");
			while (rs.next()) {
				oblist.add(new RegistrationManagerTableModels(rs.getString("ID"), rs.getString("Username"),
						rs.getString("PW"), rs.getString("Approve_status")));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		colEmID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
		colPassword.setCellValueFactory(new PropertyValueFactory<>("pw"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		myTable.setItems(oblist);
	}

	@FXML
	private void refreshTable(ActionEvent event) {
		myTable.refresh();

	}

	@FXML
	private void openRegistrationApprove(ActionEvent event) {

		// TODO Auto-generated method stub
		RegistrationManagerTableModels reg = myTable.getItems().get(myTable.getSelectionModel().getSelectedIndex());
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrationApproveForm.fxml"));
		try {
			Parent root = (Parent) loader.load();
			RegistrationApproveController controller = loader.getController();
			controller.registrationApprove(reg.getId(), reg.getUsername(), reg.getPw(), reg.getStatus());
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
