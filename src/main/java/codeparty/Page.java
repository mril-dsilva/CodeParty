package codeparty;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Page 
{
	UUID id;
	ArrayList<Page> links;
	
	// Constructor
    public Page(UUID id) {
    	
        this.id = id;
        
    }
    
    // Getter method for id
    public UUID getId() {
        return id;
    }
    
    // Getter method for links
    public ArrayList<Page> getLinks() {
        return links;
    }
    
    // Method to add a link to another page
    public void addLink(Page page) {
        // void
    }
    
    // Method to remove a link from the page
    public void removeLink(Page page) {
        // void
    }
	
}
