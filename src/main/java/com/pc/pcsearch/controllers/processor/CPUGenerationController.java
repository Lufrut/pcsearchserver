package com.pc.pcsearch.controllers.processor;

import com.pc.pcsearch.models.buildpc.processor.CPUGeneration;
import com.pc.pcsearch.services.processor.CPUGenerationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class CPUGenerationController {
    @Autowired
    CPUGenerationService cpuGenerationService;

    @PostMapping("/admin/cpuGeneration")
    public CPUGeneration create(@Valid  @RequestBody CPUGeneration cpuGeneration) {
        return cpuGenerationService.create(cpuGeneration);
    }

    @GetMapping("/all/cpuGeneration/{id}")
    public Optional<CPUGeneration> getOne(@PathVariable long id) {
        return cpuGenerationService.getOne(id);
    }

    @GetMapping("/all/cpuGeneration")
    public List<CPUGeneration> getAll() {
        return cpuGenerationService.getAll();
    }

    @PutMapping("/admin/cpuGeneration/{id}")
    public CPUGeneration update(@Valid @RequestBody CPUGeneration cpuGeneration, @PathVariable long id) {
        return cpuGenerationService.update(cpuGeneration, id);
    }

    @DeleteMapping("/admin/cpuGeneration/{id}")
    public String delete(@PathVariable long id) {
        cpuGenerationService.delete(id);
        return "Successful deleted";
    }
}

