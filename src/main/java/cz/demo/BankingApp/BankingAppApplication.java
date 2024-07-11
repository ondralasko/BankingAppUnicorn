package cz.demo.BankingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
@EnableJpaRepositories
public class BankingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}


}
