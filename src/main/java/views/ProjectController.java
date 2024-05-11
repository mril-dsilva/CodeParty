package views;

import codeparty.Person;
import codeparty.Project;
import codeparty.Skill;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.ViewTransitionModel;
import server.ServerHandler;

public class ProjectController {
	
	ViewTransitionModel model;
	Project project;
	
	public void setModel(ViewTransitionModel model)
	{
		this.model=model;
	}
	
	public void populateProject(String id) {
		project = ServerHandler.getProjectObject(id);
		
		if(project!=null)
		{
			nameLabel.textProperty().set(project.getName());
			
			bioLabel.textProperty().set(project.getBio());
			
			taglineLabel.textProperty().set(project.getTagline());
			
		} else {
			nameLabel.textProperty().set("Invalid User");
			
			bioLabel.textProperty().set("You have encountered an error where the object you are loading is NULL. Please try again, and ensure the user is in the server system.");

		}
		
		if(!model.canEdit(project)) {
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
    private Button skillsListButton;

    @FXML
    private Label taglineLabel;

    @FXML
    void onEditButtonClick(ActionEvent event) {
    	model.showProjectEdit(project.getId());
    }

    @FXML
    void onFriendsListClick(ActionEvent event) {
    	model.showListOfLinks(project, Person.class);
    }

    @FXML
    void onSkillsListClick(ActionEvent event) {
    	model.showListOfLinks(project, Skill.class);
    }

}