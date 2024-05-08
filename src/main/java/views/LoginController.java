package views;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import models.LoginModel;
import models.ViewTransitionModelInterface;


public class LoginController {

	@FXML
    private TextField passText;
	
    @FXML
    private TextField userText;
	
	LoginModel model;
	ViewTransitionModelInterface transitionModel;
	
	public void setModels(LoginModel model, ViewTransitionModelInterface transitionModel) {
		this.model = model;
		this.transitionModel = transitionModel;
	}
	
    @FXML
    void onSubmit(ActionEvent event) {
    	String username = userText.getText();
    	String password = passText.getText();
    	System.out.println("Transitioning");
    	if(model.attemptLogin(username, password)) {
    		
    		transitionModel.setCurrentUserID("123");
    		transitionModel.showCurrentUserFromLogin();
    	}else {
    		
    	}
    }
    
    
}
