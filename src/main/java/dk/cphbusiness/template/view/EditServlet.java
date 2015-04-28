package dk.cphbusiness.template.view;

import dk.cphbusiness.template.contract.PersonController;
import dk.cphbusiness.template.contract.dto.PersonDetail;
import dk.cphbusiness.template.contract.eto.NoSuchPersonException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditServlet", urlPatterns = {"/Edit"})
public class EditServlet extends BaseServlet {

  @Override
  protected String service(HttpServletRequest request, PersonController controller) {
    try {
      String idText = request.getParameter("id");
      int id = idText == null ? 0 : Integer.valueOf(idText);
      if (id == 0) request.setAttribute("person", new PersonDetail());
      else request.setAttribute("person", controller.find(id));
      return "edit.jsp";
      }
    catch (NoSuchPersonException npe) {
      request.setAttribute("message", "The person with id #"+npe.getId()+" does not exist");
      return "error.jsp";
      }
    }

  }
