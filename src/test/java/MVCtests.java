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


class MVCtests
{
	ArrayList<Experience> experiences = new ArrayList<Experience>();
	ArrayList<String> editpermissions = new ArrayList<String>();
	Map<Class<?>, ArrayList<String>> links = new HashMap<>();
	
	Person emily, John, Michael, Newman, Harshit, Aadi, Mril;
	Company auto, apple, amazon, microsoft, centre;
	Experience job, internship, dictatorship, assistantship;
	Skill JAVA, py, REST, English, juggling;
	Project app, casestudy, research, minigame;
	JobPosting engineer, doctor, lawyer, manager, CEO, monk;
	
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
        
        JAVA = new Skill(UUID.randomUUID().toString(), "Java Programming", "Fake bio inserted here for the coding language skill", "You are using it right now!");
        py = new Skill();
        
        app = new Project(UUID.randomUUID().toString(), "Mobile App", "The best mobile app in the world that can solve all your problems in a click", "123", "Project by Emily", "github.com");
        casestudy = new Project();
        
        auto = new Company(UUID.randomUUID().toString(), "AutoNomy", "AI Driving Company. based in Fan Srancisco", "leave the driving to us!");
        apple = new Company(); 
        
        internship = new Experience(UUID.randomUUID().toString(), auto.getId(), "Software Intern","Solved problems with code!");
        job = new Experience();
        experiences.add(internship);
		experiences.add(job);
        
        engineer = new JobPosting(UUID.randomUUID().toString(), auto.getId(), "123", "Autonomy Engineer", "This is a role that needs a lot of talents like being an engineer for example. Apart from that it doesnt really need any particular skills. You can apply for it but I dont think you will get this role tbh.", JobRecommendStrategy.EVERYONE);
        doctor = new JobPosting();
        
        emily = new Person("123","Emily Chen", "Gamer, and Computer Science major at Center College. A passionate software engineer with a knack for problem-solving and a love for coding!"
        		, job, experiences, PersonType.BASE); editpermissions.add(emily.getId()); emily.setUsersCanEdit(editpermissions);
        John = new Person();

	}

	@Test
	void test() {
		
		//persons population
        ServerHandler.putPersonObject(John);
        John.setType(PersonType.MENTOR);
        John.addViewer(emily.getId());
        John.addLink(Person.class, emily.getId());
        John.addLink(Skill.class, JAVA.getId());
        John.addLink(Project.class, app.getId());
        ServerHandler.updatePersonObject(John); //UPDATING OBJECT
        
		ServerHandler.putPersonObject(emily);
		
        ServerHandler.putSkillObject(JAVA);
        JAVA.setUsersCanEdit(editpermissions); 
        ServerHandler.updateSkillObject(JAVA); 
        
     
        ServerHandler.putCompanyObject(auto); apple.setName("Apple"); apple.setTagline("not the fruit"); apple.addEditor("123");  apple.addLink(Skill.class, py.getId()); apple.addViewer("123"); apple.addLink(Person.class, "123"); apple.setBio("Apple Inc. is an American multinational corporation and technology company headquartered in Cupertino, California, in Silicon Valley. It designs, develops, and sells consumer electronics, computer software, and online services. Wikipedia");
        ServerHandler.putCompanyObject(apple);
        Company c = ServerHandler.getCompanyObject(auto.getId());
        auto.setTagline("Setting people up for success");
        ServerHandler.updateCompanyObject(auto); //UPDATING OBJECT


        //project tests
        ServerHandler.putProjectObject(app); ServerHandler.putProjectObject(casestudy);
       
        app.setOwnerID(emily.getId());
        ServerHandler.updateProjectObject(app);
        
        //jobposting tests
        engineer.setCompanyID(auto.getId());
        engineer.setContactID(emily.getId());
        ServerHandler.putJobPostingObject(engineer);
        ServerHandler.putJobPostingObject(doctor);
    
        engineer.setCompanyID(John.getId());
        engineer.setName("boring engineer");
        ServerHandler.updateJobPostingObject(engineer); 
        
        //NEW TESTS TO CHECK JOB RECOMMEND SYSTEM
        JobPosting every1job = new JobPosting(); every1job.setName("every1job");
        every1job.setStrat(JobRecommendStrategy.EVERYONE);
        JobPosting pythonskillJob = new JobPosting(); pythonskillJob.setName("pythonskillJob");
        pythonskillJob.setStrat(JobRecommendStrategy.SKILLS);
        py.setName("python");
        pythonskillJob.addLink(Skill.class, py.getId());
        
        JobPosting emilyfriendJob = new JobPosting(); emilyfriendJob.setName("emilyfriendJob");
        emilyfriendJob.setStrat(JobRecommendStrategy.FRIENDS);
        emilyfriendJob.setContactID(emily.getId());
        
        ServerHandler.putJobPostingObject(every1job);
        ServerHandler.putJobPostingObject(pythonskillJob);
        ServerHandler.putJobPostingObject(emilyfriendJob);
        
        Person boy = new Person(); boy.setName("NEWMAN"); boy.setId("jobpostingtesterboy"); //make new person 
        ServerHandler.putPersonObject(boy);
        JobRecommender jobRecommender = new JobRecommender();
		jobRecommender.recommendJobs(boy);
		
		boy.addLink(Skill.class, py.getId()); //give him new skill
		ServerHandler.updatePersonObject(boy); 
		jobRecommender.recommendJobs(boy);
		
		boy.addLink(Person.class, emily.getId()); //give him new Friend linked
		ServerHandler.updatePersonObject(boy); 
		jobRecommender.recommendJobs(boy);
        
	}

}

