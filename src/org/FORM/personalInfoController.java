package org.FORM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public String usernameInfo;

	public String getUsernameInfo() {
		return usernameInfo;
	}

	public void setUsernameInfo(String usernameInfo) {
		this.usernameInfo = usernameInfo;
	}

	@Override
	public void initialize(URL location, ResourceBundle resourceBundle) {

	}

	public void InitDB() {
		try {
			String query = "SELECT * FROM EMPLOYEE WHERE Username LIKE " + "'" + getUsernameInfo() + "'";
			ResultSet rs = DBconnection.Query(query);
			while (rs.next()) {
				tfEmployeeID.setText(rs.getString("ID"));
				tfUsername.setText(rs.getString("Username"));
				tfName.setText(rs.getString("Name"));
				pfPW.setText(rs.getString("PW"));
				tfDOB.setText(rs.getString("DOB"));
				taPerAdd.setText(rs.getString("Permanent_Address"));
				taCurAdd.setText(rs.getString("Current_Address"));
				tfPhone.setText(rs.getString("Phone"));
				tfEmail.setText(rs.getString("Email"));

				// retrieve image
				InputStream input = rs.getBinaryStream("Image");
				InputStreamReader inputReader = new InputStreamReader(input);
				if (inputReader.ready()) {
					File tempFile = new File("tempFile.jpg");
					@SuppressWarnings("resource")
					FileOutputStream fos = new FileOutputStream(tempFile);
					byte[] buffer = new byte[1024];
					while (input.read(buffer) > 0) {
						fos.write(buffer);
					}
					Image image = new Image(tempFile.toURI().toURL().toString());
					imgviImage.setImage(image);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void showPersonalInFo(ActionEvent event) {
		String query = "SELECT * FROM EMPLOYEE WHERE Username LIKE " + "'" + getUsernameInfo() + "'";
		ResultSet rs = DBconnection.Query(query);
		try {
			while (rs.next()) {
				tfEmployeeID.setText(rs.getString("ID"));
				tfName.setText(rs.getString("Name"));
				pfPW.setText(rs.getString("PW"));
				tfUsername.setText(rs.getString("Username"));
				tfDOB.setText(rs.getString("DOB"));
				taPerAdd.setText(rs.getString("Permanent_Address"));
				taCurAdd.setText(rs.getString("Current_Address"));
				tfPhone.setText(rs.getString("Phone"));
				tfEmail.setText(rs.getString("Email"));

				// retrive image
				InputStream input = rs.getBinaryStream("Image");
				InputStreamReader inputReader = new InputStreamReader(input);
				if (inputReader.ready()) {
					File tempFile = new File("tempFile.jpg");
					@SuppressWarnings("resource")
					FileOutputStream fos = new FileOutputStream(tempFile);
					byte[] buffer = new byte[1024];
					while (input.read(buffer) > 0) {
						fos.write(buffer);
					}
					Image image = new Image(tempFile.toURI().toURL().toString());
					imgviImage.setImage(image);
				}

				DBconnection.Connect().close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@FXML
	public void uploadPersonalInfo(ActionEvent event) throws FileNotFoundException {
		String query = "SELECT * FROM EMPLOYEE WHERE Username = " + "'" + this.usernameInfo + "'";
		ResultSet rs = DBconnection.Query(query);
		try {
			while (rs.next()) {
				int id = rs.getInt("ID");
				String update = "UPDATE EMPLOYEE SET Name = ?,DOB =?,Permanent_Address=?,Current_Address=?,Phone = ?,Email = ?,Image = ?,Approve_status = 'Yes' WHERE ID = "
						+ id;
				PreparedStatement prep = DBconnection.Connect().prepareStatement(update);
				prep.setString(1, tfName.getText());
				prep.setString(2, tfDOB.getText());
				prep.setString(3, taPerAdd.getText());
				prep.setString(4, taCurAdd.getText());
				prep.setString(5, tfPhone.getText());
				prep.setString(6, tfEmail.getText());

				FileChooser imageChooser = new FileChooser();
				File imageFile = imageChooser.showOpenDialog(null);
				Image image = new Image(imageFile.toURI().toString());
				imgviImage.setImage(image);
				// INSERT IMAGE
				fis = new FileInputStream(imageFile);
				prep.setBinaryStream(7, fis);
				prep.executeUpdate();
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Thành công");
				alert.showAndWait();

			}

			DBconnection.Connect().close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@FXML
	public void cancelWindow(ActionEvent event) {
		((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
	}

}
