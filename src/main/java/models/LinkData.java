package models;

import models.pages.Page;

public class LinkData {

	String name;
	String ID;
	Class<? extends Page> type;
	/**
	 * @param name
	 * @param iD
	 * @param type
	 */
	public LinkData(String name, String ID, Class<? extends Page> type) {
		super();
		this.name = name;
		this.ID = ID;
		this.type = type;
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
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * @return the type
	 */
	public Class<? extends Page> getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Class<? extends Page> type) {
		this.type = type;
	}
	
	
}
