package server;

import codeparty.JobPosting;
import codeparty.Person;

public interface JobRecommenderCommand {
	boolean recommendJob(JobPosting job, Person person);
	
}
