package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.ViewTransitionModelInterface;
import models.pages.Skill;

public class SkillEditController {

    @FXML
    private TextField bioText;

    @FXML
    private Button editButton;

    @FXML
    private TextField nameText;

    @FXML
    private TextField taglineText;

    ViewTransitionModelInterface model;
	Skill skill;
    
    @FXML
    void onEditButtonClick(ActionEvent event) {
    	skill.setBio(bioText.getText());
    	skill.setName(nameText.getText());
    	skill.setTagline(taglineText.getText());
    	
    	model.showUser(skill.getID());
    }
    
    public void setModel(ViewTransitionModelInterface model) {
    	this.model = model;
    }
    
    public void populateSkill(String ID) {
    	skill = (Skill) model.getObject(ID);
    	
    	nameText.setText(skill.getName());
    	taglineText.setText(skill.getTagline());
    	bioText.setText(skill.getBio());
    }
    

}

