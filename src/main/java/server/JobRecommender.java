package server;

import java.util.ArrayList;

import codeparty.JobPosting;
import codeparty.Person;

public class JobRecommender {
	ServerHandler S;
	ArrayList<JobPosting> JobPostings;
	ArrayList<JobRecommenderCommand> Commands[];

	public void recommendJobs(Person P, ServerHandler S)
	{
		ArrayList<JobPosting> recommendedjobs = new ArrayList<JobPosting>();
		
		
		/*
		Create a recommendedJobs ArrayList
		Retrieve all JobPostings from server
		Iterate through all JobPostings
		Choose JobRecommenderCommand based on JobRecommendStrategy in JobPosting, execute its recommendJob() function.


		JobRecommenderCommand returns true or false
		Add JobPosting to recommendedJobs ArrayList if true


		Return recommendedJobs ArrayList
		*/
		
		
	}
}
