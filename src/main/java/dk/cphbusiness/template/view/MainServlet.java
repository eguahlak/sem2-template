package dk.cphbusiness.template.view;

import dk.cphbusiness.template.contract.PersonController;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainServlet", urlPatterns = {"/Main"})
public class MainServlet extends BaseServlet {

  @Override
  protected String service(
      HttpServletRequest request,
      PersonController controller
      ) {
    return "main.jsp";
    }
  
  }
