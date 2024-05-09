package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.ViewTransitionModel;
import server.ServerHandler;
import codeparty.Company;
import codeparty.Person;
import codeparty.Skill;

public class CompanyController {

	ViewTransitionModel model;
	Company company;
	
	public void setModel(ViewTransitionModel model)
	{
		this.model=model;
	}
	
	public void populateCompany(String id) {
		company = ServerHandler.getCompanyObject(id);
		
		if(company!=null)
		{
			nameLabel.textProperty().set(company.getName());
			
			bioLabel.textProperty().set(company.getBio());
			
			taglineLabel.textProperty().set(company.getTagline());
			
		} else {
			nameLabel.textProperty().set("Invalid User");
			
			bioLabel.textProperty().set("You have encountered an error where the object you are loading is NULL. Please try again, and ensure the user is in the server system.");

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
    	model.showCompanyEdit(company.getId());
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
