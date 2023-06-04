package com.pc.pcsearch.controllers.graphiccard;

import com.pc.pcsearch.models.buildpc.graphiccard.GPUConnector;
import com.pc.pcsearch.services.graphiccard.GPUConnectorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class GPUConnectorController {
    @Autowired
    GPUConnectorService gpuConnectorService;

    @PostMapping("/admin/gpuConnector")
    public GPUConnector create(@Valid  @RequestBody GPUConnector gpuConnector) {
        return gpuConnectorService.create(gpuConnector);
    }

    @GetMapping("/all/gpuConnector/{id}")
    public Optional<GPUConnector> getOne(@PathVariable long id) {
        return gpuConnectorService.getOne(id);
    }

    @GetMapping("/all/gpuConnector")
    public List<GPUConnector> getAll() {
        return gpuConnectorService.getAll();
    }

    @PutMapping("/admin/gpuConnector/{id}")
    public GPUConnector update(@Valid @RequestBody GPUConnector gpuConnector, @PathVariable long id) {
        return gpuConnectorService.update(gpuConnector, id);
    }

    @DeleteMapping("/admin/gpuConnector/{id}")
    public String delete(@PathVariable long id) {
        gpuConnectorService.delete(id);
        return "Successfully deleted";
    }
}

