package codeparty;

import java.util.ArrayList;

import codeparty.JobPosting;
import codeparty.Person;
import codeparty.Skill;

public class Company extends Profile
{
	String tagline;
	
	
	public Company(String id, String name, String bio, String tagline) {
		super(id, name, bio);
		this.tagline = tagline;
		links.put(Person.class, new ArrayList<String>());
		links.put(Skill.class, new ArrayList<String>());
		links.put(JobPosting.class, new ArrayList<String>());
	}
	
	public Company(String id) {
		super();
		// TODO Auto-generated constructor stub
		links.put(Person.class, new ArrayList<String>());
		links.put(Skill.class, new ArrayList<String>());
		links.put(JobPosting.class, new ArrayList<String>());
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	public Company() {
		super();
		tagline = "default tagline!";
		name = "THE BORING COMPANY";
		// TODO Auto-generated constructor stub
		links.put(Person.class, new ArrayList<String>());
		links.put(Skill.class, new ArrayList<String>());
		links.put(JobPosting.class, new ArrayList<String>());		
	}
	/**
	 * 
	 * @return the tagline
	 */
	public String getTagline() {
		return tagline;
	}

	/**
	 * @param tagline the tagline to set
	 */
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	
}
