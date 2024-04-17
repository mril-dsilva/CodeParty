package codeparty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public abstract class Page 
{
	String id;
	
	protected Map<Class<?>, ArrayList<String>> links = new HashMap<>();
	private ArrayList<String> usersCanEdit = new ArrayList<String>();
	private ArrayList<String> usersCanView = new ArrayList<String>();
	
	
	public void setID(String id) {
		this.id = id;
	}
	
	public void setLinks(Map<Class<?>, ArrayList<String>> links) {
		this.links = links;
	}
	
	// Constructor
    public Page(String id) {
    	this.id = id;
    }
    
    public ArrayList<String> getUsersCanEdit() {
		return usersCanEdit;
	}

	public void setUsersCanEdit(ArrayList<String> usersCanEdit) {
		this.usersCanEdit = usersCanEdit;
	}

	public ArrayList<String> getUsersCanView() {
		return usersCanView;
	}

	public void setUsersCanView(ArrayList<String> usersCanView) {
		this.usersCanView = usersCanView;
	}
	

	public String getId() {
		return id;
	}

	public Map<Class<?>, ArrayList<String>> getLinks() {
		return links;
	}

	// Method to add a link to another page
    public void addLink(Class<?> type, String id) {
    	links.get(type).add(id);
    	// void
    }
    
    // Method to remove a link from the page
    public void removeLink(Class<?> type, String id) {
    	links.get(type).remove(id);
        // void
    }
    
    public void addEditor(String ID) {
		usersCanEdit.add(ID);
	}
	
	public void removeEditor(String ID) {
		usersCanEdit.remove(ID);
	}
	
	public void addViewer(String ID) {
		usersCanView.add(ID);
	}
	
	public void removeViewer(String ID) {
		usersCanView.remove(ID);
	}
	/*
	@Override
	public int hashCode() {
		return Objects.hash(id, links, usersCanEdit, usersCanView);
	}
	
	/*
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		return Objects.equals(id, other.id) && Objects.equals(links, other.links)
				&& Objects.equals(usersCanEdit, other.usersCanEdit) && Objects.equals(usersCanView, other.usersCanView);
	}
	*/
}
