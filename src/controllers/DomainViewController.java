package controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import qcm.models.pojo.Utilisateur;
import qcm.models.pojo.Domaine;

public class DomainViewController extends AbstractController {
	@FXML
    private TableView<Domaine> domainTable;

    @FXML
    private TableColumn<Domaine, String> domain;

    @FXML
    private Label libelleLabel;
   
    @FXML
	private void initialize() {
    	// Initialize the domain table
    	domain.setCellValueFactory((CellDataFeatures<Domaine, String> feature) -> {
			Utilisateur domain = feature.getValue();
			return new SimpleObjectProperty<>(domain.getLibelle());
		});
    }
    public DomainViewController() {
		// TODO Auto-generated constructor stub
	}
}
