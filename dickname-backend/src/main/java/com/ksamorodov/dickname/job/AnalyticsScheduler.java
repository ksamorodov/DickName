package com.ksamorodov.dickname.job;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ksamorodov.dickname.cache.AnalyticCache;
import com.ksamorodov.dickname.entity.Analytics;
import com.ksamorodov.dickname.repository.AnalyticsRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AnalyticsScheduler {

    private final AnalyticCache analyticCache;
    private final AnalyticsRepository analyticsRepository;

    @Scheduled(fixedDelay = 12000) // 1200000 миллисекунд = 20 минут
    public void saveAnalyticsFromCacheToDatabase() {
        List<Analytics> analyticsList = analyticCache.getAnalyticsList();
        if (!analyticsList.isEmpty()) {
            analyticsRepository.saveAll(analyticsList);
            analyticCache.clearCache();
        }
    }
}