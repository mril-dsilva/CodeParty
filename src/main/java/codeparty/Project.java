package codeparty;

import java.util.UUID;

import java.awt.Image;

public class Project extends Profile
{
	public Project(UUID id, Image profilePhoto, Image banner, String name, String bio, Person owner, String tagline, String repositoryLink) {
		super(id, profilePhoto, banner, name, bio);
		this.owner = owner;
		this.tagline = tagline;
		this.repositoryLink = repositoryLink;

	}
	
	Person owner;
	String tagline;
	String repositoryLink;
	// Class array representing allowed links
    Class<Page>[] ALLOWED_LINKS;
    // Getter for ALLOWED_LINKS
    public Class<Page>[] getAllowedLinks() {
        return ALLOWED_LINKS;
    }
	/**
	 * @return the owner
	 */
	public Person getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Person owner) {
		this.owner = owner;
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
	 * @return the repositoryLink
	 */
	public String getRepositoryLink() {
		return repositoryLink;
	}
	/**
	 * @param repositoryLink the repositoryLink to set
	 */
	public void setRepositoryLink(String repositoryLink) {
		this.repositoryLink = repositoryLink;
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
