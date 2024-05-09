package main;

import java.util.HashMap;
import java.util.Map;

import codeparty.Company;
import codeparty.Experience;
import codeparty.JobPosting;
import codeparty.Page;
import codeparty.Person;
import codeparty.Skill;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.ViewTransitionModelInterface;
import models.ViewTransitionModel;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Map<String, Page> fakeData = populateFakeData();
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/mainView.fxml"));
		
		BorderPane view = loader.load();
		ViewTransitionModelInterface model = new ViewTransitionModel();
		//MainController controller = loader.getController();
		model.setFakeData(fakeData);
		model.setMainView(view);
		model.showLogin();
		
		
		Scene scene = new Scene(view);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public Map<String, Page> populateFakeData() {
		Map<String, Page> fakeData = new HashMap<>();
		
		// Insert fake objects here...
		Person person0 = new Person("123");
		person0.setName("Michael Bradshaw");
		Experience exp0 = new Experience();
		person0.setCurrentCompany(exp0);
		person0.setBio("I work hard in the day and in the night. "
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Donec egestas pretium ex, quis luctus ligula blandit quis. "
				+ "Suspendisse mattis quis justo noon egestas.");
		fakeData.put("123",person0);
		person0.addEditor("123");
		Person person1 = new Person("101");
		person1.setName("Jane Smith");
		person1.setBio("Jane is an aspiring artist who loves to paint landscapes in her free time."
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Donec egestas pretium ex, quis luctus ligula blandit quis. "
				+ "Suspendisse mattis quis justo non egestas.");
		Experience exp1 = new Experience();
		person1.setCurrentCompany(exp1);
		person1.addLink(Person.class, "123");
		person0.addLink(Person.class, "101");
		fakeData.put("101",person1);
		Person person2 = new Person("102");
		person1.setName("James Johnson");
		person1.setBio("James is a software engineer with a passion for building innovative applications."
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Donec egestas pretium ex, quis luctus ligula blandit quis. "
				+ "Suspendisse mattis quis justo non egestas.");
		Experience exp2 = new Experience();
		person2.setCurrentCompany(exp2);
		person2.addLink(Person.class, "123");
		person0.addLink(Person.class, "102");
		person2.addLink(Person.class, "101");
		person1.addLink(Person.class, "102");
		fakeData.put("102",person2);
		Person person3 = new Person("103");
		person1.setName("Emily Davis");
		person1.setBio("Emily is a dedicated teacher who enjoys inspiring young minds through education."
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Donec egestas pretium ex, quis luctus ligula blandit quis. "
				+ "Suspendisse mattis quis justo non egestas.");
		Experience exp3 = new Experience();
		person0.setCurrentCompany(exp3);
		person3.addLink(Person.class, "102");
		person0.addLink(Person.class, "103");
		fakeData.put("103",person3);
		
		Skill skill0 = new Skill("200");
		skill0.setName("Java");
		skill0.setBio("Ability to write efficient, clean code Java"
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Donec egestas pretium ex, quis luctus ligula blandit quis.");
		skill0.addLink(Person.class, "123");
		person0.addLink(Skill.class, "200");
		skill0.addLink(Person.class, "101");
		person1.addLink(Skill.class, "200");
		fakeData.put("200", skill0);
		Skill skill1 = new Skill("201");
		skill1.setName("Problem-Solving");
		skill1.setBio("Capability to analyze complex issues and devise effective solutions "
				+ "using logical reasoning and creativity. "
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Donec egestas pretium ex, quis luctus ligula blandit quis.");
		skill1.addLink(Person.class, "101");
		person1.addLink(Skill.class, "201");
		skill1.addLink(Person.class, "102");
		person2.addLink(Skill.class, "201");
		fakeData.put("201", skill1);
		Skill skill2 = new Skill("202");
		skill2.setName("Agile");
		skill2.setBio("Experience with Agile practices like Scrum or Kanban, "
				+ "enabling efficient project management and adaptation to change. "
				+ "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Donec egestas pretium ex, quis luctus ligula blandit quis.");
		skill2.addLink(Person.class, "102");
		person2.addLink(Skill.class, "202");
		skill2.addLink(Person.class, "103");
		person3.addLink(Skill.class, "203");
		fakeData.put("202", skill2);
		
		Company company0 = new Company("300");
		company0.setName("NovaTech Solutions, Inc.");
		company0.setBio("NovaTech Solutions specializes in providing cutting-edge technology solutions "
				+ "for businesses across various industries. From software development to IT consulting, "
				+ "NovaTech offers innovative solutions tailored to meet the unique needs of each client. "
				+ "With a team of skilled engineers and developers, NovaTech is committed to delivering excellence in every project.");
		company0.addLink(Person.class, "123");
		exp0.setCompanyID("300");
		company0.addLink(Person.class, "101");
		exp1.setCompanyID("300");
		fakeData.put("300", company0);
		Company company1 = new Company("301");
		company1.setName("GreenEco Ventures, LLC");
		company1.setBio("GreenEco Ventures is a sustainable technology company dedicated to developing eco-friendly solutions "
				+ "for a greener tomorrow. From renewable energy systems to waste management technologies, GreenEco Ventures "
				+ "focuses on leveraging innovation to address environmental challenges while promoting economic growth. "
				+ "With a passion for sustainability, GreenEco Ventures strives to make a positive impact on the planet.");
		company1.addLink(Person.class, "102");
		exp2.setCompanyID("301");
		fakeData.put("301", company1);
		Company company2 = new Company("302");
		company2.setName("Skyward Logistics Group");
		company2.setBio("Skyward Logistics Group is a global logistics and supply chain management company "
				+ "specializing in efficient transportation solutions. With a network of strategic partners and "
				+ "advanced logistics technologies, Skyward Logistics Group offers comprehensive services "
				+ "including freight forwarding, warehousing, and distribution.");
		company2.addLink(Person.class, "103");
		exp3.setCompanyID("302");
		fakeData.put("302", company2);
		
		JobPosting job0 = new JobPosting("400", "300");
		job0.setName("Senior Software Engineer");
		job0.setBody("NovaTech Solutions is seeking a Senior Software Engineer to join our dynamic team. "
				+ "The ideal candidate will have a strong background in software development, "
				+ "with proficiency in coding languages and a proven track record of delivering successful projects. "
				+ "Responsibilities include designing and implementing software solutions, "
				+ "collaborating with cross-functional teams, and ensuring the scalability and reliability of our applications");
		job0.addLink(Skill.class, "200");
		job0.addLink(Skill.class, "201");
		job0.addLink(Skill.class, "202");
		fakeData.put("400", job0);
		JobPosting job1 = new JobPosting("401", "301");
		job1.setName("Environmental Scientist");
		job1.setBody("GreenEco Ventures is seeking an Environmental Scientist to join our passionate team. "
				+ "The successful candidate will conduct research, analyze data, and develop strategies to "
				+ "address environmental challenges and promote sustainable practices. "
				+ "Responsibilities include conducting field studies, collaborating with stakeholders, "
				+ "and contributing to the development of eco-friendly technologies. "
				+ "If you are a dedicated environmental professional with a drive to make a difference, "
				+ "we encourage you to apply.");
		job1.addLink(Skill.class, "202");
		fakeData.put("401", job1);
		JobPosting job2 = new JobPosting("402", "302");
		job2.setName("Logistics Coordinator");
		job2.setBody("Skyward Logistics Group is seeking a Logistics Coordinator to join our fast-paced environment. "
				+ "The ideal candidate will be responsible for coordinating transportation, managing inventory, "
				+ "and liaising with clients and suppliers to ensure timely delivery of goods. "
				+ "Strong communication skills, attention to detail, and the ability to thrive in a "
				+ "dynamic work environment are essential for this role.");
		job2.addLink(Skill.class, "200");
		job2.addLink(Skill.class, "201");
		fakeData.put("402", job2);
		
		return fakeData;
	}
}
