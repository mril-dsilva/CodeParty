package codeparty;

import java.util.UUID;

import java.awt.Image;

public class Company extends Profile
{
	String tagline;
	
	
	public Company(String id, String name, String bio, String tagline) {
		super(id, name, bio);
		this.tagline = tagline;
	
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @return the tagline
	 */
	public String getTagline() {
		return tagline;
	}

	/**
	 * @param tagline the tagline to set
	 */
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	
	
	
}
