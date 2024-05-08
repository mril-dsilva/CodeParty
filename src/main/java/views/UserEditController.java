package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.ViewTransitionModelInterface;
import models.pages.Person;

public class UserEditController {

	ViewTransitionModelInterface model;
	Person person;
	
    @FXML
    private TextField bioText;

    @FXML
    private Button editButton;

    @FXML
    private TextField nameText;

    @FXML
    private TextField roleText;

    @FXML
    void onEditButtonClick(ActionEvent event) {
    	person.setBio(bioText.getText());
    	person.setName(nameText.getText());
    	person.getCurrentCompany().setJobTitle(roleText.getText());
    	
    	model.showUser(person.getID());
    }
    
    public void setModel(ViewTransitionModelInterface model) {
    	this.model = model;
    }
    
    public void populateUser(String ID) {
    	person = (Person) model.getObject(ID);
    	
    	nameText.setText(person.getName());
    	roleText.setText(person.getCurrentCompany().getJobTitle());
    	bioText.setText(person.getBio());
    }

}