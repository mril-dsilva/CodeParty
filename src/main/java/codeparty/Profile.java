package codeparty;

import java.util.UUID;
import java.awt.Image;

public abstract class Profile extends Page
{
	public Profile(UUID id, Image profilePhoto, Image banner, String name, String bio) {
		super(id);
		this.profilePhoto = profilePhoto;
		this.banner = banner;
		this.name = name;
		this.bio = bio;
		
		// TODO Auto-generated constructor stub
	}
	
	Image profilePhoto;
	Image banner;
	String name;
	String bio;
	
	/**
	 * @return the profilePhoto
	 */
	public Image getProfilePhoto() {
		return profilePhoto;
	}

	/**
	 * @param profilePhoto the profilePhoto to set
	 */
	public void setProfilePhoto(Image profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	/**
	 * @return the banner
	 */
	public Image getBanner() {
		return banner;
	}

	/**
	 * @param banner the banner to set
	 */
	public void setBanner(Image banner) {
		this.banner = banner;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}
	
}
