package dk.cphbusiness.template.control;

import dk.cphbusiness.template.contract.dto.PersonDetail;
import dk.cphbusiness.template.contract.dto.PersonSummary;
import dk.cphbusiness.template.model.Person;
import java.util.ArrayList;
import java.util.Collection;

public class PersonAssembler {
  
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
