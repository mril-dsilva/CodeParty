import static org.junit.jupiter.api.Assertions.*;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import codeparty.*;




class TestCases
{
	private Skill java;
	private Company autonomy;
	private Experience emilyexp;
	private Person emily;
	private Project buttonapp;
	
	@BeforeEach
	void setUp() throws Exception {
		Image profile = new Image("testprofile.png");
		Image banner  = new Image("testbanner.png");
		GregorianCalendar startDate = new GregorianCalendar(2020, 0, 1); 
        GregorianCalendar endDate = new GregorianCalendar(2022, 11, 31); 
		Class<Page>[] allowedLinks = new Class[]{};
		ArrayList<Experience> experiences = new ArrayList<Experience>();
		
		//Creating a Skill
		java = new Skill(UUID.randomUUID(), profile, banner, "Java Programming", "This skill represents proficiency in Java programming.", allowedLinks, "Write better Java code!");
		//Creating a Company
		Company autonomy = new Company(UUID.randomUUID(), profile, banner, "Autonomy Technologies", "AI driven automobile tech company", "Bleeding Edge Automobile Solutions", allowedLinks);
		//Creating an Experience
		Experience emilyexp = new Experience(UUID.randomUUID(), autonomy, "Software Engineer",startDate,endDate, "Solved problems with code!");
		experiences.add(emilyexp);
		//Creating a Person
		Person emily = new Person(UUID.randomUUID(), profile, banner, "Emily Chen", "Gamer, and Computer Science major at Center College", allowedLinks, emilyexp, experiences, PersonType.BASE);
		//Creating a Project
		Project buttonapp = new Project(UUID.randomUUID(), profile, banner, "Button App", "You guessed it. This is an app with a button.", emily, "A button to solve all your problems", "githublink.com");
		
	}

	@Test
	void test() {
	        
			//Testing Skill Creation
	        assertEquals(java.getProfilePhoto(), new Image("testprofile.png"));
	        assertEquals(java.getBanner(), new Image("testbanner.png"));
	        assertEquals(java.getName(), "Java Programming");
	        assertEquals(java.getBio(), "This skill represents proficiency in Java programming.");
	        assertEquals(java.getTagline(), "Write better Java code!");

	        
	        //Testing Company Creation
	        assertEquals(autonomy.getProfilePhoto(), new Image("testprofile.png"));
	        assertEquals(autonomy.getBanner(), new Image("testbanner.png"));
	        assertEquals(autonomy.getName(), "Autonomy Technologies");
	        assertEquals(autonomy.getBio(), "AI driven automobile tech company");
	        assertEquals(autonomy.getTagline(), "Bleeding Edge Automobile Solutions");
	    

	        //Testing Experience Creation
	        assertEquals(emilyexp.getCompany(), autonomy);
	        assertEquals(emilyexp.getJobTitle(), "Software Engineer");
	        assertEquals(emilyexp.getStartDate(), new GregorianCalendar(2020, 0, 1));
	        assertEquals(emilyexp.getEndDate(), new GregorianCalendar(2022, 11, 31));
	        assertEquals(emilyexp.getDescription(), "Solved problems with code!");
	    

	        //Testing Person Creation
	        assertEquals(emily.getProfilePhoto(), new Image("testprofile.png"));
	        assertEquals(emily.getBanner(), new Image("testbanner.png"));
	        assertEquals(emily.getName(), "Emily Chen");
	        assertEquals(emily.getBio(), "Gamer, and Computer Science major at Center College");
	        assertEquals(emily.getType(), PersonType.BASE);
	    
	        //Testing ProjectCreation
	        assertEquals(buttonapp.getProfilePhoto(), new Image("testprofile.png"));
	        assertEquals(buttonapp.getBanner(), new Image("testbanner.png"));
	        assertEquals(buttonapp.getName(), "Button App");
	        assertEquals(buttonapp.getBio(), "You guessed it. This is an app with a button.");
	        assertEquals(buttonapp.getOwner(), emily);
	        assertEquals(buttonapp.getTagline(), "A button to solve all your problems");
	        assertEquals(buttonapp.getRepositoryLink(), "githublink.com");
	    

	        // Make some changes to the Person emily
	        String newName = "Mril D'silva";
	        String newBio = "Student at Centre College";
	        PersonType newType = PersonType.MENTOR;

	        emily.setName(newName);
	        emily.setBio(newBio);
	        emily.setType(newType);

	        // Verify the changes
	        assertEquals(emily.getName(), newName);
	        assertEquals(emily.getBio(), newBio);
	        assertEquals(emily.getType(), newType);
		
		
	}

}
