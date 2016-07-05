package com.titanpay.accounting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.titanpay.accounting.view.PayrollSystemController;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    private PayrollSystemController processController;
    private static final String PERSISTENCE_UNIT_NAME = "titanpay";
    private static EntityManagerFactory factory;
    
    private List<Employee> employeeList;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Titan Pay");

        initRootLayout();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PayrollSystem.fxml"));
            rootLayout = (AnchorPane) loader.load();
            
            processController = loader.getController();
            processController.setMainApp(this);
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {

    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
    	
        	/*
        em.getTransaction().begin();
        HourlyEmployee test = new HourlyEmployee();
        test.setEmployeeId(3);
        test.setFirstName("Adam");
        test.setLastName("Burford");
        TimeCard t = new TimeCard();
        em.persist(t);
        test.addTimeCard(t);
        em.persist(test);
        
        SalariedEmployee test2 = new SalariedEmployee();
        em.persist(test2);
        em.getTransaction().commit();
        
        Query q = em.createQuery("select t from Employee t");
        List<Employee> todoList = q.getResultList();
        for (Employee todo : todoList) {
          System.out.println(todo);
        }
        System.out.println("Size: " + todoList.size());
        */
        
    	launch(args);
    }
    
    public void processPayroll() {
    	EntityManager em = factory.createEntityManager();
    	Query q = em.createQuery("select t from Employee t");
        employeeList = q.getResultList();
    	
    	LocalDate startDate = LocalDate.parse("2016-06-20");
    	LocalDate endDate = LocalDate.parse("2016-06-26");
    	
    	processController.outputText.clear();
    	processController.outputText.appendText("Processing payroll from " + startDate.toString() + " to " + endDate.toString() + '\n');
    	for (Employee e : employeeList) {
    		processController.outputText.appendText(e.pay(startDate, endDate) + '\n');
    	}
    }
    
    /* Make employee list and generate employees from data files */
    public void loadEmployees() {
    	
    	Scanner s = null;

    	// employeeList = new ArrayList<>();
    	EntityManager em = factory.createEntityManager();
    	em.getTransaction().begin();
    	
    	// Hourly Employee File
    	try {
    		s = new Scanner(new BufferedReader(new FileReader("data\\hourly_employees.csv")));
    		s.useDelimiter("[,\n]");
    		s.nextLine();
    		
    		while (s.hasNextLine()) {
    			HourlyEmployee e = new HourlyEmployee();
    			e.setEmployeeId(s.nextInt());
    			e.setLastName(s.next());
    			e.setFirstName(s.next());
    			e.setHourlyRate(s.nextDouble());
    			String str = s.next().trim();
    			e.setWeeklyDues(str.equals("-") ? 0.0 : Double.parseDouble(str));
    			str = s.next().trim();
    			
    			if (str == "DD")
    				e.setPaymentMethod(new DirectDepositPayment(e.getFullName(), "Test Bank", 00000000, 11111111));
    			else if (str == "PU")
    				e.setPaymentMethod(new PickUpPayment(e.getFullName()));
    			else
    				e.setPaymentMethod(new MailPayment(e.getFullName(), "6605 5TH AVE N, SAINT PETERSBURG FL 33710"));

    			em.merge(e);
    			//employeeList.add(e);
    			s.nextLine();
    		}
    	}
    	catch (FileNotFoundException e) {System.out.println("File Open Error");}
    	finally {
    		if (s != null)
    			s.close();
    	}

    	// Salaried Employee File
    	try {
    		s = new Scanner(new BufferedReader(new FileReader("data\\salaried_employees.csv")));
    		s.useDelimiter("[,\n]");
    		s.nextLine();
    		
    		while (s.hasNextLine()) {
    			if (!s.hasNext()) break;
    			
    			SalariedEmployee e = new SalariedEmployee();
    			e.setEmployeeId(s.nextInt());
    			e.setLastName(s.next());
    			e.setFirstName(s.next());
    			e.setSalary(s.nextDouble());
    			e.setCommissionRate(s.nextDouble());
    			String str = s.next().trim();
    			e.setWeeklyDues(str.equals("-") ? 0.0 : Double.parseDouble(str));
    			str = s.next().trim();
    			
    			//System.out.println(str);
    			if (str.equals("DD")) {

    				e.setPaymentMethod(new DirectDepositPayment(e.getFullName(), "Test Bank", 00000000, 11111111));
    			}
    			else if (str.equals("PU")) {

    				e.setPaymentMethod(new PickUpPayment(e.getFullName()));
    			}
    			else {

    				e.setPaymentMethod(new MailPayment(e.getFullName(), "6605 5TH AVE N, SAINT PETERSBURG FL 33710"));
    			}
    			
    			em.merge(e);
    			//employeeList.add(e);
    		}
    	}
    	catch (FileNotFoundException e) {System.out.println("File Open Error");}
    	finally {
    		if (s != null)
    			s.close();
    	}
    	
    	em.getTransaction().commit();
    }
    
    /* Opens the timecard csv file and adds timecards to their respective employee */
    public void loadTimeCards() {

    	EntityManager em = factory.createEntityManager();
    	Query q = em.createQuery("select t from Employee t");
        employeeList = q.getResultList();
        em.getTransaction().begin();
    	
    	Scanner s = null;
    	
    	try {
    		s = new Scanner(new BufferedReader(new FileReader("data\\timecards.csv")));
    		s.useDelimiter("[,\n]");
    		s.nextLine();
    		
    		while (s.hasNextLine()) {
    			if (!s.hasNext()) break;
    			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/dd/yyyy");
    			DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HHmmM/dd/yyyy");
    			int employeeId = s.nextInt();
    			String in = "0"+s.next();
    			String out = s.next();
    			String date = s.next().trim();
    			
    			LocalDate day = LocalDate.parse(date, dateFormat);
    			LocalDateTime timein = LocalDateTime.parse(in+date, timeFormat);
    			LocalDateTime timeout = LocalDateTime.parse(out+date, timeFormat);
    			
    			for (Employee e : employeeList) {
    				if (e.getEmployeeId() == employeeId) {
    					TimeCard t = new TimeCard(day, timein, timeout);
    					em.merge(t);
    					((HourlyEmployee)e).addTimeCard(t);
    					em.persist(e);
    					break;
    				}
    			}
    		}
    	}
    	catch (FileNotFoundException e) {System.out.println("File Open Error");}
    	finally {
    		if (s != null)
    			s.close();
    	}
    	
    	em.getTransaction().commit();
    }
    
    /* Opens the receipts csv file and adds receipts to their respective employee */
    public void loadReceipts() {
    	EntityManager em = factory.createEntityManager();
    	Query q = em.createQuery("select t from Employee t");
        employeeList = q.getResultList();
        em.getTransaction().begin();
    	
    	Scanner s = null;
    	
    	try {
    		s = new Scanner(new BufferedReader(new FileReader("data\\receipts.csv")));
    		s.useDelimiter("[,\n]");
    		s.nextLine();

    		while (s.hasNextLine()) {
    			if (!s.hasNext()) break;
    			
    			int i = s.nextInt();
    			s.next(); s.next(); s.next(); s.next();
    			
    			String str = s.next();
    			if (str.charAt(0) == '"')
					str += s.next();
					
				str = str.replace("\"", "");
    			double amount = Double.parseDouble(str.trim());
    			
    			Receipt r = new Receipt(LocalDate.parse("2016-06-20"), amount);
    			em.persist(r);
    			
    			for (Employee e : employeeList) {
    				if (e.getEmployeeId() == i) {
    					((SalariedEmployee)e).addReceipt(r);
    					em.merge(e);
    					break;
    				}
    			}		
    		}
    	}
    	catch (FileNotFoundException e) {System.out.println("File Open Error");}
    	finally {
    		if (s != null)
    			s.close();
    	}
    	
    	em.getTransaction().commit();
    }
}