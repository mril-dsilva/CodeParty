package codeparty;

import java.util.UUID;

import java.awt.Image;

public class Skill extends Profile
{
    String tagline;
    
    public Skill(String id, Image profilePhoto, Image banner, String name, String bio, String tagline) {
		super(id, profilePhoto, banner, name, bio);
		this.tagline = tagline;
		// TODO Auto-generated constructor stub
	}


    // Getter and setter for tagline
    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
    
	
}
