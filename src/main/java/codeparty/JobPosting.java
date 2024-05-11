package codeparty;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.UUID;

import codeparty.Skill;
import server.JobRecommendStrategy;

public class JobPosting extends Page
{
	String companyID;
	String contactID;
	String body;
	JobRecommendStrategy strat;

	
	public JobPosting(String id, String companyID, String contactID, String name, String body, JobRecommendStrategy strat) 
	{
		super(id);
		this.companyID = companyID;
		this.contactID = contactID;
		this.name = name;
		this.body = body;
		this.strat = strat;
		links.put(Skill.class, new ArrayList<String>());
		
	}
	
	public JobPosting() {
		super();
		companyID = "auto";
		name = "Engineer";
		body = "Engineer Products, what else!";
		// TODO Auto-generated constructor stub
		links.put(Skill.class, new ArrayList<String>());
		strat = JobRecommendStrategy.EVERYONE;
	}
	
	public JobPosting(String id, String companyID) {
		super(id);
		this.companyID = companyID;
		// TODO Auto-generated constructor stub
		links.put(Skill.class, new ArrayList<String>());
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
	public String getName() {
		return name;
	}

	/**
	 * @param name the jobName to set
	 */
	public void setName(String name) {
		this.name = name;
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
