package hillel.dto;

import lombok.experimental.Accessors;

import java.util.HashMap;



@Accessors(chain = true)
public class CacheMap {

    private HashMap<String, String> dataMap;
    private HashMap<String,  String> cacheMap;

    public CacheMap() {
    }

    public CacheMap(HashMap<String, String> dataMap, HashMap<String, String> cacheMap) {
        this.dataMap = dataMap;
        this.cacheMap = cacheMap;
    }

    public HashMap<String, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(HashMap<String, String> dataMap) {
        this.dataMap = dataMap;
    }

    public HashMap<String, String> getCacheMap() {
        return cacheMap;
    }

    public void setCacheMap(HashMap<String, String> cacheMap) {
        this.cacheMap = cacheMap;
    }

    @Override
    public String toString() {
        return "CacheMap{" +
                "dataMap=" + dataMap +
                ", cacheMap=" + cacheMap +
                '}';
    }

    public String setDataMap(String key, String value) {
        return getDataMap().put(key, value);
    }

    public void setCacheMap(String cache) {

        getCacheMap().put(cache, String.valueOf(dataMap));

    }
}
