package template.boundary.web;

import template.control.Controller;
import template.control.PersonDetail;
import template.control.NoSuchPersonException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "EditServlet", urlPatterns = {"/Edit"})
public class EditPageController extends PageController {

  @Override
  protected String service(HttpServletRequest request, Controller controller) {
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
