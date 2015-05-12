package application.boundary.web;

import application.control.Controller;
import application.control.PersonSummary;
import java.util.Collection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "ListServlet", urlPatterns = {"/List"})
public class ListPageController extends PageController {

  @Override
  protected String service(
      HttpServletRequest request,
      Controller controller
      ) {
    Collection<PersonSummary> people = controller.list();
    request.setAttribute("people", people);

    return "list.jsp";
    }

  }
