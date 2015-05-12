package application.boundary.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import application.control.Controller;
import application.control.NoSuchPersonException;
import application.control.PersonDetail;
import application.control.PersonSummary;
import application.control.simple.SimpleController;
import application.entity.Facade;
import application.entity.database.DatabaseFacade;

public class Program {
  private final Controller controller;
  private final BufferedReader in;
  private static final int MAIN = 1;
  private static final int LIST = 2;
  private static final int EDIT = 3;
  private static final int ERROR = 9;

  public Program(Controller controller) {
    this.controller = controller;
    in = new BufferedReader(new InputStreamReader(System.in));
    }
  
  public int readChoice() {
    try {
      int key = in.read();
      while (key == 10) key = in.read();
      System.out.println("Key was: "+(key - 48));
      return key - 48;
      }
    catch (IOException ioe) {
      return -1;
      }
    }
  
  public String readString(String original) {
    try {
      if (original != null) System.out.print(" ("+original+")");
      String value = in.readLine();
      if (value == null || value.isEmpty()) return original;
      return value;
      }
    catch (IOException ex) {
      Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
      return null;
      }
    }
  
  public int readInteger(int original) {
    try {
      System.out.print(" ("+original+")");
      String value = in.readLine();
      if (value == null || value.isEmpty()) return original;
      return Integer.valueOf(value);
      }
    catch (IOException ex) {
      Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
      return 0;
      }
    }
  
  public int showListMenu() {
    System.out.println("List menu");
    System.out.println("---------");
    System.out.println("0) Main menu");
    for (PersonSummary person : controller.list()) {
      System.out.println(""+person.getId()+") "+person.getName());
      }
    int id = readChoice();
    switch (id) {
      case 0: return MAIN;
      case -1: return LIST;
      default: showEditMenu(id);
      }
    return -9;
    }
  
  public void showEditMenu(int id) {
    System.out.println("Edit menu");
    System.out.println("---------");
    PersonDetail person = null;
    try {
      if (id == 0) person = new PersonDetail();
      else person = controller.find(id);
      }
    catch (NoSuchPersonException nspe) {
      System.err.println("No such person #"+nspe.getId());
      showMainMenu();
      }
    System.out.print("First Name"); person.setFirstName(readString(person.getFirstName()));
    System.out.print("Last Name"); person.setLastName(readString(person.getLastName()));
    System.out.print("Email"); person.setLastName(readString(person.getEmail()));
    System.out.print("Age"); person.setAge(readInteger(person.getAge()));
    controller.save(person);
    showListMenu();
    }
  
  public void showMainMenu() {
    System.out.println("Main menu");
    System.out.println("---------");
    System.out.println("1) List people");
    System.out.println("2) Create person");
    int choice = readChoice();
    switch (choice) {
      case 1: showListMenu(); break;
      case 2: showEditMenu(0); break;
      default: showMainMenu(); 
      }
    }
  
  public static void main(String[] args) {
    try {
      ResourceBundle bundle = ResourceBundle.getBundle("template.boundary.console.Program");
      String username = bundle.getString("template.entity.database.username");
      String password = bundle.getString("template.entity.database.password");
      String driver = bundle.getString("template.entity.database.driver");
      String url = bundle.getString("template.entity.database.url");
      Facade facade = new DatabaseFacade(driver, url, username, password);
      Controller controller = new SimpleController(facade);
      Program program = new Program(controller);
      program.showMainMenu();
      }
    catch (ClassNotFoundException ex) {
      System.err.println(ex);
      }
    }
  
  }
