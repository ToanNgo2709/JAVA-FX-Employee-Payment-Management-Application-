package org.FORM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class personalInfoController implements Initializable {
	@FXML
	private TextField tfEmployeeID;
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfUsername;
	@FXML
	private TextField tfPhone;
	@FXML
	private TextField tfEmail;
	@FXML
	private PasswordField pfPW;
	@FXML
	private TextField tfDOB;
	@FXML
	private TextArea taPerAdd;
	@FXML
	private TextArea taCurAdd;
	@FXML
	private Button btnUpload;
	@FXML
	private Button btnUploadImage;
	@FXML
	private Button btnCancel;
	@FXML
	private Label lblImagePath;
	@FXML
	private ImageView imgviImage;
	private FileInputStream fis;

	@FXML
	public void uploadPersonalInfo(ActionEvent event) throws FileNotFoundException {
		try {
			String sqlQuery = "INSERT INTO EMPLOYEE(ID,Name,Username,PW,DOB,Permanent_Address,Current_Address,Phone,Email,Image,Approve_status) VALUES (?,?,?,?,?,?,?,?,?,?,'Yes')";
			PreparedStatement prep = DBconnection.Connect().prepareStatement(sqlQuery);
			prep.setString(1, tfEmployeeID.getText());
			prep.setString(2, tfName.getText());
			prep.setString(3, tfUsername.getText());
			prep.setString(4, pfPW.getText());
			prep.setString(5, tfDOB.getText());
			prep.setString(6, taPerAdd.getText());
			prep.setString(7, taCurAdd.getText());
			prep.setString(8, tfPhone.getText());
			prep.setString(9, tfEmail.getText());

			// INSERT IMAGE
			fis = new FileInputStream(uploadImage(event));
			prep.setBinaryStream(10, fis);

			prep.executeUpdate();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Thành công");
			alert.showAndWait();
			DBconnection.Connect().close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void cancelWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@FXML
	public File uploadImage(ActionEvent event) {
		FileChooser imageChooser = new FileChooser();
		File imageFile = imageChooser.showOpenDialog(null);
		if (imageFile != null) {
			lblImagePath.setText(imageFile.getAbsolutePath());
			Image image = new Image(imageFile.toURI().toString());
			imgviImage.setImage(image);
		}
		return imageFile;

	}

//	public void initData(LoginPersonalInfoParseData person) {
//		loginedPerson = person;
//		tfEmployeeID.setText(loginedPerson.getEmID());
//		tfUsername.setText(loginedPerson.getUserName());
//		pfPW.setText(loginedPerson.getPw());
//
//	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
