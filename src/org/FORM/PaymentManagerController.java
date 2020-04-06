package org.FORM;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.DAO.PaymentManagerTableModels;
import org.MODELS.DBconnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class PaymentManagerController implements Initializable {
	@FXML
	private Button btnPrint;
	@FXML
	private Button btnClose;
	@FXML
	private TableView<PaymentManagerTableModels> myTable;
	@FXML
	private TableColumn<PaymentManagerTableModels, String> colId;
	@FXML
	private TableColumn<PaymentManagerTableModels, String> colName;
	@FXML
	private TableColumn<PaymentManagerTableModels, Float> colWorkTime;
	@FXML
	private TableColumn<PaymentManagerTableModels, Float> colOfftime;
	@FXML
	private TableColumn<PaymentManagerTableModels, Float> colWages;
	@FXML
	private TableColumn<PaymentManagerTableModels, Float> colTax;
	@FXML
	private TableColumn<PaymentManagerTableModels, Float> colTotal;
	@FXML
	private TableColumn<PaymentManagerTableModels, String> colApprove;

	ObservableList<PaymentManagerTableModels> oblist = FXCollections.observableArrayList();

	public void closeWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	public void Print(ActionEvent event) {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			String query = "SELECT * FROM PAYMENT";
			ResultSet rs = DBconnection.Query(query);
			while (rs.next()) {

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
