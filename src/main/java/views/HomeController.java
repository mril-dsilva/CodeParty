package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import models.ViewTransitionModelInterface;
import models.pages.Company;
import models.pages.JobPosting;
import models.pages.Person;
import models.pages.Skill;

public class HomeController {

	ViewTransitionModelInterface model;
	
    public void setModel(ViewTransitionModelInterface model) {
    	this.model = model;
    }
	
    @FXML
    void onCompaniesClick(ActionEvent event) {
    	model.showListOfAll(Company.class);
    }

    @FXML
    void onJobsClick(ActionEvent event) {
    	model.showListOfAll(JobPosting.class);
    }

    @FXML
    void onPeopleClick(ActionEvent event) {
    	model.showListOfAll(Person.class);
    }

    @FXML
    void onProjectsClick(ActionEvent event) {
    	System.out.println("Projects Clicked");
    }

    @FXML
    void onSkillsClick(ActionEvent event) {
    	model.showListOfAll(Skill.class);
    }
   
}