package codeparty;

import java.util.UUID;

public class Homepage extends Page
{
	Class<Page>[] ALLOWED_LINKS;
	
	public Homepage(UUID id, Class<Page>[] ALLOWED_LINKS) {
		super(id);
		// TODO Auto-generated constructor stub
		this.ALLOWED_LINKS = ALLOWED_LINKS;
	}

	/**
	 * @return the aLLOWED_LINKS
	 */
	public Class<Page>[] getALLOWED_LINKS() {
		return ALLOWED_LINKS;
	}
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}


	/**
	 * @param aLLOWED_LINKS the aLLOWED_LINKS to set
	 */
	public void setALLOWED_LINKS(Class<Page>[] aLLOWED_LINKS) {
		ALLOWED_LINKS = aLLOWED_LINKS;
	}
	
}
