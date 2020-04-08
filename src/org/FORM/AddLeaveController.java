package org.FORM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.MODELS.DBconnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddLeaveController {
	@FXML
	private RadioButton rdbHours;
	@FXML
	private RadioButton rdbDays;
	@FXML
	private TextField tfNoToRequest;
	@FXML
	private TextArea taReason;
	@FXML
	private Button btnRequest;
	@FXML
	private Button btnCancel;

	public String username;

	public void getUsername(String username1) {
		username = username1;
	}

	@FXML
	public void requestToAdmin(ActionEvent event) {
		try {
			String getID = "SELECT ID FROM EMPLOYEE WHERE Username LIKE " + "'" + username + "'";
			ResultSet rs = DBconnection.Query(getID);
			String sqlQuery = "INSERT INTO LEAVE(Type_Name,No_Hour,Reason,Leave_Status,Employee_ID) VALUES (?,?,?,?,?)";
			PreparedStatement prep = DBconnection.Connect().prepareStatement(sqlQuery);
			String type = null;
			if (rdbHours.isSelected()) {
				type = "Hours";
			} else if (rdbDays.isSelected()) {
				type = "Days";
			}
			while (rs.next()) {
				int id = rs.getInt("ID");
				prep.setString(1, type);
				prep.setFloat(2, Float.parseFloat(tfNoToRequest.getText()));
				prep.setString(3, taReason.getText());
				prep.setString(4, "No");
				prep.setInt(5, id);
				prep.executeUpdate();
			}
			Alert leaveConfirm = new Alert(AlertType.CONFIRMATION);
			leaveConfirm.setTitle("Notification");
			leaveConfirm.setContentText("Request succesful");
			leaveConfirm.showAndWait();
			DBconnection.Connect().close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

}
