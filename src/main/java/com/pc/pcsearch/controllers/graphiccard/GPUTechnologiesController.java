package com.pc.pcsearch.controllers.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUTechnologies;
import com.pc.pcsearch.services.graphiccard.GPUTechnologiesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class GPUTechnologiesController {
    @Autowired
    GPUTechnologiesService gpuTechnologiesService;

    @PostMapping("/admin/gpuTechnologies")
    public GPUTechnologies create(@Valid  @RequestBody GPUTechnologies gpuTechnologies) {
        return gpuTechnologiesService.create(gpuTechnologies);
    }

    @GetMapping("/all/gpuTechnologies/{id}")
    public Optional<GPUTechnologies> getOne(@PathVariable long id) {
        return gpuTechnologiesService.getOne(id);
    }

    @GetMapping("/all/gpuTechnologies")
    public List<GPUTechnologies> getAll() {
        return gpuTechnologiesService.getAll();
    }

    @PutMapping("/admin/gpuTechnologies/{id}")
    public GPUTechnologies update(@Valid @RequestBody GPUTechnologies gpuTechnologies, @PathVariable long id) {
        return gpuTechnologiesService.update(gpuTechnologies, id);
    }

    @DeleteMapping("/admin/gpuTechnologies/{id}")
    public String delete(@PathVariable long id) {
        gpuTechnologiesService.delete(id);
        return "Successfully deleted";
    }
}

