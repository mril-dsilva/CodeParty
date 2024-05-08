import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

import codeparty.Company;
import codeparty.JobPosting;
import codeparty.Person;
import codeparty.PersonType;
import codeparty.Project;
import codeparty.Skill;
import server.ServerHandler;


class RestServerTest
{
	Person emily;
	Person John;
	
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
        emily = new Person(UUID.randomUUID().toString(),"Emily Chen", "Gamer, and Computer Science major at Center College", null, null, PersonType.BASE);
        John = new Person();
	}

	@Test
	void test() {
		ServerHandler.putPersonObject(emily);

        Person a = ServerHandler.getPersonObject(emily.getId());
        
        assertEquals("Emily Chen", a.getName());
        assertEquals("Gamer, and Computer Science major at Center College", a.getBio());
        assertEquals(PersonType.BASE, a.getType());
        
        
        
		
	}

}

