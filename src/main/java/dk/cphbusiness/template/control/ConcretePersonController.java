package dk.cphbusiness.template.control;

import dk.cphbusiness.template.contract.PersonController;
import dk.cphbusiness.template.contract.dto.PersonDetail;
import dk.cphbusiness.template.contract.dto.PersonSummary;
import dk.cphbusiness.template.contract.eto.NoSuchPersonException;
import dk.cphbusiness.template.model.PersonMapper;
import static dk.cphbusiness.template.control.PersonAssembler.*;
import dk.cphbusiness.template.model.Person;
import java.util.Collection;

public class ConcretePersonController implements PersonController {
  private final PersonMapper mapper;

  public ConcretePersonController(PersonMapper mapper) {
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
