package models;

import java.util.ArrayList;
import java.util.Map;

import javafx.scene.layout.BorderPane;
import models.pages.Page;
import models.pages.Person;

public interface ViewTransitionModelInterface {
	public void setFakeData(Map<String, Page> fakeData);
	public void setMainView(BorderPane mainView);
	public void setCurrentUserID(String id);
	public void showLogin();
	public void showCurrentUserFromLogin();
	public void showCurrentUser();
	public void showHome();
	public void showUser(String id);
	public void showUserEdit(String id);
	public void showCompany(String id);
	public void showCompanyEdit(String id);
	public void showSkill(String id);
	public void showSkillEdit(String id);
	public void showJobPosting(String id);
	public void showJobPostingEdit(String id);
	public Page getObject(String id);
	public <T extends Page> ArrayList<T> getAllObjectsOfType(Class<T> type);
	public <T extends Page> void showListOfAll(Class<T> type);
	public <T extends Page> void showListOfLinks(Page page, Class<T> type);
	public Person getCurrentUser();
	public ArrayList<Page> getLinksOf(String id, Class<? extends Page> linkType);
	public void addLinkToCurrentUser(String idToAdd, Class<? extends Page> linkType);
	public boolean canEdit(Page page);
}
