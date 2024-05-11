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


class MVCTestSetup
{
	
	
	
	
	public void main() {
		
		ArrayList<Experience> experiences = new ArrayList<Experience>();
		ArrayList<String> editpermissions = new ArrayList<String>();
		
		Person emily, John, Michael, Newman, Harshit, Aadi, Mril;
		Company auto, apple, amazon, microsoft;
		Experience job, internship;
		Skill JAVA, py, REST, English, juggling;
		Project app, casestudy;
		JobPosting engineer, doctor;
		
		ServerHandler.createTeam();
		ArrayList<String> pagesList = new ArrayList<String>();
        pagesList.add("Person");
        pagesList.add("Skill");
        pagesList.add("Company");
        pagesList.add("Project");
        pagesList.add("JobPosting");
        ServerHandler.createAllPages(pagesList);
        
        JAVA = new Skill("java", "Java Programming", "Fake bio inserted here for the coding language skill", "You are using it right now!");
        py = new Skill(); py.setBio("IF you can see this job posting through your profile, you have the PYTHON skill!");
        
        app = new Project(UUID.randomUUID().toString(), "Mobile App", "The best mobile app in the world that can solve all your problems in a click", "123", "Project by Emily", "github.com"); app.setUsersCanEdit(editpermissions);
        casestudy = new Project();
        
        auto = new Company("auto", "AutoNomy", "AI Driving Company. based in Fan Srancisco", "leave the driving to us!");
        apple = new Company(); 
        
        internship = new Experience(UUID.randomUUID().toString(), auto.getId(), "Software Intern","Solved problems with code!");
        job = new Experience();
        experiences.add(internship);
		experiences.add(job);
        
        engineer = new JobPosting(UUID.randomUUID().toString(), auto.getId(), "123", "Autonomy Engineer", "This is a role that needs a lot of talents like being an engineer for example. Apart from that it doesnt really need any particular skills. You can apply for it but I dont think you will get this role tbh.", JobRecommendStrategy.EVERYONE);
        doctor = new JobPosting();
        
        emily = new Person("123","Emily Chen", "Gamer, and Computer Science major at Center College. A passionate software engineer with a knack for problem-solving and a love for coding!"
        		, job, experiences, PersonType.BASE); editpermissions.add(emily.getId()); emily.setUsersCanEdit(editpermissions);
        John = new Person(); Michael = new Person(); Newman = new Person(); Harshit = new Person(); Aadi = new Person(); Mril = new Person(); 
        John.setName("John Doe"); Michael.setName("John Doe"); Newman.setName("Newman Oldboy"); Harshit.setName("Harshit Chicho"); Aadi.setName("Aadi Jain"); Mril.setName("Mril D'silva");
        
        John.setBio("Curious traveler and food lover, John has visited over 30 countries and loves sharing stories from different cultures.");
        Michael.setBio("Software developer by day and aspiring novelist by night, Michael writes about the intersection of technology and human emotions.");
        Newman.setBio("Veteran film critic and history buff, Newman enjoys deep dives into the cinema of various eras and its impact on society.");
        Harshit.setBio("A passionate environmentalist, Harshit is actively involved in local conservation efforts and promotes sustainable living.");
        Aadi.setBio("Aadi is an entrepreneur who has founded multiple successful startups in the tech industry, focusing on innovative solutions to everyday problems.");
        Mril.setBio("Artist and musician, Mril creates expressive paintings and composes music that explores the depth of human experience.");

        REST = new Skill(); English = new Skill(); microsoft = new Company(); juggling = new Skill();
        REST.setName("REST APIs");
        REST.setTagline("Representational State Transfer");
        REST.setBio("Essential for web services and cloud applications, REST APIs allow for flexible, network-based interactions.");       
        English.setName("English Language");
        English.setTagline("Global Lingua Franca");
        English.setBio("The dominant language for global communication in business, science, information technology, and entertainment.");
        juggling.setName("Juggling");
        juggling.setTagline("Art of object manipulation");
        juggling.setBio("Not just a party trick, juggling improves hand-eye coordination, focus, and mental alertness.");
        microsoft.setName("Microsoft");
        microsoft.setTagline("Empowering every person and every organization on the planet to achieve more.");
        microsoft.setBio("Founded by Bill Gates and Paul Allen in 1975, Microsoft stands as a titan in the tech industry, known for its Windows operating systems, Office productivity suite, and Azure cloud services.");

        // Update these objects on the server
        ServerHandler.putSkillObject(REST);
        ServerHandler.putSkillObject(English);
        ServerHandler.putSkillObject(juggling);
        ServerHandler.putCompanyObject(microsoft);
       
      //persons population
        ServerHandler.putPersonObject(John);
        John.setType(PersonType.MENTOR);
        John.addViewer(emily.getId());
        John.addLink(Person.class, emily.getId());
        John.addLink(Skill.class, JAVA.getId());
        John.addLink(Project.class, app.getId());
        ServerHandler.updatePersonObject(John); 
        
        // Linking Michael
        Michael.addLink(Person.class, Newman.getId());
        Michael.addLink(Skill.class, JAVA.getId());
        Michael.addLink(Project.class, app.getId());
        ServerHandler.updatePersonObject(Michael);

        // Linking Newman
        Newman.addLink(Person.class, Harshit.getId());
        Newman.addLink(Skill.class, REST.getId());
        Newman.addLink(Project.class, casestudy.getId());
        ServerHandler.updatePersonObject(Newman);

        // Linking Harshit
        Harshit.addLink(Person.class, Aadi.getId());
        Harshit.addLink(Skill.class, English.getId());
        ServerHandler.updatePersonObject(Harshit);

        // Linking Aadi
        Aadi.addLink(Person.class, Mril.getId());
        Aadi.addLink(Skill.class, juggling.getId());
        ServerHandler.updatePersonObject(Aadi);

        // Linking Mril
        Mril.addLink(Person.class, emily.getId());
        Mril.addLink(Skill.class, py.getId());
        ServerHandler.updatePersonObject(Mril);
        
        
		ServerHandler.putPersonObject(emily); ServerHandler.putPersonObject(Michael); ServerHandler.putPersonObject(Newman); ServerHandler.putPersonObject(Harshit); ServerHandler.putPersonObject(Aadi); ServerHandler.putPersonObject(Mril);
		
        ServerHandler.putSkillObject(JAVA);
        JAVA.setUsersCanEdit(editpermissions); 
        ServerHandler.updateSkillObject(JAVA); 
        
     
        ServerHandler.putCompanyObject(auto); apple.setName("Apple"); apple.setTagline("not the fruit"); apple.addEditor("123");  apple.addLink(Skill.class, py.getId()); apple.addViewer("123"); apple.addLink(Person.class, "123"); apple.setBio("Apple Inc. is an American multinational corporation and technology company headquartered in Cupertino, California, in Silicon Valley. It designs, develops, and sells consumer electronics, computer software, and online services. Wikipedia");
        ServerHandler.putCompanyObject(apple);
        auto.setTagline("Setting people up for success");
        ServerHandler.updateCompanyObject(auto); //UPDATING OBJECT


        //project tests
        app.setTagline("A solo project by Emily! I might need friends.."); app.addLink(Person.class, emily.getId());
        ServerHandler.putProjectObject(app); ServerHandler.putProjectObject(casestudy);
       
        app.setOwnerID(emily.getId()); app.setUsersCanEdit(editpermissions);
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
        py.setName("python"); ServerHandler.putSkillObject(py);
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
		
		//giving emily friends & skills
		emily.addLink(Skill.class, py.getId());
		emily.addLink(Skill.class, JAVA.getId());
		emily.addLink(Project.class,app.getId());
		emily.addLink(Person.class, John.getId());
		emily.addLink(Person.class, Mril.getId());
		emily.addLink(Person.class, Newman.getId());
		emily.addLink(Person.class, Aadi.getId());
		emily.addLink(Person.class, Harshit.getId());
		ServerHandler.updatePersonObject(emily);
	}


}

