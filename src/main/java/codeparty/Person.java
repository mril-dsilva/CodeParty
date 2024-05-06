package codeparty;

import java.util.ArrayList;
import java.util.UUID;

import java.awt.Image;

public class Person extends Profile
{
	
	public Person(String id, String name, String bio, Experience currentCompany, ArrayList<Experience> experiences, PersonType type) {
		super(id, name, bio);
		// TODO Auto-generated constructor stub
		this.currentCompany = currentCompany;
		this.experiences = experiences;
		this.type = type;
		links.put(Person.class, new ArrayList<String>());
		links.put(Skill.class, new ArrayList<String>());
		links.put(Project.class, new ArrayList<String>());
	}

	Experience currentCompany;
    ArrayList<Experience> experiences;
    PersonType type;
    
    
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
