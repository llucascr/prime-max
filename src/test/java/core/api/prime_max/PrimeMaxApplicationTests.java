package core.api.prime_max;

import core.api.prime_max.models.TestFlow;
import core.api.prime_max.repositories.TestFlowRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.org.hamcrest.Matcher;
import org.testcontainers.utility.DockerImageName;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PrimeMaxApplicationTests {

	@LocalServerPort
	private Integer port;

	@Autowired
	private TestFlowRepository repository;

	@Container
	static PostgreSQLContainer<?> container = new PostgreSQLContainer<>(
			DockerImageName.parse("postgres:15"));

	@DynamicPropertySource
	static void properties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.driver-class-name", () -> "org.postgresql.Driver");
		registry.add("spring.datasource.url", container::getJdbcUrl);
		registry.add("spring.datasource.username", container::getUsername);
		registry.add("spring.datasource.password", container::getPassword);

		log.info("url {}", container.getJdbcUrl());
		log.info("username {}", container.getUsername());
		log.info("password {}", container.getPassword());
		log.info("spring.datasource.driver-class-name {}", container.getJdbcDriverInstance());
	}

	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost:" + port;
		repository.deleteAll();
	}

	@BeforeAll
	static void beforeAll() {
		container.start();
	}

	@AfterAll
	static void afterAll() {
		container.stop();
	}

	@Test
	void testDomain() throws UnknownHostException {

		String owner        = InetAddress.getLocalHost().getHostName();
		InetAddress address = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
		String hash         = UUID.randomUUID().toString();
		String date         = new Date().toString();

		TestFlow model      = new TestFlow(null, owner, address, hash, date);

		TestFlow save = repository.save(model);

		assertNotNull(save);
		assertEquals(owner, save.getOwner());
		assertEquals(address, save.getAddress());
		assertEquals(hash, save.getHash());
		assertEquals(date, save.getDate());
	}

	@Test
	void listAllTest() throws UnknownHostException {

		String owner1        = InetAddress.getLocalHost().getHostName();
		InetAddress address1 = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
		String hash1         = UUID.randomUUID().toString();
		String date1         = new Date().toString();

		TestFlow flow1       = new TestFlow(null, owner1, address1, hash1, date1);

		String owner2        = InetAddress.getLocalHost().getHostName();
		InetAddress address2 = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
		String hash2         = UUID.randomUUID().toString();
		String date2         = new Date().toString();

		TestFlow flow2       = new TestFlow(null, owner2, address2, hash2, date2);

		List<TestFlow> flowList = List.of(flow1, flow2);

		repository.saveAll(flowList);

		System.out.println(flowList.stream().map(testFlow -> {
			System.out.println("owner: " + testFlow.getOwner() +" address: "+ testFlow.getAddress() +" date: "+testFlow.getDate());
            return testFlow.getAddress();
        }).toList());

		given()
				.contentType(ContentType.JSON)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.when()
				.get("/api/v2/address")
				.then()
				.assertThat()
				.statusCode(HttpStatus.OK.value());
	}
}
