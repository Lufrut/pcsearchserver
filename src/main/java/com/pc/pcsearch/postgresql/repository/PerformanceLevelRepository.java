package com.pc.pcsearch.postgresql.repository;

import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceLevelRepository extends JpaRepository<PerformanceLevel, Long> {
}
