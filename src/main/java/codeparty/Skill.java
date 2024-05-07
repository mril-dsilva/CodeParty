package codeparty;

import java.util.ArrayList;

public class Skill extends Profile
{
    String tagline;
    
    public Skill(String id, String name, String bio, String tagline) {
		super(id, name, bio);
		this.tagline = tagline;
		// TODO Auto-generated constructor stub
		links.put(Person.class, new ArrayList<String>());
		links.put(Skill.class, new ArrayList<String>());
	}


    // Getter and setter for tagline
    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
    
	
}
