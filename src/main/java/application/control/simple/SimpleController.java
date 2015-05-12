package application.control.simple;

import application.control.Controller;
import application.control.PersonDetail;
import application.control.PersonSummary;
import application.control.NoSuchPersonException;
import application.entity.Facade;
import static application.control.simple.Assembler.*;
import application.entity.Person;
import java.util.Collection;

public class SimpleController implements Controller {
  private final Facade mapper;

  public SimpleController(Facade mapper) {
    this.mapper = mapper;
    }

  @Override
  public PersonDetail find(int id) throws NoSuchPersonException {
    Person person = mapper.find(id);
    if (person == null) throw new NoSuchPersonException(id);
    return createPersonDetail(person);
    }

  @Override
  public PersonDetail save(PersonDetail person) {
    Person entity = createPersonEntity(person);
    entity = mapper.save(entity);
    return createPersonDetail(entity);
    }

  @Override
  public Collection<PersonSummary> list() {
    return createPersonSummaries(mapper.list());
    }
  
  }
