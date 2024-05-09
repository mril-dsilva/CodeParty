package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.ViewTransitionModelInterface;
import server.ServerHandler;
import codeparty.Company;
import codeparty.JobPosting;

public class JobEditController {

    @FXML
    private TextField companyNameInput;

    @FXML
    private Button editButton;

    @FXML
    private TextField jobDescriptionInput;

    @FXML
    private TextField jobNameInput;

    ViewTransitionModelInterface model;
	JobPosting job;
    
    @FXML
    void onEditButtonClick(ActionEvent event) {
    	job.setCompanyID(companyNameInput.getText());
    	job.setName(jobNameInput.getText());
    	job.setBody(jobDescriptionInput.getText());
    	
    	ServerHandler.updateJobPostingObject(job);
    	model.showUser(job.getId());
    }
    
    public void setModel(ViewTransitionModelInterface model) {
    	this.model = model;
    }
    
    public void populateJob(String ID) {
    	job = ServerHandler.getJobPostingObject(ID);
    	jobNameInput.setText(job.getName());
    	Company c = ServerHandler.getCompanyObject(job.getCompanyID());
    	if (c != null) {
    		companyNameInput.setText(c.getName());
    	}
    	
    	jobDescriptionInput.setText(job.getBody());
    }

}

