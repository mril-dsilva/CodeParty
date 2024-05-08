package server;

import codeparty.JobPosting;
import codeparty.Person;
import codeparty.Skill;

public class JobRecommendSkills implements JobRecommenderCommand {
	
	public boolean recommendJob(JobPosting job, Person person) {
		
		for (String s : job.getLinks().get(Skill.class)) {
	        if (person.hasLink(Skill.class, s)){
	        	return true;
	        }
	    }
		
		return false;
	}
	
}
