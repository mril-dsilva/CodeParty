package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ListModel
{
	ObservableList<LinkData> items = 
		      FXCollections.observableArrayList();
		  
	
	public ListModel()
	{}
	
	
	
	public void addItem(LinkData item)
	{
		items.add(item);
	}
	
	
	/**
	 * @return the items
	 */
	public ObservableList<LinkData> getItems()
	{
		return items;
	}



	/**
	 * @param items the items to set
	 */
	public void setItems(ObservableList<LinkData> items)
	{
		this.items = items;
	}
	

	
	

	
}
