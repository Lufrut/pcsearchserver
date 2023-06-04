package com.pc.pcsearch.controllers.processor;

import com.pc.pcsearch.models.buildpc.processor.CPUTech;
import com.pc.pcsearch.services.processor.CPUTechService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class CPUTechController {
    @Autowired
    CPUTechService cpuTechService;

    @PostMapping("/admin/cpuTech")
    public CPUTech create(@Valid @RequestBody CPUTech cpuTech) {
        return cpuTechService.create(cpuTech);
    }

    @GetMapping("/all/cpuTech/{id}")
    public Optional<CPUTech> getOne(@PathVariable long id) {
        return cpuTechService.getOne(id);
    }

    @GetMapping("/all/cpuTech")
    public List<CPUTech> getAll() {
        return cpuTechService.getAll();
    }

    @PutMapping("/admin/cpuTech/{id}")
    public CPUTech update(@Valid @RequestBody CPUTech cpuTech, @PathVariable long id) {
        return cpuTechService.update(cpuTech, id);
    }

    @DeleteMapping("/admin/cpuTech/{id}")
    public String delete(@PathVariable long id) {
        cpuTechService.delete(id);
        return "Successful deleted";
    }
}

