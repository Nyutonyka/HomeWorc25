package hillel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
/**
 * @author Anna Babich
 * @version 1.0.0
 *
 */

@Service
@Slf4j
public class CacheUsageImpl {

    HashMap<String, HashMap<String, String>> cacheMap;
    HashMap<String, String> valueCache;


    public boolean put(String cacheKey, String key, String value) {
        try {
            if (valueCache == null) {
                valueCache = new HashMap<>();
                valueCache.put(key, value);
            }
            valueCache.put(key, value);
            if (cacheMap == null) {
                cacheMap = new HashMap<>();
                cacheMap.put(cacheKey, valueCache);
            }
            cacheMap.put(cacheKey, valueCache);
            log.info(String.valueOf(valueCache.size()));
            log.info(String.valueOf(cacheMap.size()));
            return true;
        } catch (Exception e) {
            System.out.println("Object not added to cache");
            throw new RuntimeException(e);
        }
    }

    public String get(String cache, String key) {
        if(cacheMap.containsKey(cache) && valueCache.containsKey(key)){
            return cacheMap.get(cache).get(key);
        }else {
           return "null";
        }
    }

    public void clear() {
        log.info(String.valueOf(cacheMap.size()));
        cacheMap = new HashMap<>();
        log.info(String.valueOf(cacheMap.size()));
    }

    public void clearCache(String cache) {
        valueCache = cacheMap.get(cache);
        log.info(String.valueOf(valueCache.size()));
        valueCache.clear();
        log.info(String.valueOf(valueCache.size()));
    }

    public void isCacheExist(String cache) {
        String massage;
        if(cacheMap.get(cache) == null){
            massage = "--Cache is not exist--";
        } else {
            massage = "--Cache is exist--";
        }
        log.info(massage);
    }
}
