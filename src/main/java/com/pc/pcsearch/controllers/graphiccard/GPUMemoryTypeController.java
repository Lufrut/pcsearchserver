package com.pc.pcsearch.controllers.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUMemoryType;
import com.pc.pcsearch.services.graphiccard.GPUMemoryTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class GPUMemoryTypeController {
    @Autowired
    GPUMemoryTypeService gpuMemoryTypeService;

    @PostMapping("/admin/gpuMemoryType")
    public GPUMemoryType create(@Valid @RequestBody GPUMemoryType gpuMemoryType) {
        return gpuMemoryTypeService.create(gpuMemoryType);
    }

    @GetMapping("/all/gpuMemoryType/{id}")
    public Optional<GPUMemoryType> getOne(@PathVariable long id) {
        return gpuMemoryTypeService.getOne(id);
    }

    @GetMapping("/all/gpuMemoryType")
    public List<GPUMemoryType> getAll() {
        return gpuMemoryTypeService.getAll();
    }

    @PutMapping("/admin/gpuMemoryType/{id}")
    public GPUMemoryType update(@Valid  @RequestBody GPUMemoryType gpuMemoryType, @PathVariable long id) {
        return gpuMemoryTypeService.update(gpuMemoryType, id);
    }

    @DeleteMapping("/admin/gpuMemoryType/{id}")
    public String delete(@PathVariable long id) {
        gpuMemoryTypeService.delete(id);
        return "Successfully deleted";
    }
}

