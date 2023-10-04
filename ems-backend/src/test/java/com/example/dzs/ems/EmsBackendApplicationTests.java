package com.example.dzs.ems;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.dzs.ems.entites.Employee;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmsBackendApplicationTests {

	@Autowired
	private WebTestClient testClient;
	
	
	@Test
	void testCreatedEmployeefailure() {
		
		Employee employee = new Employee("mariaa", "joose", "maryjose@gmail");
		
		testClient.post()
		.uri("/api/employees")
		.bodyValue(employee)
		.exchange()
		.expectStatus()
		.isBadRequest();
	}
	
	
	@Test
	void testCreatedEmployeeSucess() {
		
		Employee employee = new Employee("maria", "jose", "maryjose@gmail");
		
		testClient.post()
					.uri("/api/employees")
					.bodyValue(employee)
					.exchange()
					.expectStatus()
					.isCreated()
					.expectBody()
					.jsonPath("$.firstName").isEqualTo(employee.getFirstName())
					.jsonPath("$.LastName").isEqualTo(employee.getLastName())
					.jsonPath("$.Email").isEqualTo(employee.getEmail());
	}

}
