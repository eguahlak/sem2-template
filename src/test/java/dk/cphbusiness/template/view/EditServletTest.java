package dk.cphbusiness.template.view;

import dk.cphbusiness.template.contract.PersonController;
import dk.cphbusiness.template.contract.dto.PersonDetail;
import javax.servlet.http.HttpServletRequest;
import static org.hamcrest.CoreMatchers.*;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import static org.junit.Assert.*;
import org.junit.Test;


public class EditServletTest {
  public final Mockery context = new JUnitRuleMockery();
  
  @Test
  public void testServiceWithExistingPerson() throws Exception {
    final HttpServletRequest request = context.mock(HttpServletRequest.class);
    final PersonController controller = context.mock(PersonController.class);
    final PersonDetail person = new PersonDetail(7, "Kurt", "Hansen", "kurt@hansen.dk", 34);
    
    EditServlet servlet = new EditServlet();
    
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
