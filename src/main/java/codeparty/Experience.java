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
	 * @return the startDate
	 */
	public GregorianCalendar getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public GregorianCalendar getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
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
	GregorianCalendar startDate;
	GregorianCalendar endDate;
	String description;
	
	public Experience(String id, String company, String jobTitle, GregorianCalendar startDate, GregorianCalendar endDate,
			String description) {
		this.id = id;
		this.companyID = company;
		this.jobTitle = jobTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}
	
	public Experience() {
		this.id = UUID.randomUUID().toString();
		this.companyID = "defualt company";
		this.jobTitle = "Software Engineer";
		this.startDate = new GregorianCalendar();
		this.endDate = new GregorianCalendar();
		this.description = "Man";
	}
	
	
}
