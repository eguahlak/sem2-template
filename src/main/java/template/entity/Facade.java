package template.entity;

import java.util.Collection;

public interface Facade {
  Person find(int id) throws MappingException;
  Person save(Person person) throws MappingException;
  Collection<Person> list() throws MappingException;
  }
