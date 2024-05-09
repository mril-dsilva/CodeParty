package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.ViewTransitionModelInterface;
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
    	if(model.getObject(companyNameInput.getText()) != null) {
    		job.setCompanyID(companyNameInput.getText()); //FIX NEEDED HERE TO IMPLEMENT RESTSERVER
    	}
    		
    	job.setName(jobNameInput.getText());
    	job.setBody(jobDescriptionInput.getText());
    	
    	model.showUser(job.getId());
    }
    
    public void setModel(ViewTransitionModelInterface model) {
    	this.model = model;
    }
    
    public void populateJob(String ID) {
    	job = (JobPosting) model.getObject(ID);
    	
    	jobNameInput.setText(job.getName());
    	companyNameInput.setText(job.getCompanyID());
    	jobDescriptionInput.setText(job.getBody());
    }

}

