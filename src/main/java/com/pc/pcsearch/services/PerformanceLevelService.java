package com.pc.pcsearch.services;

import com.pc.pcsearch.models.buildpc.PerformanceLevel;

import java.util.List;
import java.util.Optional;

public interface PerformanceLevelService {
    PerformanceLevel create(PerformanceLevel performanceLevel);

    Optional<PerformanceLevel> getOne(long id);

    List<PerformanceLevel> getAll();

    PerformanceLevel update(PerformanceLevel performanceLevel, long id);

    void delete(long id);
}
