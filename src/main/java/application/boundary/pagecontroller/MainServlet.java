package application.boundary.pagecontroller;

import application.control.Controller;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "MainServlet", urlPatterns = {"/Main"})
public class MainServlet extends BaseServlet {

  @Override
  protected String service(
      HttpServletRequest request,
      Controller controller
      ) {
    return "main.jsp";
    }
  
  }
