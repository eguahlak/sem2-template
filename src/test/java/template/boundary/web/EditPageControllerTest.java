package template.boundary.web;

import template.control.Controller;
import template.control.PersonDetail;
import javax.servlet.http.HttpServletRequest;
import static org.hamcrest.CoreMatchers.*;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import static org.junit.Assert.*;
import org.junit.Test;


public class EditPageControllerTest {
  public final Mockery context = new JUnitRuleMockery();
  
  @Test
  public void testServiceWithExistingPerson() throws Exception {
    final HttpServletRequest request = context.mock(HttpServletRequest.class);
    final Controller controller = context.mock(Controller.class);
    final PersonDetail person = new PersonDetail(7, "Kurt", "Hansen", "kurt@hansen.dk", 34);
    
    EditPageController servlet = new EditPageController();
    
    context.checking(new Expectations(){{
      oneOf(request).getParameter("id");
      will(returnValue("7"));
      oneOf(controller).find(7);
      will(returnValue(person));
      oneOf(request).setAttribute("person", person);
      }});
    
    String result = servlet.service(request, controller);
    
    assertThat(result, is("edit.jsp"));
    }
  
  }
