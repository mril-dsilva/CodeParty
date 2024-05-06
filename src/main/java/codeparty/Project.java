package codeparty;

import java.util.UUID;

import java.awt.Image;

public class Project extends Profile
{
	public Project(String id, String name, String bio, Person owner, String tagline, String repositoryLink) {
		super(id,name, bio);
		this.owner = owner;
		this.tagline = tagline;
		this.repositoryLink = repositoryLink;

	}
	
	Person owner;
	String tagline;
	String repositoryLink;
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
	
}
