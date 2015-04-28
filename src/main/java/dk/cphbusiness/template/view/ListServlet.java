package dk.cphbusiness.template.view;

import dk.cphbusiness.template.contract.PersonController;
import dk.cphbusiness.template.contract.dto.PersonSummary;
import java.util.Collection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListServlet", urlPatterns = {"/List"})
public class ListServlet extends BaseServlet {

  @Override
  protected String service(
      HttpServletRequest request,
      PersonController controller
      ) {
    Collection<PersonSummary> people = controller.list();
    request.setAttribute("people", people);

    return "list.jsp";
    }

  }
