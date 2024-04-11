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
    
    // Method to add a link to another page
    public void addLink(Page page) {
    	links.add(page);
    	// void
    }
    
    // Method to remove a link from the page
    public void removeLink(Page page) {
    	links.remove(page);
        // void
    }
	
}
