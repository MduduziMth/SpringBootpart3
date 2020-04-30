package springbootapp;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springbootapp.services.UserServiceImpl;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {

    static UserServiceImpl service;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);


    }
}
