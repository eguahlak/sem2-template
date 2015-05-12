package application.boundary.web;

import application.control.Controller;
import application.control.PersonDetail;
import application.control.PersonSummary;
import java.util.Collection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "SaveServlet", urlPatterns = {"/Save"})
public class SavePageController extends PageController {

  @Override
  protected String service(
      HttpServletRequest request,
      Controller controller
      ) {
    String idText = request.getParameter("id");
    int id = idText == null ? 0 : Integer.parseInt(idText);
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String ageText = request.getParameter("age");
    int age = 0;
    try { age = Integer.parseInt(ageText); } catch (NumberFormatException nfe) { age = 0; }
    String email = request.getParameter("email");

    controller.save(new PersonDetail(id, firstName, lastName, email, age));

    Collection<PersonSummary> people = controller.list();
    request.setAttribute("people", people);

    return "list.jsp";
    }

  }
