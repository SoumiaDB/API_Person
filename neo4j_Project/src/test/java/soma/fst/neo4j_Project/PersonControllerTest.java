package soma.fst.neo4j_Project;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.*;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.Repository;

import soma.fst.neo4j_Project.Domain.Person;
import soma.fst.neo4j_Project.Repositories.PersonRepository;
import soma.fst.neo4j_Project.Controllers.*;
@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
public class PersonControllerTest {
	
	@Autowired
	 PersonRepository repository ;
	//PersonController pc = new PersonController(persRepo) ;
	@Test
	public void testCreate()
	{ 
		Person p = new Person("fatima chhaib", "female","chhaib.f@uhp.ca.ma", "076251278", "SBATA") ;
		
		repository.save(p) ;
		assertNotNull(repository.findById(p.getId()));
	}
	
	@Test
	public void testReadAll () {
		List list = repository.findAll();
		assertThat(list).size().isGreaterThan(1);
	}
	
	@Test
	public void testRead () {
		Person person = repository.findById(1L).get();
		assertEquals("nohaila moufti", person.getName());
	}
	
	@Test
	public void testUpdate () {
		Person p = repository.findById(0L).get();
		p.setPhone("0650794619");
		repository.save(p); 
		assertNotEquals("0661626364", repository.findById( 0L).get().getPhone());
	} 
	
	@Test
	public void testDelete () {
		repository.deleteById(4L);
		assertThat(repository.existsById(4L)).isFalse();
	}
}
