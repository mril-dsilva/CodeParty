import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

import codeparty.Company;
import codeparty.Experience;
import codeparty.JobPosting;
import codeparty.Person;
import codeparty.PersonType;
import codeparty.Project;
import codeparty.Skill;
import server.JobRecommendStrategy;
import server.JobRecommender;
import server.ServerHandler;


class RestServerTest
{
	ArrayList<Experience> experiences = new ArrayList<Experience>();
	ArrayList<String> editpermissions = new ArrayList<String>();
	Map<Class<?>, ArrayList<String>> links = new HashMap<>();
	
	Person emily, John;
	Company auto;
	Experience job, internship;
	Skill JAVA;
	Project app;
	JobPosting engineer;
	
	@BeforeEach
	void setUp() throws Exception {
		
		ServerHandler.createTeam();
		ArrayList<String> pagesList = new ArrayList<String>();
        pagesList.add("Person");
        pagesList.add("Skill");
        pagesList.add("Company");
        pagesList.add("Project");
        pagesList.add("JobPosting");
        ServerHandler.createAllPages(pagesList);
        
        auto = new Company();
        internship = new Experience(UUID.randomUUID().toString(), auto.getId(), "Software Intern","Solved problems with code!");
        job = new Experience();
		experiences.add(internship);
		experiences.add(job);
        emily = new Person(UUID.randomUUID().toString(),"Emily Chen", "Gamer, and Computer Science major at Center College", job, experiences, PersonType.BASE);
        John = new Person();
        JAVA = new Skill();
        editpermissions.add(emily.getId());
        app = new Project();
        engineer = new JobPosting();

	}

	@Test
	void test() {
		
		//persons tests
        ServerHandler.putPersonObject(John);
        Person RestJohn = ServerHandler.getPersonObject(John.getId());
        assertEquals("John Doe", RestJohn.getName());
        assertEquals("default bio", RestJohn.getBio());
        assertEquals(PersonType.BASE, RestJohn.getType());
        John.setType(PersonType.MENTOR);
        John.addViewer(emily.getId());
        John.addLink(Person.class, emily.getId());
        John.addLink(Skill.class, JAVA.getId());
        John.addLink(Project.class, app.getId());
        ServerHandler.updatePersonObject(John); //UPDATING OBJECT
        Person RestJohnUpdated = ServerHandler.getPersonObject(John.getId()); //CHECKING UPDATES
        assertEquals(PersonType.MENTOR, RestJohnUpdated.getType());
        assertEquals(John.getLinks(), RestJohnUpdated.getLinks());
        assertEquals(emily.getId(), RestJohnUpdated.getUsersCanView().get(0));
        
		ServerHandler.putPersonObject(emily);
        Person amily = ServerHandler.getPersonObject(emily.getId());
        assertEquals("Emily Chen", amily.getName());
        assertEquals("Gamer, and Computer Science major at Center College", amily.getBio());
        assertEquals(PersonType.BASE, amily.getType());
        assertEquals(job.getJobTitle(), amily.getCurrentCompany().getJobTitle());
        assertEquals(job.getDescription(), amily.getCurrentCompany().getDescription());
        assertEquals(job.getCompanyID(), amily.getCurrentCompany().getCompanyID());
        assertEquals(internship.getJobTitle(), amily.getExperiences().get(0).getJobTitle());
        assertEquals(internship.getDescription(), amily.getExperiences().get(0).getDescription());
      
        //skills tests
        ServerHandler.putSkillObject(JAVA);
        Skill s = ServerHandler.getSkillObject(JAVA.getId());
        assertEquals("JAVA", s.getName());
        assertEquals("Skill tagline!", s.getTagline());
        assertEquals(JAVA.getBio(), s.getBio());
        JAVA.setUsersCanEdit(editpermissions); //CHECKING update PERMISSIONS
        ServerHandler.updateSkillObject(JAVA); //UPDATING OBJECT
        Skill sUpdated = ServerHandler.getSkillObject(JAVA.getId()); //CHECKING UPDATES
        assertEquals(emily.getId(), sUpdated.getUsersCanEdit().get(0));
        
        //company tests
        ServerHandler.putCompanyObject(auto);
        Company c = ServerHandler.getCompanyObject(auto.getId());
        assertEquals("THE BORING COMPANY", c.getName());
        assertEquals("default tagline!", c.getTagline());
        assertEquals(auto.getBio(), c.getBio());
        auto.setTagline("Setting people up for success");
        ServerHandler.updateCompanyObject(auto); //UPDATING OBJECT
        Company cUpdated = ServerHandler.getCompanyObject(auto.getId()); //CHECKING UPDATES
        assertEquals("Setting people up for success", cUpdated.getTagline());
        
        //project tests
        ServerHandler.putProjectObject(app);
        Project p = ServerHandler.getProjectObject(app.getId());
        assertEquals("button APP", p.getName());
        assertEquals("default tagline!", p.getTagline());
        assertEquals(app.getBio(), p.getBio());
        assertEquals("google.com", p.getRepositoryLink());
        app.setOwnerID(emily.getId());
        ServerHandler.updateProjectObject(app); //UPDATING OBJECT
        Project pUpdated = ServerHandler.getProjectObject(app.getId()); //CHECKING UPDATES
        assertEquals(emily.getId(), pUpdated.getOwnerID());
        
        //jobposting tests
        engineer.setCompanyID(auto.getId());
        engineer.setContactID(emily.getId());
        ServerHandler.putJobPostingObject(engineer);
        JobPosting j = ServerHandler.getJobPostingObject(engineer.getId());
        assertEquals("Engineer", j.getJobName());
        assertEquals("Engineer Products, what else!", j.getBody());
        assertEquals(auto.getId(), j.getCompanyID());
        assertEquals(emily.getId(), j.getContactID());
        engineer.setCompanyID(John.getId());
        engineer.setJobName("boring engineer");
        ServerHandler.updateJobPostingObject(engineer); //UPDATING OBJECT
        JobPosting jUpdated = ServerHandler.getJobPostingObject(engineer.getId()); //CHECKING UPDATES
        assertEquals("boring engineer", jUpdated.getJobName());
        assertEquals(emily.getId(), jUpdated.getContactID());
        
        //NEW TESTS TO CHECK JOB RECOMMEND SYSTEM
        JobPosting every1job = new JobPosting(); every1job.setJobName("every1job");
        every1job.setStrat(JobRecommendStrategy.EVERYONE);
        
        JobPosting pythonskillJob = new JobPosting(); pythonskillJob.setJobName("pythonskillJob");
        pythonskillJob.setStrat(JobRecommendStrategy.SKILLS);
        Skill py = new Skill(); py.setName("python");
        pythonskillJob.addLink(Skill.class, py.getId());
        
        JobPosting emilyfriendJob = new JobPosting(); emilyfriendJob.setJobName("emilyfriendJob");
        emilyfriendJob.setStrat(JobRecommendStrategy.FRIENDS);
        emilyfriendJob.setContactID(emily.getId());
        
        ServerHandler.putJobPostingObject(every1job);
        ServerHandler.putJobPostingObject(pythonskillJob);
        ServerHandler.putJobPostingObject(emilyfriendJob);
        
        Person boy = new Person(); boy.setName("NEWMAN"); boy.setID("jobpostingtesterboy"); //make new person 
        ServerHandler.putPersonObject(boy);
        JobRecommender jobRecommender = new JobRecommender();
		jobRecommender.recommendJobs(boy);
		assertEquals(boy.getLinks().get(JobPosting.class).size(), 2); //(2 EVERYONE jobpostings exist)
		
		boy.addLink(Skill.class, py.getId()); //give him new skill
		ServerHandler.updatePersonObject(boy); 
		jobRecommender.recommendJobs(boy);
		assertEquals(boy.getLinks().get(JobPosting.class).size(), 3); // +1 skill jobposting 
		
		assertTrue(boy.hasLink(JobPosting.class, pythonskillJob.getId()));
		assertFalse(boy.hasLink(JobPosting.class, emilyfriendJob.getId()));
		
		boy.addLink(Person.class, emily.getId()); //give him new Friend linked
		ServerHandler.updatePersonObject(boy); 
		jobRecommender.recommendJobs(boy);
		assertEquals(boy.getLinks().get(JobPosting.class).size(), 4); //+1 friends jobposting
		
		assertTrue(boy.hasLink(JobPosting.class, emilyfriendJob.getId()));
        
        
	}

}

