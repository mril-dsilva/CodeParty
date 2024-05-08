package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.ViewTransitionModelInterface;
import models.pages.Company;

public class CompanyEditController {

	ViewTransitionModelInterface model;
	Company company;
	
    @FXML
    private TextField bioText;

    @FXML
    private Button editButton;

    @FXML
    private TextField nameText;

    @FXML
    private TextField taglineText;
    
    @FXML
    void onEditButtonClick(ActionEvent event) {
    	company.setBio(bioText.getText());
    	company.setName(nameText.getText());
    	company.setTagline(taglineText.getText());
    	
    	model.showUser(company.getID());
    }
    
    public void setModel(ViewTransitionModelInterface model) {
    	this.model = model;
    }
    
    public void populateCompany(String ID) {
    	company = (Company) model.getObject(ID);
    	
    	nameText.setText(company.getName());
    	taglineText.setText(company.getTagline());
    	bioText.setText(company.getBio());
    }

}
