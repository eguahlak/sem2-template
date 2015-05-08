package template.boundary.web;

import template.control.Controller;
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
