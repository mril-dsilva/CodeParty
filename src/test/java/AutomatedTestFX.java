import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;

import codeparty.Company;
import codeparty.JobPosting;
import codeparty.Page;
import codeparty.Person;
import codeparty.Project;
import codeparty.Skill;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.Main;
import model.ItemData;
import models.LoginModel;
import models.ViewTransitionModel;
import models.ViewTransitionModelInterface;
import server.ServerHandler;
import views.MainController;


@ExtendWith(ApplicationExtension.class)
public class AutomatedTestFX {
	
	@Start // Before
	private void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/mainView.fxml"));
		
		BorderPane view = loader.load();
		ViewTransitionModelInterface model = new ViewTransitionModel();
		
		model.setMainView(view);
		model.showLogin();
		
		Scene scene = new Scene(view);
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}
	
	//LOGIN
	@Test
	public void test(FxRobot robot) throws InterruptedException {
		
		MVCTestSetup mvcTestSetup = new MVCTestSetup();
		mvcTestSetup.main();

		
		
		//LOGIN & USER PROFILE EDITING
		LoginModel m = new LoginModel();
		robot.clickOn("#userText");
		robot.write(m.getUsername());
		robot.clickOn("#passText");
		robot.write(m.getPassword());
		robot.clickOn("#submitButton");
		
		robot.clickOn("#home");
		
		robot.clickOn("#profile");
		Thread.sleep(1000);
		
		robot.clickOn("#edit");
		clearAllText(robot,"#nameInput",15);
		robot.clickOn("#nameInput");
		robot.write("Emily L Chen");
		
		robot.clickOn("#bioInput");
		robot.push(javafx.scene.input.KeyCode.END);
		robot.write(" Oh and I also like to make blueberry tres leches cake!");
		
		robot.clickOn("#roleInput");
		robot.push(javafx.scene.input.KeyCode.HOME);
		robot.write("Lead ");
		
		robot.clickOn("#update");
		Thread.sleep(1000);
		
		//CHECKING ALL LISTS 
		robot.clickOn("#friendsListButton");
		robot.clickOn("#profile");
		robot.clickOn("#skillsListButton");
		robot.clickOn("#profile");
		robot.clickOn("#projectsListButton");
		robot.clickOn("#profile");
		robot.clickOn("#jobsListButton");
		robot.clickOn("#profile");
		
		
		robot.clickOn("#home");
		robot.clickOn("#peopleAll");
		
		ArrayList<Person> allpeople = ServerHandler.retrieveAllPersons();
		ArrayList<Project> allprojects = ServerHandler.retrieveAllProjects();
		ArrayList<Skill> allskills = ServerHandler.retrieveAllSkills();
		ArrayList<Company> allcompanies = ServerHandler.retrieveAllCompanys();
		ArrayList<JobPosting> alljobs = ServerHandler.retrieveAllJobs();
		
		for (int i = 0; i < allpeople.size(); i++) {
			
		    System.out.println("Interacted with: " + allpeople.get(i).getName());
		    selectItem(robot,i);
		    checkTextValue(robot,allpeople.get(i).getName()); //checking ALL PEOPLES list
		    Thread.sleep(50);
		    robot.clickOn("#home");
		    robot.clickOn("#peopleAll");
			
		}
		
		
		for (int i = 0; i < allprojects.size(); i++) {
			robot.clickOn("#home");
		    robot.clickOn("#projectsAll");
			
		    System.out.println("Interacted with: " + allprojects.get(i).getName());
		    selectItem(robot,i);
		    checkTextValue(robot,allprojects.get(i).getName()); //checking ALL PROJECTS list
		    Thread.sleep(50);
		    
			
		}
		
		robot.clickOn("#home");
		robot.clickOn("#skillsAll");
		
		for (int i = 0; i < allskills.size(); i++) {
			
		    System.out.println("Interacted with: " + allskills.get(i).getName());
		    selectItem(robot,i);
		    checkTextValue(robot,allskills.get(i).getName()); //checking ALL SKILLS list
		    Thread.sleep(50);
		    robot.clickOn("#home");
		    robot.clickOn("#skillsAll");
			
		}
		
		robot.clickOn("#home");
		robot.clickOn("#jobsAll");
		
		for (int i = 0; i < alljobs.size(); i++) {
			
		    System.out.println("Interacted with: " + alljobs.get(i).getName());
		    selectItem(robot,i);
		    checkTextValue(robot,alljobs.get(i).getName()); //checking ALL jobs list
		    Thread.sleep(50);
		    robot.clickOn("#home");
		    robot.clickOn("#jobsAll");
			
		}
		
		robot.clickOn("#home");
		robot.clickOn("#companiesAll");
		
		for (int i = 0; i < allcompanies.size(); i++) {
			
		    System.out.println("Interacted with: " + allcompanies.get(i).getName());
		    selectItem(robot,i);
		    checkTextValue(robot,allcompanies.get(i).getName()); //checking ALL jobs list
		    Thread.sleep(50);
		    robot.clickOn("#home");
		    robot.clickOn("#companiesAll");
			
		}
		
		robot.clickOn("#home");
		robot.clickOn("#profile");
		robot.clickOn("#skillsListButton"); robot.clickOn("Java Programming");
		
		robot.clickOn("#editButton");
		clearAllText(robot,"#nameText",16);
		robot.clickOn("#nameText");
		robot.write("Java");
		robot.clickOn("#bioText");
		robot.push(javafx.scene.input.KeyCode.END);
		robot.write(". I am taking Emily's permissions to edit this page now. Let's see if the server updates the prototype.");
		robot.clickOn("#editButton");
		Skill java = ServerHandler.getSkillObject("java");
		java.setUsersCanEdit(new ArrayList<String>());
		ServerHandler.updateSkillObject(java);
		robot.clickOn("#profile");
		robot.clickOn("#skillsListButton"); robot.clickOn("Java");
		Thread.sleep(500);
		
		robot.clickOn("#profile");
		robot.clickOn("#jobsListButton"); robot.clickOn("pythonskillJob");
		robot.clickOn("#applyButton");
		Thread.sleep(500);
		robot.clickOn("#home");
		robot.clickOn("#peopleAll"); robot.clickOn("NEWMAN");
		robot.clickOn("#jobsListButton"); Thread.sleep(500);
		
		robot.clickOn("#profile");
		robot.clickOn("#projectsListButton"); robot.clickOn("Mobile App");
		robot.clickOn("#friendsListButton"); robot.clickOn("Emily L Chen");
		robot.clickOn("#projectsListButton"); robot.clickOn("Mobile App");
		robot.clickOn("#friendsListButton"); robot.clickOn("Emily L Chen");
		robot.clickOn("#profile");
		
	}
	

	
	private void selectItem(FxRobot robot, int index)
	  {
		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Platform.runLater(()->{
			  ListView<Person> items = getPersonItems(robot);
			  items.scrollTo(index);
			  items.getSelectionModel().clearAndSelect(index);
			 // items.getSelectionModel().
		  });
		  
		  WaitForAsyncUtils.waitForFxEvents();
	}
	
	
	@SuppressWarnings("unchecked")
	  ListView<Page> getItems(FxRobot robot)

	  {
	   return (ListView<Page>) robot.lookup("#listview")
	       .queryAll().iterator().next();
	  }
	
	@SuppressWarnings("unchecked")
	  ListView<Person> getPersonItems(FxRobot robot)

	  {
	   return (ListView<Person>) robot.lookup("#listview")
	       .queryAll().iterator().next();
	  }
	
		@SuppressWarnings("unchecked")
		ListView<Skill> getSkillItems(FxRobot robot, String id)

		{
			return (ListView<Skill>) robot.lookup(id)
					.queryAll().iterator().next();
	  	}
		
		@SuppressWarnings("unchecked")
		ListView<Project> getProjectItems(FxRobot robot, String id)

		{
			return (ListView<Project>) robot.lookup(id)
					.queryAll().iterator().next();
	  	}
		
		@SuppressWarnings("unchecked")
		ListView<Company> getCompanyItems(FxRobot robot, String id)

		{
			return (ListView<Company>) robot.lookup(id)
					.queryAll().iterator().next();
	  	}
		
		@SuppressWarnings("unchecked")
		ListView<JobPosting> getJobPostingItems(FxRobot robot, String id)

		{
			return (ListView<JobPosting>) robot.lookup(id)
					.queryAll().iterator().next();
	  	}
	
	

	private void checkTextValue(FxRobot robot,String text)
	{
		 Assertions.assertThat(robot.lookup("#nameLabel")
			        .queryAs(Label.class)).hasText(text);   
	}
	
	public void clearAllText(FxRobot robot, String cssid, int textLength) {
	    
		robot.clickOn(cssid);
	    // Move to the end of the text
	    robot.push(javafx.scene.input.KeyCode.END);
	    
	    
	    // Erase all text by backspacing
	    for (int i = 0; i < textLength; i++) {
	        robot.push(javafx.scene.input.KeyCode.BACK_SPACE);
	    }
	    
	}

}
