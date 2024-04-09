package codeparty;

import java.util.ArrayList;
import java.util.UUID;

import java.awt.Image;

public class Person extends Profile
{
	
	public Person(UUID id, Image profilePhoto, Image banner, String name, String bio, Class<Page>[] ALLOWED_LINKS, Experience currentCompany, ArrayList<Experience> experiences, PersonType type) {
		super(id, profilePhoto, banner, name, bio);
		// TODO Auto-generated constructor stub
		this.ALLOWED_LINKS = ALLOWED_LINKS;
		this.currentCompany = currentCompany;
		this.experiences = experiences;
		this.type = type;
	}

	Class<Page>[] ALLOWED_LINKS;
	Experience currentCompany;
    ArrayList<Experience> experiences;
    PersonType type;
    
    
    // Getter for ALLOWED_LINKS
    public Class<Page>[] getAllowedLinks() {
        return ALLOWED_LINKS;
    }
    
    /**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

    
    // Getter and setter for currentCompany
    public Experience getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(Experience currentCompany) {
        this.currentCompany = currentCompany;
    }

    // Getter for experiences
    public ArrayList<Experience> getExperiences() {
        return experiences;
    }

    // Getter and setter for type
    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }
    

}
