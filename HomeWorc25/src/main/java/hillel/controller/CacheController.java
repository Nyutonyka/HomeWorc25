package hillel.controller;

import hillel.service.impl.CacheUsageImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CacheController {

    private CacheUsageImpl cacheUsage;

    @PostMapping(name = "putCache")
    public boolean addCache(@RequestBody String cache, String key, String value){
        return cacheUsage.put(cache, key, value);
    }
}
