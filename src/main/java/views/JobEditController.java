package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.ViewTransitionModelInterface;
import models.pages.JobPosting;

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
    		job.setCompany(companyNameInput.getText());
    	}
    		
    	job.setName(jobNameInput.getText());
    	job.setBody(jobDescriptionInput.getText());
    	
    	model.showUser(job.getID());
    }
    
    public void setModel(ViewTransitionModelInterface model) {
    	this.model = model;
    }
    
    public void populateJob(String ID) {
    	job = (JobPosting) model.getObject(ID);
    	
    	jobNameInput.setText(job.getName());
    	companyNameInput.setText(job.getCompany());
    	jobDescriptionInput.setText(job.getBody());
    }

}

