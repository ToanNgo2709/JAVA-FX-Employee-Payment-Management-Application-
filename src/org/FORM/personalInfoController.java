package org.FORM;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class personalInfoController {
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
	private DatePicker DOB;
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

	@FXML
	public void uploadPersonalInfo() {

	}

	@FXML
	public void cancelWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

	@FXML
	public void uploadImage(ActionEvent event) {
		FileChooser imageChooser = new FileChooser();
		File image = imageChooser.showOpenDialog(null);
		if (image != null) {
			lblImagePath.setText(image.getAbsolutePath());
		}
	}

}
