package hillel.service.impl;

import hillel.entity.Student;
import hillel.service.CacheUsage;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;

import java.util.concurrent.TimeUnit;

public class CacheUsageImpl implements CacheUsage {
    private CacheManager cacheManager;
    private Cache<Integer, Student> objectCache;

    public CacheUsageImpl() {
        cacheManager = CacheManagerBuilder
                .newCacheManagerBuilder().build();
        cacheManager.init();

        objectCache = cacheManager
                .createCache("student-cache", CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(
                                Integer.class, Student.class,
                                ResourcePoolsBuilder.heap(10))
                        .withExpiry(Expirations.timeToLiveExpiration(Duration.of(10, TimeUnit.SECONDS))));
    }


    @Override
    public boolean put(String cache, String key, Object o) {
        return false;
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
