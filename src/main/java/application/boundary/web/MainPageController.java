package application.boundary.web;

import application.control.Controller;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "MainServlet", urlPatterns = {"/Main"})
public class MainPageController extends PageController {

  @Override
  protected String service(
      HttpServletRequest request,
      Controller controller
      ) {
    return "main.jsp";
    }
  
  }
