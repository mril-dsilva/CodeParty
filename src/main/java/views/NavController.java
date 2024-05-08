package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import models.ViewTransitionModelInterface;

public class NavController {

	ViewTransitionModelInterface model;
	
	public void setModel(ViewTransitionModelInterface model) {
		this.model = model;
	}
	
    @FXML
    void onHomeClicked(ActionEvent event) {
    	model.showHome();
    }

    @FXML
    void onProfileClicked(ActionEvent event) {
    	model.showCurrentUser();
    }

}
