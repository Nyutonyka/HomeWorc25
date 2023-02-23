package hillel.controller;

import hillel.service.CacheUsageImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
/**
 * @author Anna Babich
 * @version 1.0.0
 *
 */

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class CacheController {

    private final CacheUsageImpl cacheUsage;

    @PostMapping(value = "/putCache")
    public boolean addCache(@RequestParam String cacheKey, String key, String value) {
            cacheUsage.put(cacheKey, key, value);
            return true;
    }

    @GetMapping(value = "/cache")
    public String getCache(@RequestParam String cache, String key){
        return cacheUsage.get(cache, key);
    }

    @DeleteMapping(value = "/clearCache")
    public void clearCache(@RequestParam String cache){
        cacheUsage.clearCache(cache);
    }

    @DeleteMapping(value = "/clear")
    public void clear(){
       cacheUsage.clear();
    }

    @PutMapping (value = "/isExistCache")
    public void isExist(@RequestParam String cache){
        cacheUsage.isCacheExist(cache);
    }

}