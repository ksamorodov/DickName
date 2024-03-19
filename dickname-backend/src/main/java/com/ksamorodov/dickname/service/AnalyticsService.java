package com.ksamorodov.dickname.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ksamorodov.dickname.cache.AnalyticCache;
import com.ksamorodov.dickname.entity.Analytics;
import com.ksamorodov.dickname.repository.AnalyticsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnalyticsService {
    private final AnalyticsRepository analyticsRepository;
    private final AnalyticCache analyticCache;

    public void saveAnalytics(UUID sectionId, String host, String request) {
        Analytics analytics = new Analytics();
        analytics.setSessionId(sectionId);
        analytics.setRequest(request);
        analytics.setHost(host);
        analytics.setCreatedAt(LocalDateTime.now());

        analyticCache.saveInCache(analytics);
    }
}
