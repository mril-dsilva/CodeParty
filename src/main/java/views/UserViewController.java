package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.ViewTransitionModel;
import models.pages.Person;
import models.pages.Skill;

	public class UserViewController {

		ViewTransitionModel model;
		Person person;
		
		public void setModel(ViewTransitionModel model)
		{
			this.model=model;
		}
		
		public void populateUser(String id) {
			person = (Person)model.getObject(id);
			
			if(person!=null)
			{
				nameLabel.textProperty().set(person.getName());
				
				bioLabel.textProperty().set(person.getBio());
				
				roleLabel.textProperty().set((person.getCurrentCompany()).getJobTitle());
				
			}
			
			if(!model.canEdit(person)) {
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
	    private Label roleLabel;

	    @FXML
	    private Button skillsListButton;

	    @FXML
	    void onEditButtonClick(ActionEvent event) {
	    	model.showUserEdit(person.getID());
	    }

	    @FXML
	    void onFriendsListClick(ActionEvent event) {
	    	model.showListOfLinks(person, Person.class);
	    }

	    @FXML
	    void onProjectsListClick(ActionEvent event) {
	    	
	    }

	    @FXML
	    void onSkillsListClick(ActionEvent event) {
	    	model.showListOfLinks(person, Skill.class);
	    }

	}


