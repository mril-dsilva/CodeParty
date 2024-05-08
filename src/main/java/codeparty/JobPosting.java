package codeparty;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.UUID;

import server.JobRecommendStrategy;

public class JobPosting extends Page
{
	String companyID;
	String contactID;
	String jobName;
	String body;
	JobRecommendStrategy strat;

	
	public JobPosting(String id, String companyID, String contactID, String jobName, String body, JobRecommendStrategy strat) 
	{
		super(id);
		this.companyID = companyID;
		this.contactID = contactID;
		this.jobName = jobName;
		this.body = body;
		this.strat = strat;
		links.put(Skill.class, new ArrayList<String>());
		
	}
	
	public JobPosting() {
		super();
		companyID = UUID.randomUUID().toString();
		contactID = UUID.randomUUID().toString();
		jobName = "Engineer";
		body = "Engineer Products, what else!";
		// TODO Auto-generated constructor stub
		links.put(Skill.class, new ArrayList<String>());
		strat = JobRecommendStrategy.EVERYONE;
	}

	/**
	 * @return the company
	 */
	public String getCompanyID() {
		return companyID;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	/**
	 * @return the contact
	 */
	public String getContactID() {
		return contactID;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	public JobRecommendStrategy getStrat() {
		return strat;
	}

	public void setStrat(JobRecommendStrategy strat) {
		this.strat = strat;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

}
