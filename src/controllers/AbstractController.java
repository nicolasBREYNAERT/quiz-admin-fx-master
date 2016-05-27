package controllers;

import application.Main;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public abstract class AbstractController {
	protected Main mainApp;

	protected Stage dialogStage;
	protected boolean okClicked = false;
	
	public AbstractController() {

	}

	public Main getMainApp() {
		return mainApp;
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
	
	/**
	 * Initializes the controller class. This method is automatically called after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Sets the stage of this dialog.
	 *
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 *
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

}
