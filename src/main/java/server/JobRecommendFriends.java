package server;

import codeparty.JobPosting;
import codeparty.Person;

public class JobRecommendFriends implements JobRecommenderCommand {
	
	public boolean recommendJob(JobPosting job, Person person) {
		
		if (person.hasLink(Person.class,job.getContactID())){
			System.out.println("exec");
			return true;
			
		}
		return false;
		
	}
	
}
