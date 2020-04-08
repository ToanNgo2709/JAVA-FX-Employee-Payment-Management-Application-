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
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

	// *Use this to print content
	// */

	public void Print(ActionEvent event) {
		PrinterJob printerJob = PrinterJob.createPrinterJob();
		PageLayout layout = javafx.print.Printer.getDefaultPrinter().createPageLayout(Paper.A4,
				PageOrientation.LANDSCAPE, javafx.print.Printer.MarginType.HARDWARE_MINIMUM);

		if (printerJob.printPage(layout, myTable)) {
			printerJob.endJob();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			String query = "SELECT EMPLOYEE.ID,Name,Worktime,Offtime,Wage,Tax,Total FROM PAYMENT INNER JOIN EMPLOYEE ON PAYMENT.Employee_ID = EMPLOYEE.ID";
			ResultSet rs = DBconnection.Query(query);
			while (rs.next()) {
				oblist.add(new PaymentManagerTableModels(rs.getInt("ID"), rs.getString("Name"), rs.getFloat("Worktime"),
						rs.getFloat("Offtime"), rs.getFloat("Wage"), rs.getFloat("Tax"), rs.getFloat("Total")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colWorkTime.setCellValueFactory(new PropertyValueFactory<>("workTime"));
		colOfftime.setCellValueFactory(new PropertyValueFactory<>("offTime"));
		colWages.setCellValueFactory(new PropertyValueFactory<>("wages"));
		colTax.setCellValueFactory(new PropertyValueFactory<>("tax"));
		colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
		myTable.setItems(oblist);
	}
}
