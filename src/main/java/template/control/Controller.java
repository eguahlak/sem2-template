package template.control;

import java.util.Collection;

public interface Controller {
  PersonDetail find(int id) throws NoSuchPersonException;
  PersonDetail save(PersonDetail person);
  Collection<PersonSummary> list();
  }
