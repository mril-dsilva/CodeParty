package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import models.ViewTransitionModelInterface;
import codeparty.Company;
import codeparty.JobPosting;
import codeparty.Person;
import codeparty.Project;
import codeparty.Skill;

public class HomeController {

	ViewTransitionModelInterface model;
	
    public void setModel(ViewTransitionModelInterface model) {
    	this.model = model;
    }
    @FXML
    private Button companiesAll;

    @FXML
    private Button jobsAll;

    @FXML
    private Button peopleAll;

    @FXML
    private Button projectsAll;

    @FXML
    private Button skillsAll;

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
    	model.showListOfAll(Project.class);
    	System.out.println("Projects Clicked");
    }

    @FXML
    void onSkillsClick(ActionEvent event) {
    	model.showListOfAll(Skill.class);
    }
   
}