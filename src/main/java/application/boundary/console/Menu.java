package application.boundary.console;

import application.control.Controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Menu {
  private final Controller controller;
  private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  
  public Menu(Controller controller) {
    this.controller = controller;
    }
  
  private void title(String title) {
    System.out.println(title);
    System.out.println("---------------------------------------".substring(0, title.length()));
    }
  
  private void item(int index, String name) {
    System.out.printf("%3d) %s\n", index, name);
    }
  
  private String choose(String text) {
    try {
      System.out.print(text+": ");
      return in.readLine();
      }
    catch (IOException ex) {
      Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
      return null;
      }
    }
  
  public String main() {
    title("Main menu");
    item(1, "List people");
    item(2, "Create new person");
    return choose("Select menu");
    }
  
  public void run() {
    String choice = main();
    while (!"EXIT".equals(choice)) {
      System.out.println("Choice was: "+choice);
      choice = main();
      }
    }
  
  
  
  
  }
