package com.pc.pcsearch.controllers;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.services.PerformanceLevelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/")
public class PerformanceLevelController {
    @Autowired
    PerformanceLevelService performanceLevelService;

    @PostMapping("/admin/performance-level")
    public PerformanceLevel create(PerformanceLevel performanceLevel) {
        return performanceLevelService.create(performanceLevel);
    }

    @GetMapping("/all/performance-level/{id}")
    public Optional<PerformanceLevel> getOne(@PathVariable long id) {
        return performanceLevelService.getOne(id);
    }

    @GetMapping("/all/performance-level")
    public List<PerformanceLevel> getAll() {
        return performanceLevelService.getAll();
    }

    @PutMapping("/admin/performance-level/{id}")
    public PerformanceLevel update(@Valid @RequestBody PerformanceLevel performanceLevel, @PathVariable long id) {
        return performanceLevelService.update(performanceLevel, id);
    }

    @DeleteMapping("/admin/performance-level/{id}")
    public String delete(@PathVariable long id) {
        performanceLevelService.delete(id);
        return "Successful deleted";
    }
}