package com.pc.pcsearch.controllers.processor;

import com.pc.pcsearch.models.buildpc.processor.CPUPcieVersion;
import com.pc.pcsearch.services.processor.CPUPcieVersionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class CPUPcieVersionController {
    @Autowired
    CPUPcieVersionService cpuPcieVersionService;

    @PostMapping("/admin/cpuPcieVersion")
    public CPUPcieVersion create(@Valid  @RequestBody CPUPcieVersion cpuPcieVersion) {
        return cpuPcieVersionService.create(cpuPcieVersion);
    }

    @GetMapping("/all/cpuPcieVersion/{id}")
    public Optional<CPUPcieVersion> getOne(@PathVariable long id) {
        return cpuPcieVersionService.getOne(id);
    }

    @GetMapping("/all/cpuPcieVersion")
    public List<CPUPcieVersion> getAll() {
        return cpuPcieVersionService.getAll();
    }

    @PutMapping("/admin/cpuPcieVersion/{id}")
    public CPUPcieVersion update(@Valid @RequestBody CPUPcieVersion cpuPcieVersion, @PathVariable long id) {
        return cpuPcieVersionService.update(cpuPcieVersion, id);
    }

    @DeleteMapping("/admin/cpuPcieVersion/{id}")
    public String delete(@PathVariable long id) {
        cpuPcieVersionService.delete(id);
        return "Successful deleted";
    }
}
