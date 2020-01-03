package mx.gnc.as.gutsncode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class GutsncodeApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GutsncodeApplication.class, args);
	}
}