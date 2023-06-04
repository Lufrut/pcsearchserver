package com.pc.pcsearch.services;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.postgresql.repository.PerformanceLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PerformanceLevelServiceImpl implements PerformanceLevelService {
    @Autowired
    PerformanceLevelRepository performanceLevelRepository;

    @Override
    public PerformanceLevel create(PerformanceLevel performanceLevel) {
        return performanceLevelRepository.save(performanceLevel);
    }

    @Override
    public Optional<PerformanceLevel> getOne(long id) {
        return performanceLevelRepository.findById(id);
    }

    @Override
    public List<PerformanceLevel> getAll() {
        return performanceLevelRepository.findAll();
    }

    @Override
    public PerformanceLevel update(PerformanceLevel performanceLevel, long id) {
        PerformanceLevel temp = performanceLevelRepository.findById(id).orElse(null);
        if (temp != null) {
            temp = performanceLevel;
            return performanceLevelRepository.save(temp);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        performanceLevelRepository.deleteById(id);
    }
}
