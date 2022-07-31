package soma.fst.neo4j_Project.Repositories;

import java.util.List;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import soma.fst.neo4j_Project.Domain.Person;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

  //Person findByName(String name);
  //Person one( Long id) ;
  //Person newPerson( Person newPerson) ;
  //List<Person> all() ;
  //List<Person> findByTeammatesName(String name);
}