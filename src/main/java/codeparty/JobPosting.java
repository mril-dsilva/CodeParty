package codeparty;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.UUID;

public class JobPosting extends Page
{
	String id;
	Company company;
	Person contact;
	String jobName;
	String body;
	GregorianCalendar datePosted;
	GregorianCalendar expiryDate;

	
	public JobPosting(String id, Company company, Person contact, String jobName, String body, GregorianCalendar datePosted,  
			GregorianCalendar expiryDate) 
	{
		super(id);
		this.id = id;
		this.company = company;
		this.contact = contact;
		this.jobName = jobName;
		this.body = body;
		this.datePosted = datePosted;
		this.expiryDate = expiryDate;
		links.put(Skill.class, new ArrayList<String>());
		
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
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the contact
	 */
	public Person getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Person contact) {
		this.contact = contact;
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
