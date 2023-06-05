package com.pc.pcsearch.controllers;


import com.pc.pcsearch.models.buildpc.BuildPC;
import com.pc.pcsearch.services.BuildPCService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class BuildPCController {
    @Autowired
    BuildPCService buildPCService;

    @PostMapping("/admin/buildPc")
    public BuildPC create(@RequestBody @Valid BuildPC buildPC) {
        return buildPCService.create(buildPC);
    }

    @GetMapping("/all/buildPc/{id}")
    public Optional<BuildPC> getOne(@PathVariable long id) {
        return buildPCService.getOne(id);
    }

    @GetMapping("/all/buildPc")
    public List<BuildPC> getAll() {
        return buildPCService.getAll();
    }

    @PutMapping("/admin/buildPc/{id}")
    public BuildPC update(@RequestBody @Valid BuildPC buildPC, @PathVariable long id) {
        return buildPCService.update(buildPC, id);
    }

    @DeleteMapping("/admin/buildPc/{id}")
    public String delete(@PathVariable long id) {
        buildPCService.delete(id);
        return "Successfully deleted";
    }
}
