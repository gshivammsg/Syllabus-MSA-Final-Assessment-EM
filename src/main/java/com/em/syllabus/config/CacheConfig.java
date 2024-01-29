package com.em.syllabus.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfig {

    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void preLoadCache(){
        Cache cache = cacheManager.getCache("tagsBySyllabus");
        cache.toString();
    }
}
