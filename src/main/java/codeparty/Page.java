package codeparty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
	
	public ArrayList<String> getUsersCanView() {
		return usersCanView;
	}

	public void setUsersCanView(ArrayList<String> usersCanView) {
		this.usersCanView = usersCanView;
	}

	// Constructor
    public Page(String id) {
    	this.id = id;
    }
    
	public Page() {
		super();
		this.id = UUID.randomUUID().toString();
	}
    
	public ArrayList<String> getUsersCanEdit() {
		return usersCanEdit;
	}

	public void setUsersCanEdit(ArrayList<String> usersCanEdit) {
		this.usersCanEdit = usersCanEdit;
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
    
    public void resetLinks(Class<?> type) {
    	links.get(type).clear();
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
	
	public boolean hasLink(Class<?> clas, String id) {
	    if (links.containsKey(clas)) {
	        ArrayList<String> ids = links.get(clas);
	        if (ids.contains(id)) {
	            return true; 
	        }
	    }
	    return false; 
	}
}
