package codeparty;

import java.util.Objects;

public abstract class Profile extends Page
{
	public Profile(String id, String name, String bio) {
		super(id);
		this.name = name;
		this.bio = bio;
		
		// TODO Auto-generated constructor stub
	}

	public Profile() {
		super();
		name = "John Doe";
		bio = "default bio";
	}

	String name;
	String bio;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bio, name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(bio, other.bio) && Objects.equals(name, other.name);
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
