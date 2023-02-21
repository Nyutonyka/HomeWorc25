package hillel.service.impl;

import hillel.dto.CacheMap;
import hillel.service.CacheUsage;

import java.util.HashMap;

public class CacheUsageImpl implements CacheUsage {

    @Override
    public boolean put(String cache, String key, String value) {

        HashMap<String, HashMap<String, String>> cacheMap = new HashMap<>();
        HashMap<String, String> dataCache = new HashMap<>();
        dataCache.put(key, value);
        cacheMap.put(cache, dataCache);

//        CacheMap cm = new CacheMap();
//        cm.setDataMap(key, value);
//        cm.setCacheMap(cache);
        return true;
    }

    @Override
    public Object get(String cache, String key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void clear(String cache) {

    }

    @Override
    public void isCacheExist(String cache) {

    }
}
