package server;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import codeparty.Page;
import codeparty.Person;
import codeparty.PersonType;

public interface ServerHandler {
	
	RestClient client = RestClient.create();
	String uriBase = "http://localhost:9000/v1";
	String teamName = "linkedinfraudsters";
	
	public record RDesc(String name, String description, String location) {}; //do we need the description or not? I have removed it
	
	public static void createTeam(RestClient client) { //check the parameters here
		
		String teamDesc = "cool team";
		String teamLocation = uriBase + "/" + teamName;
		RDesc team = new RDesc(teamName,teamDesc, teamLocation);
		
		//delete if exists
		client.delete()
		.uri("http://localhost:9000/v1/" + teamName)
		.retrieve();
		
		// Check posting team
		System.out.println("Here");
		String post_result = client.post()
				.uri(teamLocation)
				.contentType(MediaType.APPLICATION_JSON)
				.body(team)
				.retrieve()
				.body(String.class);
		
		System.out.println(post_result);
		
	}
	
	public static void createPages(RestClient client,  String className) {
		String classLocation = uriBase + "/" + teamName + "/" + className;
		String classDesc = className + "added to the server";
		RDesc pageType = new RDesc(className, classDesc, classLocation);
		
		// Check posting page class type
		String post_result = client.post()
			.uri(classLocation)
			.contentType(MediaType.APPLICATION_JSON)
			.body(pageType)
			.retrieve()
			.body(String.class);
				
		System.out.println(post_result);
		
	}
	
	public static void createAllPages(ArrayList<String> pages) {
		
		for (String page : pages) {
	        createPages(client, page);
	    }
		
	}
	
	
	public static void putPersonObject(Person P) {
		
		String objLocation = uriBase + "/" + teamName + "/" + "Person" + "/" + P.getId();
		String x  = P.getName();
		RDesc pageType = new RDesc(x, P.getBio(), objLocation);
		
		// Check posting page class typ
		String post_result = client.post()
			.uri(objLocation)
			.contentType(MediaType.APPLICATION_JSON)
			.body(pageType)
			.retrieve()
			.body(String.class);
				
		System.out.println(post_result);
		
	}
	
	public static void getObject(String id, Class<?> type) {
		
		
	}
	
	public static void main(String args[]) {
		createTeam(client);
		ArrayList<String> pagesList = new ArrayList<String>();
        pagesList.add("Person");
        pagesList.add("Skill");
        pagesList.add("Company");
        pagesList.add("Project");
        
        createAllPages(pagesList);
        Person emily = new Person(UUID.randomUUID().toString(),"Emily Chen", "Gamer, and Computer Science major at Center College", null, null, PersonType.BASE);
        putPersonObject(emily);
		
	}
	
}
