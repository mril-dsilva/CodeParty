import java.io.IOException;

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
		
//		robot.clickOn("#home");
//		
//		robot.clickOn("#profile");
//		Thread.sleep(1000);
//		
//		robot.clickOn("#edit");
//		clearAllText(robot,"#nameInput",15);
//		robot.clickOn("#nameInput");
//		robot.write("Emily L Chen");
//		
//		robot.clickOn("#bioInput");
//		robot.push(javafx.scene.input.KeyCode.END);
//		robot.write(" Oh and I also like to make blueberry tres leches cake!");
//		
//		robot.clickOn("#roleInput");
//		robot.push(javafx.scene.input.KeyCode.HOME);
//		robot.write("Lead ");
//		
//		robot.clickOn("#update");
//		Thread.sleep(1000);
//		
//		//CHECKING ALL LISTS 
//		robot.clickOn("#friendsListButton");
//		robot.clickOn("#profile");
//		robot.clickOn("#skillsListButton");
//		robot.clickOn("#profile");
//		robot.clickOn("#projectsListButton");
//		robot.clickOn("#profile");
//		robot.clickOn("#jobsListButton");
//		robot.clickOn("#profile");
		
		robot.clickOn("#home");
		robot.clickOn("#peopleAll");
		selectItem(robot,0);
		//ObservableList<Page> people = getItems(robot).getItems();
		//System.out.println(people);
		
		
		robot.clickOn("#home");
		robot.clickOn("#projectsAll");
		robot.clickOn("#home");
		robot.clickOn("#skillsAll");
		robot.clickOn("#home");
		robot.clickOn("#jobsAll");
		robot.clickOn("#home");
		robot.clickOn("#companiesAll");
		robot.clickOn("#home");
		
		
		
		
		
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
		 Assertions.assertThat(robot.lookup("#desc")
			        .queryAs(TextArea.class)).hasText(text);   
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
	/*
	//Subtraction helper
	private void subtract(String num1, String num2, FxRobot robot) {
		robot.clickOn("#num1Input");
		robot.write(num1);
		robot.clickOn("#num2Input");
		robot.write(num2);
		robot.clickOn("#subtractButton");
	}
	
	//Multiply helper
	private void multiply(String num1, String num2, FxRobot robot) {
		robot.clickOn("#num1Input");
		robot.write(num1);
		robot.clickOn("#num2Input");
		robot.write(num2);
		robot.clickOn("#multiplyButton");
	}
	
	//Divide helper
	private void divide(String num1, String num2, FxRobot robot) {
		robot.clickOn("#num1Input");
		robot.write(num1);
		robot.clickOn("#num2Input");
		robot.write(num2);
		robot.clickOn("#divideButton");
	}
	
	//CheckResult
	private void check(String result, FxRobot robot) {
		Assertions.assertThat(robot.lookup("#resultText")
				.queryAs(Label.class)).hasText(result);
	}
	

	@SuppressWarnings("unchecked")
	private ListView<Operation> getHistory(FxRobot robot){
		return (ListView<Operation>) robot.lookup("#historyList")
				.queryAll().iterator().next();
	}

	@Test
	public void TestCalculator(FxRobot robot) {
		try
		{
			//Check if History is empty
			ListView<Operation> operations = getHistory(robot);
			System.out.println(operations);
			
			Assertions.assertThat(operations).isEmpty();
			
			//ADD
			String num1 = "7";
			String num2 = "10";
			add(num1,num2,robot); //checked addition
			//Thread.sleep(1000);
			String result = "17";
			check(result,robot); //checked result

			//SUBTRACT
			subtract(num1,num2,robot); //checked subtraction
			//Thread.sleep(1000);
			String result2 = "-3";
			check(result2,robot); //checked result

			//MULTIPLY
			multiply(num1,num2,robot); //checked multiplication
			//Thread.sleep(1000);
			String result3 = "70";
			check(result3,robot); //checked result
			
			//DIVIDE
			divide(num1,num2,robot); //checked division
			//Thread.sleep(1000);
			String result4 = "0.7";
			check(result4,robot); //checked result
			
			//DIVIDE EDGE CASE (DIVIDE BY ZERO)
			String num3 = "0";
			divide(num1,num3,robot); //checked division
			Thread.sleep(1000);
			String result5 = "NaN";
			check(result5,robot); //checked result
			
			ObservableList<Operation> items = FXCollections.observableArrayList(
					new Operation(7.0, " + ", 10.0, 17.0),
	                new Operation(7.0, " - ", 10.0, -3.0),
	                new Operation(7.0, " * ", 10.0, 70.0),
	                new Operation(7.0, " / ", 10.0, 0.7)
			);
			
			Assertions.assertThat(operations).isNotEmpty();
			System.out.println(operations);
			
			for(Operation i:items) {
				
				Assertions.assertThat(operations).hasListCell(i);
				
			}
			
			
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
