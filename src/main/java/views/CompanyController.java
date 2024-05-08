package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.ViewTransitionModel;
import models.pages.Company;
import models.pages.Person;
import models.pages.Skill;

public class CompanyController {

	ViewTransitionModel model;
	Company company;
	
	public void setModel(ViewTransitionModel model)
	{
		this.model=model;
	}
	
	public void populateCompany(String id) {
		company = (Company)model.getObject(id);
		
		if(company!=null)
		{
			nameLabel.textProperty().set(company.getName());
			
			bioLabel.textProperty().set(company.getBio());
			
			taglineLabel.textProperty().set(company.getTagline());
			
		}
		
		if(!model.canEdit(company)) {
			editButton.setVisible(false);
		}
		
	}
	

	
	 @FXML
	    private Label bioLabel;

	    @FXML
	    private Button editButton;

	    @FXML
	    private Button friendsListButton;

	    @FXML
	    private Label nameLabel;

	    @FXML
	    private Button projectsListButton;

	    @FXML
	    private Button skillsListButton;

	    @FXML
	    private Label taglineLabel;


    @FXML
    void onEditButtonClick(ActionEvent event) {
    	model.showCompanyEdit(company.getID());
    }

    @FXML
    void onFriendsListClick(ActionEvent event) {
    	model.showListOfLinks(company, Person.class);
    }

    @FXML
    void onProjectsListClick(ActionEvent event) {
    	
    }

    @FXML
    void onSkillsListClick(ActionEvent event) {
    	model.showListOfLinks(company, Skill.class);
    }

}
