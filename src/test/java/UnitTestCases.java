import static org.junit.jupiter.api.Assertions.*;

import java.awt.Image;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import codeparty.*;
import server.JobRecommendStrategy;




class UnitTestCases
{
	private Skill java;
	private Company autonomy;
	private Experience emilyexp;
	private Person emily;
	private Person john;
	private Project buttonapp;
	private JobPosting engineerjob;
	//private Request request1;
    Image profile = null; 
	Image banner = null;
	
	ArrayList<Experience> experiences = new ArrayList<Experience>();
	ArrayList<String> editpermissions = new ArrayList<String>();
	
	Map<Class<?>, ArrayList<String>> links = new HashMap<>();
	
	@BeforeEach
	void setUp() throws Exception { 
		
		
		//Creating a Skill
		java = new Skill(UUID.randomUUID().toString().toString(),"Java Programming", "This skill represents proficiency in Java programming.", "Write better Java code!");
		//Creating a Company
		autonomy = new Company(UUID.randomUUID().toString(),"Autonomy Technologies", "AI driven automobile tech company", "Bleeding Edge Automobile Solutions");
		//Creating an Experience
		emilyexp = new Experience(UUID.randomUUID().toString(), autonomy.getId(), "Software Engineer","Solved problems with code!");
		experiences.add(emilyexp);
		//Creating a Person 
		emily = new Person(UUID.randomUUID().toString(),"Emily Chen", "Gamer, and Computer Science major at Center College", null, experiences, PersonType.BASE);
		//Creating a Project
		buttonapp = new Project(UUID.randomUUID().toString(), "Button App", "You guessed it. This is an app with a button.", emily.getId(), "A button to solve all your problems", "githublink.com");
		
		//Creating a job posting
		engineerjob = new JobPosting(UUID.randomUUID().toString(), autonomy.getId(), emily.getId(), "Engineer Job", "Apply to be an Engineer", JobRecommendStrategy.EVERYONE);
		//Creating a friend request
		//request1 = new Request(UUID.randomUUID().toString(), "Let's work together!", emily, startDate);
		//Creating person 2
		john = new Person(UUID.randomUUID().toString(),"John Chen", "Gamer, and Politics major at Center College", emilyexp, experiences, PersonType.BASE);
	
	}

	@Test 
	void test() {
	        
			//Testing Skill Creation
	        assertEquals(java.getName(), "Java Programming");
	        assertEquals(java.getBio(), "This skill represents proficiency in Java programming.");
	        assertEquals(java.getTagline(), "Write better Java code!");
	        java.setTagline("New Java Tagline");
	        assertEquals(java.getTagline(), "New Java Tagline");
	        
	        //Testing Company Creation
	        assertEquals(autonomy.getName(), "Autonomy Technologies");
	        assertEquals(autonomy.getBio(), "AI driven automobile tech company");
	        assertEquals(autonomy.getTagline(), "Bleeding Edge Automobile Solutions");
	        autonomy.setTagline("New Company Tagline");
	        assertEquals(autonomy.getTagline(), "New Company Tagline");
	        String X = autonomy.getId();
	        assertEquals(autonomy.getId(), X);
	        System.out.println(X);

	        //Testing Experience Creation
	        emilyexp.setCompanyID(autonomy.getId());
	        assertEquals(emilyexp.getCompanyID(), autonomy.getId());
	        assertEquals(emilyexp.getJobTitle(), "Software Engineer");
	        assertEquals(emilyexp.getDescription(), "Solved problems with code!");
	        emilyexp.setDescription("New description testing!");
	        assertEquals(emilyexp.getDescription(), "New description testing!");
	        emilyexp.setJobTitle("Software Developer");
	        assertEquals(emilyexp.getJobTitle(), "Software Developer");
	        emilyexp.setCompanyID(autonomy.getId());
	        emilyexp.setId("experience#1234");
	        assertEquals(emilyexp.getId(), "experience#1234");
	        
	        // Testing Job Creation
	        assertNotNull(engineerjob.getId());
	        engineerjob.setCompanyID(autonomy.getId());
	        assertEquals(autonomy.getId(), engineerjob.getCompanyID());
	        assertEquals(emily.getId(), engineerjob.getContactID());
	        engineerjob.setContactID(john.getId());
	        assertEquals(john.getId(), engineerjob.getContactID());
	        assertEquals("Engineer Job", engineerjob.getJobName());
	        assertEquals("Apply to be an Engineer", engineerjob.getBody());
	        engineerjob.setJobName("Deleted Job");
	        assertEquals("Deleted Job", engineerjob.getJobName());
	        engineerjob.setBody("this post has been deleted");
	        assertEquals("this post has been deleted", engineerjob.getBody());
	        
	        //Testing ProjectCreation
	        assertEquals(buttonapp.getName(), "Button App");
	        assertEquals(buttonapp.getBio(), "You guessed it. This is an app with a button.");
	        assertEquals(buttonapp.getOwnerID(), emily.getId());
	        assertEquals(buttonapp.getTagline(), "A button to solve all your problems");
	        assertEquals(buttonapp.getRepositoryLink(), "githublink.com");
	        buttonapp.setOwnerID(john.getId()); // changing owner of the project
	        assertEquals(buttonapp.getOwnerID(), john.getId());
	        buttonapp.setRepositoryLink("google.com");
	        assertEquals(buttonapp.getRepositoryLink(), "google.com");
	        buttonapp.setTagline("New project Tagline");
	        assertEquals(buttonapp.getTagline(), "New project Tagline");

	        //Testing Person Creation
	        assertEquals(emily.getName(), "Emily Chen");
	        assertEquals(emily.getBio(), "Gamer, and Computer Science major at Center College");
	        assertEquals(emily.getType(), PersonType.BASE);
	        assertEquals(emily.getCurrentCompany(), null);
	        emily.setCurrentCompany(emilyexp);
	        assertEquals(emily.getCurrentCompany(), emilyexp);
	        experiences.add(emilyexp);
	        assertEquals(emily.getExperiences(), experiences);
	        emily.setID("person#1234");
	        assertEquals(emily.getId(), "person#1234");
	        emily.setUsersCanEdit(editpermissions);
	        emily.addEditor(emily.getId());
	        emily.addEditor(john.getId());
	        emily.removeEditor(john.getId());
	        emily.addViewer(autonomy.getId());
	        emily.addViewer(john.getId());
	        emily.addViewer(buttonapp.getId());
	        emily.addViewer(emily.getId());
	        emily.removeViewer(buttonapp.getId());
	        assertEquals(emily.getUsersCanEdit(), editpermissions);
	        //adding links to emily
	        emily.addLink(Project.class, buttonapp.getId());
	        emily.addLink(Person.class, john.getId());
	        emily.addLink(Skill.class, java.getId());
	        emily.removeLink(Project.class, buttonapp.getId());
	        //checked hasLinks method
	        assertTrue(emily.hasLink(Person.class, john.getId()));
	        assertFalse(emily.hasLink(Project.class, buttonapp.getId()));
	        assertFalse(emily.hasLink(Company.class, autonomy.getId()));
	        
	        //how do i test if it is in it
	        
	        emily.setLinks(links);
	        assertEquals(emily.getLinks(), links);
	        
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
	        
	        
//	        //Testing Request Creation 
//	        assertNotNull(request1.getId());
//	        assertEquals("Let's work together!", request1.getMessage());
//	        assertEquals(emily, request1.getPerson());
//	        assertEquals(startDate, request1.getDateCreated());
//	        String newMessage = "New message";
//	        request1.setMessage(newMessage);
//	        assertEquals(newMessage, request1.getMessage());
//	        request1.setPerson(john);
//	        request1.setDateCreated(endDate);
//	        assertEquals(john, request1.getPerson());
//	        assertEquals(endDate, request1.getDateCreated()); 
	        

	       
	}

}
