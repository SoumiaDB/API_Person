package soma.fst.neo4j_Project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soma.fst.neo4j_Project.Domain.Person;
import soma.fst.neo4j_Project.Exception.PersonNotFoundException;
import soma.fst.neo4j_Project.Repositories.PersonRepository;

@RestController
class PersonController  {

  @Autowired	
  private final PersonRepository repository;

  PersonController(PersonRepository repository) {
    this.repository = repository;
  }

  //@RequestMapping("/Persons")
  
  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/Persons")
  List<Person> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/Persons")
  Person newPerson(@RequestBody Person newPerson) {
    return repository.save(newPerson);
  }

  // Single item
  
  @GetMapping("/Persons/{id}")
  Person one(@PathVariable Long id) {
    
    return repository.findById(id)
    		.orElseThrow(() -> new PersonNotFoundException(id));
  }

  @PutMapping("/Persons/{id}")
  Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(Person -> {
        Person.setName(newPerson.getName());
        Person.setGender(newPerson.getGender());
        Person.setEmail(newPerson.getEmail());
        Person.setPhone(newPerson.getPhone());
        Person.setAdress(newPerson.getAdress());
        return repository.save(Person);
      })
      .orElseGet(() -> {
        newPerson.setId(id);
        return repository.save(newPerson);
      });
  }

  @DeleteMapping("/Persons/{id}")
  void deletePerson(@PathVariable Long id) {
    repository.deleteById(id);
  }
}