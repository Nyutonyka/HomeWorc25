package hillel;

import hillel.service.CacheUsageImpl;
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

//        CacheUsageImpl cacheUsage = new CacheUsageImpl();
//
//        System.out.println(cacheUsage.put("cache", "t", "ttttttttttttttttt"));
//        System.out.println(cacheUsage.put("cache", "h", "dddddddddddd"));
//        System.out.println(cacheUsage.put("ca", "h", "dddddddddddd"));
//        System.out.println(cacheUsage.put("ca", "h", "dddddddddddd"));

//        System.out.println(cacheUsage.get("cache", "t"));
//        System.out.println(cacheUsage.get("cache", "k"));
//        System.out.println(cacheUsage.get("ca", "h"));
//        System.out.println(cacheUsage.get("ca", "k"));
//
//        cacheUsage.clear();
//
//        System.out.println(cacheUsage.put("cache", "t", "ttttttttttttttttt"));
//        System.out.println(cacheUsage.put("cache", "h", "dddddddddddd"));
//        System.out.println(cacheUsage.put("ca", "h", "dddddddddddd"));
//        System.out.println(cacheUsage.put("ca", "h", "dddddddddddd"));
//
//        cacheUsage.isCacheExist("ca");
//
//        cacheUsage.clear("ca");
//
//        cacheUsage.isCacheExist("ca");
//
//        System.out.println(cacheUsage.get("ca", "k"));
//        System.out.println(cacheUsage.get("ca", "h"));
//
//        cacheUsage.isCacheExist("bbb");
    }
}
