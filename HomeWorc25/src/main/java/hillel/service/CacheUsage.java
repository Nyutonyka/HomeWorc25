package hillel.service;

public interface CacheUsage {

    boolean put(String cache, String key, String value);

    Object get (String cache, String key);

    void clear();

    void clear(String cache);

    void isCacheExist(String cache);

}
