package codeparty;

import java.util.GregorianCalendar;
import java.util.UUID;

public class Experience
{
	/**
	 * @return the company
	 */
	public String getCompanyID() {
		return companyID;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	
	/**
	 * @param company the company to set
	 */
	public void setCompanyID(String company) {
		this.companyID = company;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	String id;
	String companyID;
	String jobTitle;
	String description;
	
	public Experience(String id, String company, String jobTitle,
			String description) {
		this.id = id;
		this.companyID = company;
		this.jobTitle = jobTitle;
		this.description = description;
	}
	
	public Experience() {
		this.companyID = "defualt company";
		this.jobTitle = "Software Engineer";
		this.description = "Random Experiences of a Soft eng";
	}
	
	
}
