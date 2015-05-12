package application.boundary.web;

import application.control.Controller;
import application.control.simple.SimpleController;
import application.entity.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class PageController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try {
      HttpSession session = request.getSession();
      Controller controller = (Controller)session.getAttribute("controller");
      if (controller == null) {
        ServletContext application = this.getServletContext();
        Facade mapper = (Facade)application.getAttribute("mapper");
        session.setAttribute("controller", controller = new SimpleController(mapper));
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
      Controller controller
      );

  }
