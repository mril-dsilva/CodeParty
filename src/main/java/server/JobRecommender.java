package server;

import java.util.ArrayList;

import codeparty.JobPosting;
import codeparty.Person;
import codeparty.Skill;

public class JobRecommender {
	ArrayList<JobPosting> jobs = ServerHandler.retrieveAllJobs();
	
	ArrayList<JobRecommenderCommand> Commands[];
	
	
	public void recommendJobs(Person P)
	{
		//System.out.println(jobs);
		ArrayList<JobPosting> recommendedjobs = new ArrayList<JobPosting>();
		
		for (JobPosting j : jobs) {
			System.out.println(j.getName());
	        if (JobRecommend(j,P) == true) {
	        	//System.out.println(JobRecommend(j,P));
	        	
	        	recommendedjobs.add(j);
	        }
	    }
		
		ServerHandler.postAllJobs(recommendedjobs,P);
		
	}
	
	public boolean JobRecommend(JobPosting j, Person P){
		if (j.getStrat() == JobRecommendStrategy.EVERYONE) {
			JobRecommendEveryone jobev = new JobRecommendEveryone();
			boolean answer = jobev.recommendJob(j, P);
			return answer;
		}
		if (j.getStrat() == JobRecommendStrategy.SKILLS) {
			System.out.println("fsgs");
			JobRecommendSkills jobsk = new JobRecommendSkills();
			boolean answer = jobsk.recommendJob(j, P);
			return answer;
		}
		if (j.getStrat() == JobRecommendStrategy.FRIENDS) {
			JobRecommendFriends jobfr = new JobRecommendFriends();
			boolean answer = jobfr.recommendJob(j, P);
			return answer;
		}
		return false;
	}

//
//	private boolean JobRecommend(JobPosting j, Person p) {
//		// TODO Auto-generated method stub
//		return false;
//	}
}
