package org.FORM;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.DAO.SeePaymentTableModels;
import org.MODELS.DBconnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SeePaymentController implements Initializable {
	@FXML
	private Button btnConfirm;
	@FXML
	private Button btnClose;
	@FXML
	private TextField tfOfftime;
	@FXML
	private TextField tfWages;
	@FXML
	private TextField tfTax;
	@FXML
	private TextField tfToTal;
	@FXML
	private TableView<SeePaymentTableModels> myTable;
	@FXML
	private TableColumn<SeePaymentTableModels, String> colClient;
	@FXML
	private TableColumn<SeePaymentTableModels, String> colProject;
	@FXML
	private TableColumn<SeePaymentTableModels, String> colTask;
	@FXML
	private TableColumn<SeePaymentTableModels, Float> colWorkHour;
	@FXML
	private TableColumn<SeePaymentTableModels, Integer> colPayHour;

	ObservableList<SeePaymentTableModels> oblist = FXCollections.observableArrayList();

	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	float wages = 0;
	float workTime = 0;
	String username;

	public void getUsername(String username1) {
		username = username1;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String username = "toan158n";
		String query = "SELECT * FROM EMPLOYEE WHERE Username =" + "'" + username + "'";
		ResultSet rs2 = DBconnection.Query(query);
		try {
			while (rs2.next()) {
				int id = rs2.getInt("ID");
				String retriveDB = "SELECT * FROM CLIENT INNER JOIN PROJECT ON CLIENT.ID = PROJECT.Client_ID INNER JOIN TASK ON PROJECT.ID = TASK.Project_ID WHERE TASK.Employee_ID ="
						+ id;
				ResultSet rs = DBconnection.Query(retriveDB);
				while (rs.next()) {
					oblist.add(new SeePaymentTableModels(rs.getString("Client_Name"), rs.getString("Project_Name"),
							rs.getString("Task_Name"), rs.getFloat("Task_NoHour"), rs.getInt("Task_PayPerHours")));
					wages += (rs.getFloat("Task_NoHour") * rs.getInt("Task_PayPerHours"));
					workTime += rs.getFloat("Task_NoHour");
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tfWages.setText(Float.toString(wages));
		float tax = (wages / 100) * 10;
		tfTax.setText(Float.toString(tax));
		float total = wages - tax;
		tfToTal.setText(Float.toString(total));
		colClient.setCellValueFactory(new PropertyValueFactory<>("client_name"));
		colProject.setCellValueFactory(new PropertyValueFactory<>("project_name"));
		colTask.setCellValueFactory(new PropertyValueFactory<>("task_name"));
		colWorkHour.setCellValueFactory(new PropertyValueFactory<>("workHour"));
		colPayHour.setCellValueFactory(new PropertyValueFactory<>("payHour"));
		myTable.setItems(oblist);

		try {
			String query2 = "SELECT * FROM EMPLOYEE WHERE Username = " + "'" + username + "'";
			ResultSet rs3 = DBconnection.Query(query2);
			while (rs3.next()) {
				int id = rs3.getInt("ID");
				String retriveLeave = "SELECT * FROM LEAVE WHERE Employee_ID =" + id;
				ResultSet rs = DBconnection.Query(retriveLeave);
				float time = 0;
				while (rs.next()) {
					time += rs.getFloat("No_Hour");
				}
				tfOfftime.setText(Float.toString(time));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void confirmSendToAdmin(ActionEvent event) {
		String query = "SELECT * FROM EMPLOYEE WHERE Username = " + "'" + username + "'";
		ResultSet rs = DBconnection.Query(query);
		String insertToPayment = "INSERT INTO PAYMENT(Wage,Tax,Total,Offtime,Worktime,Employee_ID) VALUES (?,?,?,?,?,?)";

		try {
			while (rs.next()) {
				int id = rs.getInt("ID");
				PreparedStatement prep = DBconnection.Connect().prepareStatement(insertToPayment);
				prep.setFloat(1, Float.parseFloat(tfWages.getText()));
				prep.setFloat(2, Float.parseFloat(tfTax.getText()));
				prep.setFloat(3, Float.parseFloat(tfToTal.getText()));
				prep.setFloat(4, Float.parseFloat(tfOfftime.getText()));
				prep.setFloat(5, workTime);
				prep.setInt(6, id);
				prep.executeUpdate();
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Do you want to confirm it to Admin");
				alert.showAndWait();

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
