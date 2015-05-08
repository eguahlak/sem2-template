package template.application;

import template.entity.database.DatabaseFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Setup implements ServletContextListener {
//  private String username = "aka";
//  private String password = "aka";
//  private String driver = "oracle.jdbc.driver.OracleDriver";
//  private String url = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:DAT";

  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      Logger.getLogger(Setup.class.getName()).log(Level.INFO, "Application started");
      ServletContext application = event.getServletContext();
      String username = application.getInitParameter("USERNAME");
      String password = application.getInitParameter("PASSWORD");
      String driver = application.getInitParameter("DRIVER");
      String url = application.getInitParameter("DB-URL");
      
      application.setAttribute("mapper", new DatabaseFacade(driver, url, username, password));
      }
    catch (ClassNotFoundException ex) {
      Logger.getLogger(Setup.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    Logger.getLogger(Setup.class.getName()).log(Level.INFO, "Application stopped");
    }

  }
