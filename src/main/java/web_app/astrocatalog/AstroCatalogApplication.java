package web_app.astrocatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class AstroCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(AstroCatalogApplication.class, args);
    }

}
