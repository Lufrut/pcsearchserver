package com.pc.pcsearch.controllers.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUInterfaceType;
import com.pc.pcsearch.services.graphiccard.GPUInterfaceTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class GPUInterfaceTypeController {
    @Autowired
    GPUInterfaceTypeService gpuInterfaceTypeService;

    @PostMapping("/admin/gpuInterfaceType")
    public GPUInterfaceType create(@Valid @RequestBody GPUInterfaceType gpuInterfaceType) {
        return gpuInterfaceTypeService.create(gpuInterfaceType);
    }

    @GetMapping("/all/gpuInterfaceType/{id}")
    public Optional<GPUInterfaceType> getOne(@PathVariable long id) {
        return gpuInterfaceTypeService.getOne(id);
    }

    @GetMapping("/all/gpuInterfaceType")
    public List<GPUInterfaceType> getAll() {
        return gpuInterfaceTypeService.getAll();
    }

    @PutMapping("/admin/gpuInterfaceType/{id}")
    public GPUInterfaceType update(@Valid @RequestBody GPUInterfaceType gpuInterfaceType, @PathVariable long id) {
        return gpuInterfaceTypeService.update(gpuInterfaceType, id);
    }

    @DeleteMapping("/admin/gpuInterfaceType/{id}")
    public String delete(@PathVariable long id) {
        gpuInterfaceTypeService.delete(id);
        return "Successfully deleted";
    }
}

