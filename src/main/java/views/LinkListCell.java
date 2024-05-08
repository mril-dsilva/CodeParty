package views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import models.LinkData;
import models.ViewTransitionModelInterface;
import models.pages.Company;
import models.pages.JobPosting;
import models.pages.Page;
import models.pages.Person;
import models.pages.Skill;

public class LinkListCell extends ListCell<LinkData>{

	LinkListCellController controller;
	ViewTransitionModelInterface model;
	LinkData data;
	Node node;
	
	public LinkListCell(ViewTransitionModelInterface model)
	{
		this.model = model;
		
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(LinkListCell.class
	        .getResource("linkCellView.fxml"));
	    try {
	      node = loader.load(); //store for later
	      
	      controller = loader.getController(); //store for later
	      controller.setModel(this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	    setGraphic(node);
		
	}
	
	@Override
	protected void updateItem(LinkData item, boolean empty)
	{
		data = item;
		
		if(!empty)
		{
			controller.updateView(item);
		}
		else
		{
			controller.updateView(null);
		}
		super.updateItem(item, empty);
	}
	
	public void goToLink() {
		Class<? extends Page> type = data.getType();
		String id = data.getID();
		
		if(type.equals(Person.class)) {
			model.showUser(id);
		}else if(type.equals(Company.class)) {
			model.showCompany(id);
		}else if(type.equals(Skill.class)) {
			model.showSkill(id);
		}else if(type.equals(JobPosting.class)) {
			model.showJobPosting(id);
		}
	}
}
