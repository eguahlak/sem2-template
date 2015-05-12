package application.control.simple;

import application.control.PersonDetail;
import application.control.PersonSummary;
import application.entity.Person;
import java.util.ArrayList;
import java.util.Collection;

public class Assembler {
  
  public static PersonSummary createPersonSummary(Person person) {
    return new PersonSummary(
        person.getId(),
        person.getFirstName()+" "+person.getLastName(),
        person.getEmail(),
        person.getAge()
        );
    }
  
  public static Collection<PersonSummary> createPersonSummaries(Collection<Person> people) {
    Collection<PersonSummary> summaries = new ArrayList<>();
    for (Person person : people) summaries.add(createPersonSummary(person));
    return summaries;
    }
  
  public static PersonDetail createPersonDetail(Person person) {
    return new PersonDetail(
        person.getId(),
        person.getFirstName(),
        person.getLastName(),
        person.getEmail(),
        person.getAge()
        );
    }
  
  public static Person createPersonEntity(PersonDetail detail) {
    return new Person(
        detail.getId(),
        detail.getFirstName(),
        detail.getLastName(),
        detail.getAge(), 
        detail.getEmail(),
        null
        );
    }
  
  }
