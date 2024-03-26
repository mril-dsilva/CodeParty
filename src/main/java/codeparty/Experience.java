package codeparty;

import java.util.GregorianCalendar;
import java.util.UUID;

public class Experience
{
	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}
	
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}


	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
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

	UUID id;
	Company company;
	String jobTitle;
	GregorianCalendar startDate;
	GregorianCalendar endDate;
	String description;
	
	public Experience(UUID id, Company company, String jobTitle, GregorianCalendar startDate, GregorianCalendar endDate,
			String description) {
		this.id = id;
		this.company = company;
		this.jobTitle = jobTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}
	
	
	
}
