package com.pc.pcsearch.controllers;
import com.pc.pcsearch.models.buildpc.PerformanceLevel;
import com.pc.pcsearch.services.PerformanceLevelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class PerformanceLevelController {
    @Autowired
    PerformanceLevelService performanceLevelService;

    @PostMapping("/admin/performanceLevel")
    public PerformanceLevel create(@Valid @RequestBody PerformanceLevel performanceLevel) {
        return performanceLevelService.create(performanceLevel);
    }

    @GetMapping("/all/performanceLevel/{id}")
    public Optional<PerformanceLevel> getOne(@PathVariable long id) {
        return performanceLevelService.getOne(id);
    }

    @GetMapping("/all/performanceLevel")
    public List<PerformanceLevel> getAll() {
        return performanceLevelService.getAll();
    }

    @PutMapping("/admin/performanceLevel/{id}")
    public PerformanceLevel update(@Valid @RequestBody PerformanceLevel performanceLevel, @PathVariable long id) {
        return performanceLevelService.update(performanceLevel, id);
    }

    @DeleteMapping("/admin/performanceLevel/{id}")
    public String delete(@PathVariable long id) {
        performanceLevelService.delete(id);
        return "Successful deleted";
    }
}