package server;

import codeparty.JobPosting;
import codeparty.Person;

public class JobRecommendEveryone implements JobRecommenderCommand {
	
	public boolean recommendJob(JobPosting job, Person person) {
		//System.out.println("exec");
		return true;
	}
	
}
