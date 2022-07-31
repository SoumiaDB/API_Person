package soma.fst.neo4j_Project.Domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node
public class Person {

  @Id @GeneratedValue 
  private Long id;

  private String name;
  private String gender;
  private String email;
  private String phone;
  private String adress;

  private Person() {
    // Empty constructor required as of Neo4j API 
  };

  public Person(String name, String gender, String email, String phone, String adress) 
  {
	  this.id = id ;
	  this.name = name;
	  this.gender = gender ;
	  this.email = email ;
	  this.phone = phone ;
	  this.adress = adress ;
  }

  //@Relationship(type = "TEAMMATE")
  //public Set<Person> teammates;

  /*public void worksWith(Person person) {
    if (teammates == null) {
      teammates = new HashSet<>();
    }
    teammates.add(person);
  }*/

  

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", phone=" + phone
				+ ", adress=" + adress + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}

}