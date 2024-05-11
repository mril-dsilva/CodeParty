package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.ViewTransitionModelInterface;
import server.ServerHandler;
import codeparty.Company;
import codeparty.Project;

public class ProjectEditController {

	ViewTransitionModelInterface model;
	Project project;
	
    @FXML
    private TextField bioText;

    @FXML
    private Button editButton;

    @FXML
    private TextField nameText;

    @FXML
    private TextField taglineText;
    
    @FXML
    void onEditButtonClick(ActionEvent event) {
    	project.setBio(bioText.getText());
    	project.setName(nameText.getText());
    	project.setTagline(taglineText.getText());
    	
    	ServerHandler.updateProjectObject(project);
    	model.showProject(project.getId());
    }
    
    public void setModel(ViewTransitionModelInterface model) {
    	this.model = model;
    }
    
    public void populateProject(String ID) {
    	project = ServerHandler.getProjectObject(ID);
    	
    	nameText.setText(project.getName());
    	taglineText.setText(project.getTagline());
    	bioText.setText(project.getBio());
    }

}
