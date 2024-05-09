package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import models.ViewTransitionModel;
import server.ServerHandler;
import codeparty.Company;
import codeparty.JobPosting;

public class JobController {

    @FXML
    private Button applyButton;

    @FXML
    private Button editButton;

    @FXML
    private Label jobCompanyLabel;

    @FXML
    private Label jobDescriptionLabel;

    @FXML
    private Label jobNameLabel;

    @FXML
    void onEditButtonClick(ActionEvent event) {
    	model.showJobPostingEdit(job.getId());
    }
    
    ViewTransitionModel model;
	JobPosting job;
	
	public void setModel(ViewTransitionModel model)
	{
		this.model=model;
	}
	
	public void populateJob(String id) {
		job = ServerHandler.getJobPostingObject(id);
		
		if(job!=null)
		{
			jobNameLabel.textProperty().set(job.getName());
			
			jobDescriptionLabel.textProperty().set(job.getBody());
			
			jobCompanyLabel.textProperty().set(((Company)model.getObject(job.getCompanyID())).getName()); //SEEMS LIKE THERE NEEDS TO BE A FIX HERE TO WORK WITH REStseRVER
			
		} else {
			jobNameLabel.textProperty().set("Invalid User");
			
			jobDescriptionLabel.textProperty().set("You have encountered an error where the object you are loading is NULL. Please try again, and ensure the user is in the server system.");
			
			jobCompanyLabel.textProperty().set("error");
		}
		
		if(!model.canEdit(job)) {
			editButton.setVisible(false);
		} 
		
	}

}

