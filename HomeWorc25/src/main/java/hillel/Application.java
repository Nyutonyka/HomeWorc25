package hillel;

import hillel.service.CacheUsage;
import hillel.service.impl.CacheUsageImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Oleksandr Stepurko
 * @version 0.0.1
 *
 * Main class for spring boot app with swagger
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        CacheUsage cu = new CacheUsageImpl();
        System.out.println(cu.put("cache_string", "citys", " Киев, Харьков, Одесса, Днепр"));
    }
}
