package codeparty;

import java.util.ArrayList;
import java.util.UUID;

import java.awt.Image;

public class Person extends Profile
{
	
	public Person(String id, Image profilePhoto, Image banner, String name, String bio, Experience currentCompany, ArrayList<Experience> experiences, PersonType type) {
		super(id, profilePhoto, banner, name, bio);
		// TODO Auto-generated constructor stub

		this.currentCompany = currentCompany;
		this.experiences = experiences;
		this.type = type;
	}

	Experience currentCompany;
    ArrayList<Experience> experiences;
    PersonType type;
    
  
    /**
	 * @return the id
	 */
	public String getId() {
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
