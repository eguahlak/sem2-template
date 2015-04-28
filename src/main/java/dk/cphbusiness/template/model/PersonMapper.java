package dk.cphbusiness.template.model;

import java.util.Collection;

public interface PersonMapper {
  Person find(int id) throws MappingException;
  Person save(Person person) throws MappingException;
  Collection<Person> list() throws MappingException;
  }
