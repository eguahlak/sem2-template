package dk.cphbusiness.template.contract;

import dk.cphbusiness.template.contract.eto.NoSuchPersonException;
import dk.cphbusiness.template.contract.dto.PersonDetail;
import dk.cphbusiness.template.contract.dto.PersonSummary;
import java.util.Collection;

public interface PersonController {
  PersonDetail find(int id) throws NoSuchPersonException;
  PersonDetail save(PersonDetail person);
  Collection<PersonSummary> list();
  }
