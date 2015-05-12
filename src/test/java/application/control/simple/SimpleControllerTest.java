package application.control.simple;


import application.control.simple.SimpleController;
import application.control.Controller;
import application.control.PersonDetail;
import application.control.NoSuchPersonException;
import application.entity.Person;
import application.entity.Facade;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.jmock.Mockery;
import org.jmock.Expectations;
import static org.jmock.Expectations.returnValue;
import org.jmock.integration.junit4.JUnitRuleMockery;
import static org.junit.Assert.*;
  
public class SimpleControllerTest {
  public final Mockery context = new JUnitRuleMockery();
  
  @Test
  public void testFindExisting() throws Exception {
    final Facade facade = context.mock(Facade.class);
    Controller controller = new SimpleController(facade);
    final int id = 7;
    
    context.checking(new Expectations() {{
      
        oneOf(facade).find(id);
        will(returnValue(new Person(id, "Kurt", "Hansen", 34, "kurt@mail.dk", "secret")));
      
        }});
    
    PersonDetail result = controller.find(id);
    
    assertThat(result.getId(), is(id));
    assertThat(result.getFirstName(), is("Kurt"));
    assertThat(result.getLastName(), is("Hansen"));
    assertThat(result.getAge(), is(34));
    assertThat(result.getEmail(), is("kurt@mail.dk"));
    }

  @Test(expected = NoSuchPersonException.class)
  public void testFindNonExisting() throws Exception {
    final Facade facade = context.mock(Facade.class);
    Controller controller = new SimpleController(facade);
    final int id = 17;
    
    context.checking(new Expectations() {{
        oneOf(facade).find(id);
        will(returnValue(null));
        }});
    
    PersonDetail result = controller.find(id);
    }

  }
