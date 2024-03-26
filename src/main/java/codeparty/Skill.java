package codeparty;

import java.util.UUID;

import javafx.scene.image.Image;

public class Skill extends Profile
{
	// Class array representing allowed links
    Class<Page>[] ALLOWED_LINKS;
    String tagline;
    
    public Skill(UUID id, Image profilePhoto, Image banner, String name, String bio, Class<Page>[] ALLOWED_LINKS, String tagline) {
		super(id, profilePhoto, banner, name, bio);
		this.ALLOWED_LINKS = ALLOWED_LINKS;
		this.tagline = tagline;
		// TODO Auto-generated constructor stub
	}

    // Getter for ALLOWED_LINKS
    public Class<Page>[] getAllowedLinks() {
        return ALLOWED_LINKS;
    }

    // Getter and setter for tagline
    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
    
	
}
