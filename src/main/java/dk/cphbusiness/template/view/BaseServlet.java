package dk.cphbusiness.template.view;

import dk.cphbusiness.template.contract.PersonController;
import dk.cphbusiness.template.control.ConcretePersonController;
import dk.cphbusiness.template.model.PersonMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class BaseServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try {
      HttpSession session = request.getSession();
      PersonController controller = (PersonController)session.getAttribute("controller");
      if (controller == null) {
        ServletContext application = this.getServletContext();
        PersonMapper mapper = (PersonMapper)application.getAttribute("mapper");
        session.setAttribute("controller", controller = new ConcretePersonController(mapper));
        }
      
      String target = service(request, controller);
      
      request.getRequestDispatcher(target).forward(request, response);
      }
    catch (ServletException | IOException | RuntimeException e) {
      response.setContentType("text/html; charset=utf8");
      PrintWriter out = response.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<head><title>"+e.getMessage()+"</title></head>");
      out.print("<body><h2>"+e+"</h2><hr/><pre>");
      e.printStackTrace(out);
      out.println("</pre></body>");
      out.println("</html>");
      }
    }
  
  protected abstract String service(
      HttpServletRequest request,
      PersonController controller
      );

  }
