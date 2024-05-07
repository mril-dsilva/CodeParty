package codeparty;

import java.util.GregorianCalendar;

public class Request
{
	String id;
	String message;
	Person person;
	GregorianCalendar dateCreated;
	
	public Request(String id, String message,Person person,GregorianCalendar dateCreated)
	{
		this.id = id;
		this.message = message;
		this.person = person;
		this.dateCreated = dateCreated;
		
	}
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the dateCreated
	 */
	public GregorianCalendar getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(GregorianCalendar dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
