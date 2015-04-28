package dk.cphbusiness.template.application;

import dk.cphbusiness.template.data.DatabasePersonMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Setup implements ServletContextListener {
  private String username = "aka";
  private String password = "aka";
  private String driver = "oracle.jdbc.driver.OracleDriver";
  private String url = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:DAT";

  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      System.out.println("Application started");
      ServletContext application = event.getServletContext();
      application.setAttribute("mapper", new DatabasePersonMapper(driver, url, username, password));
      }
    catch (ClassNotFoundException ex) {
      Logger.getLogger(Setup.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    System.out.println("Application closed");
    }

  }
