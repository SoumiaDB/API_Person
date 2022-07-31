package soma.fst.neo4j_Project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Neo4jProjectApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testAdd() {
	      String str = "Junit is working fine";
	      assertEquals("Junit is working fine",str);
	   }

}
