package com.pc.pcsearch.controllers.processor;

import com.pc.pcsearch.models.buildpc.processor.Processor;
import com.pc.pcsearch.services.processor.ProcessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class ProcessorController {
    @Autowired
    ProcessorService processorService;

    @PostMapping("/admin/processor")
    public Processor create(@Valid @RequestBody Processor processor) {
        return processorService.create(processor);
    }

    @GetMapping("/all/processor/{id}")
    public Optional<Processor> getOne(@PathVariable long id) {
        return processorService.getOne(id);
    }

    @GetMapping("/all/processor")
    public List<Processor> getAll() {
        return processorService.getAll();
    }

    @PutMapping("/admin/processor/{id}")
    public Processor update(@Valid @RequestBody Processor processor, @PathVariable long id) {
        return processorService.update(processor, id);
    }

    @DeleteMapping("/admin/processor/{id}")
    public String delete(@PathVariable long id) {
        processorService.delete(id);
        return "Successful deleted";
    }
}
