package views;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import models.ViewTransitionModelInterface;

public class NavController {

	ViewTransitionModelInterface model;
	
	public void setModel(ViewTransitionModelInterface model) {
		this.model = model;
	}
	
    @FXML
    private Button homeButton;

    @FXML
    private Button profileButton;
	
    @FXML
    void onHomeClicked(ActionEvent event) {
    	model.showHome();
    }

    @FXML
    void onProfileClicked(ActionEvent event) {
    	model.showCurrentUser();
    }

}
