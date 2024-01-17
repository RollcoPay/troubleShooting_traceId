package monster.realrestfulman.trpr;

import monster.realrestfulman.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= "monster.realrestfulman")
public class TrprApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrprApplication.class, args);
	}

}
