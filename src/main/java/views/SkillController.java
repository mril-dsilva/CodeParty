package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.ViewTransitionModel;
import models.pages.Person;
import models.pages.Skill;

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
    	model.showSkillEdit(skill.getID());
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
		skill = (Skill)model.getObject(id);
		
		if(skill!=null)
		{
			skillNameLabel.textProperty().set(skill.getName());
			
			bioLabel.textProperty().set(skill.getBio());
			
			taglineLabel.textProperty().set(skill.getTagline());
			
		}
		
		if(!model.canEdit(skill)) {
			editButton.setVisible(false);
		}
		
	}

}