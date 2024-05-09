package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.ViewTransitionModel;
import server.ServerHandler;
import codeparty.Person;
import codeparty.Skill;

public class SkillController {

    @FXML
    private Label bioLabel;

    @FXML
    private Button editButton;

    @FXML
    private Button friendsListButton;

    @FXML
    private Button projectsListButton;

    @FXML
    private Label skillNameLabel;

    @FXML
    private Button skillsListButton;

    @FXML
    private Label taglineLabel;

    @FXML
    void onEditButtonClick(ActionEvent event) {
    	model.showSkillEdit(skill.getId());
    }

    @FXML
    void onFriendsListClick(ActionEvent event) {
    	model.showListOfLinks(skill, Person.class);
    }

    @FXML
    void onProjectsListClick(ActionEvent event) {

    }

    @FXML
    void onSkillsListClick(ActionEvent event) {
    	model.showListOfLinks(skill, Skill.class);
    }
    
    ViewTransitionModel model;
	Skill skill;
	
	public void setModel(ViewTransitionModel model)
	{
		this.model=model;
	}
	
	public void populateSkill(String id) {
		skill = ServerHandler.getSkillObject(id);
		
		if(skill!=null)
		{
			skillNameLabel.textProperty().set(skill.getName());
			
			bioLabel.textProperty().set(skill.getBio());
			
			taglineLabel.textProperty().set(skill.getTagline());
			
		} else {
			skillNameLabel.textProperty().set("Invalid User");
			
			bioLabel.textProperty().set("You have encountered an error where the object you are loading is NULL. Please try again, and ensure the user is in the server system.");
			
			taglineLabel.textProperty().set("error");
		}
		
		if(!model.canEdit(skill)) {
			editButton.setVisible(false);
		} 
		
	}

}