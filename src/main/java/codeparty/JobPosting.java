package codeparty;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.UUID;

import server.JobRecommendStrategy;

public class JobPosting extends Page
{
	String id;
	String companyID;
	String contactID;
	String jobName;
	String body;
	GregorianCalendar datePosted;
	GregorianCalendar expiryDate;
	JobRecommendStrategy strat;

	
	public JobPosting(String id, String companyID, String contactID, String jobName, String body, GregorianCalendar datePosted,  
			GregorianCalendar expiryDate, JobRecommendStrategy strat) 
	{
		super(id);
		this.id = id;
		this.companyID = companyID;
		this.contactID = contactID;
		this.jobName = jobName;
		this.body = body;
		this.datePosted = datePosted;
		this.expiryDate = expiryDate;
		this.strat = strat;
		links.put(Skill.class, new ArrayList<String>());
		
	}
	
	public JobPosting() {
		super();
		this.id = UUID.randomUUID().toString();
		this.companyID = UUID.randomUUID().toString();
		this.contactID = UUID.randomUUID().toString();
		this.jobName = "Engineer";
		this.body = "Engineer Products, what else!";
		this.datePosted = new GregorianCalendar();
		this.expiryDate = new GregorianCalendar();
		// TODO Auto-generated constructor stub
		links.put(Skill.class, new ArrayList<String>());
		this.strat = JobRecommendStrategy.EVERYONE;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
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

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the datePosted
	 */
	public GregorianCalendar getDatePosted() {
		return datePosted;
	}

	/**
	 * @param datePosted the datePosted to set
	 */
	public void setDatePosted(GregorianCalendar datePosted) {
		this.datePosted = datePosted;
	}

	/**
	 * @return the expiryDate
	 */
	public GregorianCalendar getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(GregorianCalendar expiryDate) {
		this.expiryDate = expiryDate;
	}

}
