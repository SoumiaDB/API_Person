package soma.fst.neo4j_Project.Exception;


public class PersonNotFoundException extends RuntimeException {

  public PersonNotFoundException(Long id) {
    super("Could not find Person with Id " + id);
  }
}