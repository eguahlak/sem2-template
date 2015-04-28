package dk.cphbusiness.template.view;

import dk.cphbusiness.template.contract.PersonController;
import dk.cphbusiness.template.contract.dto.PersonDetail;
import dk.cphbusiness.template.contract.dto.PersonSummary;
import java.util.Collection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SaveServlet", urlPatterns = {"/Save"})
public class SaveServlet extends BaseServlet {

  @Override
  protected String service(
      HttpServletRequest request,
      PersonController controller
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
