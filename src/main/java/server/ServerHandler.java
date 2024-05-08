package server;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import codeparty.Company;
import codeparty.Experience;
import codeparty.JobPosting;
import codeparty.Person;
import codeparty.PersonType;
import codeparty.Project;
import codeparty.Skill;

public class ServerHandler {
	
	static RestClient client = RestClient.create();
	static String uriBase = "http://localhost:9000/v1";
	static String teamName = "linkedinfraudsters";

	
	public record RDesc(String request, String description, String location) {}; 
	public record PersonResult(String request, String description, String location, Person data) {};
	public record SkillResult(String request, String description, String location, Skill data) {};
	public record CompanyResult(String request, String description, String location, Company data) {};
	public record ProjectResult(String request, String description, String location, Project data) {};
	public record JobPostingResult(String request, String description, String location, JobPosting data) {};
	
	// Create TEAM - linkedinfraudsters
	public static void createTeam() { //check the parameters here
		
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
	
	// Create PAGES (individual)
	public static void createPages(String className) {
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
	
	//Create Pages (all)
	public static void createAllPages(ArrayList<String> pages) {
		
		for (String page : pages) {
	        createPages(page);
	    }
		
	}
	
	//POST Person Object
	public static void putPersonObject(Person P) {
		
		String objLocation = uriBase + "/" + teamName + "/" + "Person" + "/" + P.getId();
		
		
		// Check posting page class typ
		String post_result = client.post()
			.uri(objLocation)
			.contentType(MediaType.APPLICATION_JSON)
			.body(P)
			.retrieve()
			.body(String.class);
				
		System.out.println(post_result);
		
	}
	
	//POST Company Object
	public static void putCompanyObject(Company P) {
		
		String objLocation = uriBase + "/" + teamName + "/" + "Company" + "/" + P.getId();
		
		
		// Check posting page class typ
		String post_result = client.post()
			.uri(objLocation)
			.contentType(MediaType.APPLICATION_JSON)
			.body(P)
			.retrieve()
			.body(String.class);
				
		System.out.println(post_result);
		
	}
	
	//POST Project Object
	public static void putProjectObject(Project P) {
		
		String objLocation = uriBase + "/" + teamName + "/" + "Project" + "/" + P.getId();
		
		
		// Check posting page class typ
		String post_result = client.post()
			.uri(objLocation)
			.contentType(MediaType.APPLICATION_JSON)
			.body(P)
			.retrieve()
			.body(String.class);
				
		System.out.println(post_result);
		
	}
	
	//POST Skill object
	public static void putSkillObject(Skill P) {
		
		String objLocation = uriBase + "/" + teamName + "/" + "Skill" + "/" + P.getId();
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
	
	//POST JobPosting object
	public static void putJobPostingObject(JobPosting P) {
		
		String objLocation = uriBase + "/" + teamName + "/" + "JobPosting" + "/" + P.getId();
		String x  = P.getJobName();
		RDesc pageType = new RDesc(x, P.getBody(), objLocation);
		
		// Check posting page class typ
		String post_result = client.post()
			.uri(objLocation)
			.contentType(MediaType.APPLICATION_JSON)
			.body(pageType)
			.retrieve()
			.body(String.class);
		
		System.out.println(post_result);
	}
	
	//GET OBJECTS FROM SERVER
	public static Person getPersonObject(String id) { // Person
		
		PersonResult result = client.get()
				.uri(uriBase + "/" + teamName + "/" + "Person" + "/" + id)
				.retrieve()
				.body(PersonResult.class);
		
		System.out.println(result.data.getName());
		return result.data;
		
	}
	public static void getSkillObject(String id) { //Skill
		
		SkillResult result = client.get()
				.uri(uriBase + "/" + teamName + "/" + "Skill" + "/" + id)
				.retrieve()
				.body(SkillResult.class);
		
		System.out.println(result.data.getName());
		
	}

	public static void getProjectObject(String id) { //Project
		
		ProjectResult result = client.get()
				.uri(uriBase + "/" + teamName + "/" + "Project" + "/" + id)
				.retrieve()
				.body(ProjectResult.class);
		
		System.out.println(result.data.getName());
		
	}
	
	public static void getCompanyObject(String id) { //Company
		
		CompanyResult result = client.get()
				.uri(uriBase + "/" + teamName + "/" + "Company" + "/" + id)
				.retrieve()
				.body(CompanyResult.class);
		
		System.out.println(result.data.getName());
		
	}
	
	public static void getJobPostingObject(String id) { //JobPosting
		
		JobPostingResult result = client.get()
				.uri(uriBase + "/" + teamName + "/" + "JobPosting" + "/" + id)
				.retrieve()
				.body(JobPostingResult.class);
		
		System.out.println(result.data.getJobName());
		
	}
	
	
	public static void main(String args[]) {
		/*
		createTeam();
		ArrayList<String> pagesList = new ArrayList<String>();
        pagesList.add("Person");
        pagesList.add("Skill");
        pagesList.add("Company");
        pagesList.add("Project");
        pagesList.add("JobPosting");
        
        createAllPages(pagesList);
        Person emily = new Person();
        Skill java = new Skill();
        Company auto = new Company();
        Project app = new Project();
        JobPosting job = new JobPosting();
        
        putPersonObject(emily);
        putPersonObject(new Person());
        putSkillObject(java);
        putCompanyObject(auto);
        putProjectObject(app);
        putJobPostingObject(job);
        
        getPersonObject(emily.getId());
        getSkillObject(java.getId());
        getCompanyObject(auto.getId());
        getProjectObject(app.getId());
        getJobPostingObject(job.getId());
        */
	}
	
	//just feed page objects to the jackson in put methods - done
	// store responses in records to analyze them - do later
	// metadata issue - make sure to use records to organize the pieces when getting from server - DONE
	// default constructors for converting back from string to our object - Done
	// have getters and setters for everything - DONE
	
}
