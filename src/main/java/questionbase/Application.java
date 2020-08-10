package questionbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"questionbase"})
@PropertySource("classpath:database.properties")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
