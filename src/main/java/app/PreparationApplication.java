package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.builder.lib.ANSRBuilder;
import repository.builder.lib.enums.interfaces.Strategy;

@SpringBootApplication
public class PreparationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreparationApplication.class, args);
//		ANSRBuilder.run(Strategy.REPOSITORIES_AND_SERVICES(),PreparationApplication.class, args);
	}
}
