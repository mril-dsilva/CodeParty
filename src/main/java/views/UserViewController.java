package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.ViewTransitionModel;
import server.JobRecommender;
import server.ServerHandler;
import codeparty.JobPosting;
import codeparty.Person;
import codeparty.Skill;

	public class UserViewController {

		ViewTransitionModel model;
		Person person;
		
		public void setModel(ViewTransitionModel model)
		{
			this.model=model;
		}
		
		public void populateUser(String id) {
			person = ServerHandler.getPersonObject(id);
			
			if(person!=null)
			{
				nameLabel.textProperty().set(person.getName());
				
				bioLabel.textProperty().set(person.getBio());
				
				roleLabel.textProperty().set((person.getCurrentCompany()).getJobTitle());
				
			} else {
				nameLabel.textProperty().set("Invalid User");
				
				bioLabel.textProperty().set("You have encountered an error where the Person object you are loading is NULL. Please try again, and ensure the user is in the server system.");
				
				roleLabel.textProperty().set("error");
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
	    private Button jobsListButton;
	    
	    @FXML
	    void onEditButtonClick(ActionEvent event) {
	    	model.showUserEdit(person.getId());
	    }

	    @FXML
	    void onFriendsListClick(ActionEvent event) {
	    	model.showListOfLinks(person, Person.class);
	    }
	    
	    @FXML
	    void onJobsListClick(ActionEvent event) {
	    	JobRecommender jobRecommender = new JobRecommender();
			jobRecommender.recommendJobs(person);
			
			model.showListOfLinks(person, JobPosting.class);
	    }
	    
	    @FXML
	    void onProjectsListClick(ActionEvent event) {
	    	
	    }

	    @FXML
	    void onSkillsListClick(ActionEvent event) {
	    	model.showListOfLinks(person, Skill.class);
	    }

	}


