package soma.fst.neo4j_Project;
//package com.login.example.LoginExample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {ReactiveUserDetailsServiceAutoConfiguration.class})
public class Neo4jProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Neo4jProjectApplication.class, args);
	}
	

}
