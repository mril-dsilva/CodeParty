package views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import models.LinkData;


public class LinkListCellController implements ChangeListener<Boolean> {

	@FXML
	private Label itemName;
	
	LinkListCell model;
	
	
	public void setModel(LinkListCell cell)
    {
		if(model != null)
    	{
    		model.selectedProperty().removeListener(this);
    	}
    	model = cell;
    	if(model != null)
    	{
    		model.selectedProperty().addListener(this);
    	}
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
    	//model.goToLink();
    }

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		// TODO Auto-generated method stub
		if(newValue)
		{
			model.goToLink();
		}
	}
    
    
}
