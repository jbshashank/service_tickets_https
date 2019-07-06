package com.ayushya.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EvictScheduler {
    
	@Autowired
    private LocalCacheEvict localCacheEvict;
    private static final Logger LOGGER = LoggerFactory.getLogger(EvictScheduler.class);
    
    @Scheduled(fixedDelay=100000)
    public void clearCaches() {
        System.out.println("Invalidating caches");
        localCacheEvict.evictAllUsersCache();
    }
}