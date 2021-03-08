package se.iths.springdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;




@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringCarApplicationTests {

	@LocalServerPort
	int port;

	@Autowired
	TestRestTemplate testClient;

	@Test
	void contextLoads() {
	//	HttpHeaders headers = new HttpHeaders();
	//	headers.add("Accept", "application/xml");
		//testClient.exchange("localhost:8080/person", HttpMethod.GET, new HttpEntity<>(headers), CarsDto[].class);

		//var result = testClient.getForEntity("http://localhost:"+port+"/cars", CarsDto[].class);
		//assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		//assertThat(result.getBody().length).isGreaterThan(0);
	}






}
