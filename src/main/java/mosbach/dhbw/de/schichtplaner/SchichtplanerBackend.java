package mosbach.dhbw.de.schichtplaner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SchichtplanerBackend {

    public static void main(String[] args) {
        SpringApplication.run(SchichtplanerBackend.class, args);
    }

}
