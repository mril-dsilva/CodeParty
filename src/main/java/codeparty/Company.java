package codeparty;

import java.util.UUID;

import javafx.scene.image.Image;

public class Company extends Profile
{
	String tagline;
	Class<Page>[] ALLOWED_LINKS;
	
	public Company(UUID id, Image profilePhoto, Image banner, String name, String bio, String tagline, Class<Page>[] ALLOWED_LINKS) {
		super(id, profilePhoto, banner, name, bio);
		this.tagline = tagline;
		this.ALLOWED_LINKS = ALLOWED_LINKS;
	
	}
	
	/**
	 * @return the id
	 */
	public UUID getId() {
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

	/**
	 * @return the aLLOWED_LINKS
	 */
	public Class<Page>[] getALLOWED_LINKS() {
		return ALLOWED_LINKS;
	}

	/**
	 * @param aLLOWED_LINKS the aLLOWED_LINKS to set
	 */
	public void setALLOWED_LINKS(Class<Page>[] aLLOWED_LINKS) {
		ALLOWED_LINKS = aLLOWED_LINKS;
	}
	
	
	
}
