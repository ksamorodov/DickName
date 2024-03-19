package com.ksamorodov.dickname.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ksamorodov.dickname.entity.Analytics;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AnalyticCache {
    private final List<Analytics> analyticsList;

    public void saveInCache(Analytics analytics) {
        analyticsList.add(analytics);
    }

    public void clearCache() {
        analyticsList.clear();
    }

    public List<Analytics> getAnalyticsList() {
        return analyticsList;
    }
}
