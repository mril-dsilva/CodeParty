import static org.junit.jupiter.api.Assertions.*;

import java.awt.Image;
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
	private JobPosting engineerjob;
	private Request request1;
	GregorianCalendar startDate = new GregorianCalendar(2020, 0, 1); 
    GregorianCalendar endDate = new GregorianCalendar(2022, 11, 31); 
    Image profile = null; 
	Image banner = null;
	
	ArrayList<Experience> experiences = new ArrayList<Experience>();
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		//Creating a Skill
		java = new Skill(UUID.randomUUID().toString().toString(), profile, banner, "Java Programming", "This skill represents proficiency in Java programming.", "Write better Java code!");
		//Creating a Company
		autonomy = new Company(UUID.randomUUID().toString(), profile, banner, "Autonomy Technologies", "AI driven automobile tech company", "Bleeding Edge Automobile Solutions");
		//Creating an Experience
		emilyexp = new Experience(UUID.randomUUID().toString(), autonomy, "Software Engineer",startDate,endDate, "Solved problems with code!");
		experiences.add(emilyexp);
		//Creating a Person 
		emily = new Person(UUID.randomUUID().toString(), profile, banner, "Emily Chen", "Gamer, and Computer Science major at Center College", emilyexp, experiences, PersonType.BASE);
		//Creating a Project
		buttonapp = new Project(UUID.randomUUID().toString(), profile, banner, "Button App", "You guessed it. This is an app with a button.", emily, "A button to solve all your problems", "githublink.com");
		
		//Creating a job posting
		engineerjob = new JobPosting(UUID.randomUUID().toString(), autonomy, emily, "Engineer Job", "Apply to be an Engineer", startDate,  endDate);
		//Creating a friend request
		request1 = new Request(UUID.randomUUID().toString(), "Let's work together!", emily, startDate);
		
		
	}

	@Test
	void test() {
	        
			//Testing Skill Creation
	        assertEquals(java.getProfilePhoto(), null);
	        assertEquals(java.getBanner(), null);
	        assertEquals(java.getName(), "Java Programming");
	        assertEquals(java.getBio(), "This skill represents proficiency in Java programming.");
	        assertEquals(java.getTagline(), "Write better Java code!");

	        
	        //Testing Company Creation
	        assertEquals(autonomy.getProfilePhoto(), null);
	        assertEquals(autonomy.getBanner(), null);
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
	        assertEquals(emily.getProfilePhoto(), null);
	        assertEquals(emily.getBanner(), null);
	        assertEquals(emily.getName(), "Emily Chen");
	        assertEquals(emily.getBio(), "Gamer, and Computer Science major at Center College");
	        assertEquals(emily.getType(), PersonType.BASE);
	    
	        //Testing ProjectCreation
	        assertEquals(buttonapp.getProfilePhoto(), null);
	        assertEquals(buttonapp.getBanner(), null);
	        assertEquals(buttonapp.getName(), "Button App");
	        assertEquals(buttonapp.getBio(), "You guessed it. This is an app with a button.");
	        assertEquals(buttonapp.getOwner(), emily);
	        assertEquals(buttonapp.getTagline(), "A button to solve all your problems");
	        assertEquals(buttonapp.getRepositoryLink(), "githublink.com");
	        
	        //Testing Request Creation
	        assertNotNull(request1.getId());
	        assertEquals("Let's work together!", request1.getMessage());
	        assertEquals(emily, request1.getPerson());
	        assertEquals(startDate, request1.getDateCreated());
	        String newMessage = "New message";
	        request1.setMessage(newMessage);
	        assertEquals(newMessage, request1.getMessage());
	        
	        // Testing Job Creation
	        assertNotNull(engineerjob.getId());
	        assertEquals(autonomy, engineerjob.getCompany());
	        assertEquals(emily, engineerjob.getContact());
	        assertEquals("Engineer Job", engineerjob.getJobName());
	        assertEquals("Apply to be an Engineer", engineerjob.getBody());
	        assertEquals(startDate, engineerjob.getDatePosted());
	        assertEquals(endDate, engineerjob.getExpiryDate());
	    

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
