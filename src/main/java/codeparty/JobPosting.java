package codeparty;

import java.util.GregorianCalendar;
import java.util.UUID;

public class JobPosting extends Page
{
	UUID id;
	Company company;
	Person contact;
	String jobName;
	String body;
	GregorianCalendar datePosted;
	GregorianCalendar expiryDate;
	Class<Page>[] ALLOWED_LINKS;
	
	public JobPosting(UUID id, Company company, Person contact, String jobName, String body, GregorianCalendar datePosted,  
			GregorianCalendar expiryDate, Class<Page>[] ALLOWED_LINKS) 
	{
		super(id);
		this.company = company;
		this.contact = contact;
		this.jobName = jobName;
		this.body = body;
		this.datePosted = datePosted;
		this.expiryDate = expiryDate;
		this.ALLOWED_LINKS = ALLOWED_LINKS;
		
	}
	
}
