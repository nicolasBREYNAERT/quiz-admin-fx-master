package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import qcm.models.pojo.Utilisateur;

public class EditController extends ModalController {

	@FXML
	private TextField txtNom;

	@FXML
	private TextField txtPrenom;

	@FXML
	private TextField txtEmail;
	
	@FXML
	private TextField txtLogin;
	
	@FXML
	private TextField txtPassword;
	
	@FXML
	private ComboBox cbRang;

	@FXML
	private Button btOkay;

	@FXML
	private Button btCancel;

	private Utilisateur user;

	public void setUser(Utilisateur user) {
		this.user = user;
		txtNom.setText(user.getNom());
		txtPrenom.setText(user.getPrenom());
		txtEmail.setText(user.getMail());
		txtLogin.setText(user.getLogin());
		txtPassword.setText(user.getPassword());
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			user.setNom(txtNom.getText());
			user.setPrenom(txtPrenom.getText());
			user.setMail(txtEmail.getText());
			user.setLogin(txtLogin.getText());
			user.setPassword(txtPassword.getText());
			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (txtNom.getText() == null || txtNom.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}
		if (txtPrenom.getText() == null || txtPrenom.getText().length() == 0) {
			errorMessage += "No valid last name!\n";
		}
		if (txtEmail.getText() == null || txtEmail.getText().length() == 0) {
			errorMessage += "No valid email!\n";
		}
		if (txtLogin.getText() == null || txtLogin.getText().length() == 0) {
			errorMessage += "No valid login!\n";
		}
		if (txtPassword.getText() == null || txtPassword.getText().length() == 0) {
			errorMessage += "No valid password!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}

}