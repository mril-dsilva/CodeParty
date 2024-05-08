package views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.LinkData;

public class LinkListCellController {

	@FXML
	private Label itemName;
	
	LinkListCell model;
	
	public void setModel(LinkListCell cell)
    {
    	model = cell;
    }
    
    public void updateView(LinkData item)
    {
    	if(item ==null)
    	{
    		itemName.setText("");
    	}
    	else
    	{
    		itemName.setText(item.getName());
    	}
    }
    
    @FXML
    void onItemClicked(MouseEvent event) 
    {
    	model.goToLink();
    }
}
