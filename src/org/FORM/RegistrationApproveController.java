package org.FORM;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.MODELS.DBconnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationApproveController implements Initializable {
	@FXML
	private Button btnRegApp;
	@FXML
	private Button btnCancel;
	@FXML
	private TextField tfEmID;
	@FXML
	private TextField tfUsername;
	@FXML
	private TextField tfPW;
	@FXML
	private CheckBox ckbStatus;
	@FXML
	private Button btnDelete;

	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@FXML
	public void registrationApprove(ActionEvent event) throws SQLException {
		String status;
		if (ckbStatus.isSelected()) {
			status = "Yes";
		} else {
			status = "No";
		}
		String updateQuery = "update EMPLOYEE set Approve_status = ? where ID = ?";
		PreparedStatement prep = DBconnection.Connect().prepareStatement(updateQuery);
		prep.setString(1, status);
		prep.setString(2, tfEmID.getText());
		prep.executeUpdate();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("successful");
		alert.showAndWait();
		DBconnection.Connect().close();
	}

	@FXML
	public void deleteRegistration(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Are you sure to delete this user");
		alert.showAndWait();
		if (alert.getResult() == ButtonType.YES) {
			try {

				String query = "DELETE FROM EMPLOYEE WHERE ID = ?";
				PreparedStatement prep = DBconnection.Connect().prepareStatement(query);
				prep.setString(1, tfEmID.getText());
				prep.execute();
				DBconnection.Connect().close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public void registrationApprove(String id, String username, String pw, String status) {
		// TODO Auto-generated method stub
		tfEmID.setText(id);
		tfUsername.setText(username);
		tfPW.setText(pw);
		if (status.equals("Yes")) {
			ckbStatus.setSelected(true);
		} else {
			ckbStatus.setSelected(false);
		}

	}

}
