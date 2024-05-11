package codeparty;

import java.util.ArrayList;
import java.util.Objects;

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
		links.put(JobPosting.class, new ArrayList<String>());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(currentCompany, experiences, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(currentCompany, other.currentCompany) && Objects.equals(experiences, other.experiences)
				&& type == other.type;
	}

	public Person() {
		super();
		currentCompany = new Experience();
		experiences = new ArrayList<Experience>();
		experiences.add(currentCompany);
		type = PersonType.BASE;
		links.put(Person.class, new ArrayList<String>());
		links.put(Skill.class, new ArrayList<String>());
		links.put(Project.class, new ArrayList<String>());
		links.put(JobPosting.class, new ArrayList<String>());
	}
	
	Experience currentCompany;
    ArrayList<Experience> experiences;
    PersonType type;
    
    
    // Getter and setter for currentCompany
    public Experience getCurrentCompany() {
        return currentCompany;
    }

    public void setExperiences(ArrayList<Experience> experiences) {
		this.experiences = experiences;
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
    
    //haslink method

}
