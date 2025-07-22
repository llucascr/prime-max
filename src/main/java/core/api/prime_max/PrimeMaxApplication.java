package core.api.prime_max;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

@Slf4j
@SpringBootApplication
public class PrimeMaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeMaxApplication.class, args);
		log.info("Application UP {}", HttpStatus.OK);
	}
}
