package com.pc.pcsearch.controllers;
import com.pc.pcsearch.models.buildpc.Producers;
import com.pc.pcsearch.services.ProducersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class ProducersController {
    @Autowired
    ProducersService producersService;

    @PostMapping("/admin/producers")
    public Producers create(@RequestBody @Valid Producers producers) {
        return producersService.create(producers);
    }

    @GetMapping("/all/producers/{id}")
    public Optional<Producers> getOne(@PathVariable long id) {
        return producersService.getOne(id);
    }

    @GetMapping("/all/producers")
    public List<Producers> getAll() {
        return producersService.getAll();
    }

    @PutMapping("/admin/producers/{id}")
    public Producers update(@Valid @RequestBody Producers producers, @PathVariable long id) {
        return producersService.update(producers, id);
    }

    @DeleteMapping("/admin/producers/{id}")
    public String delete(@PathVariable long id) {
        producersService.delete(id);
        return "Successful deleted";
    }
}