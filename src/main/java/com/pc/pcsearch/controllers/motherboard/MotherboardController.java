package com.pc.pcsearch.controllers.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.Motherboard;
import com.pc.pcsearch.services.motherboard.MotherboardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class MotherboardController {
    @Autowired
    MotherboardService motherboardService;

    @PostMapping("/admin/motherboard")
    public Motherboard create(@Valid  @RequestBody Motherboard motherboard) {
        return motherboardService.create(motherboard);
    }

    @GetMapping("/all/motherboard/{id}")
    public Optional<Motherboard> getOne(@PathVariable long id) {
        return motherboardService.getOne(id);
    }

    @GetMapping("/all/motherboard")
    public List<Motherboard> getAll() {
        return motherboardService.getAll();
    }

    @PutMapping("/admin/motherboard/{id}")
    public Motherboard update(@Valid @RequestBody Motherboard motherboard, @PathVariable long id) {
        return motherboardService.update(motherboard, id);
    }

    @DeleteMapping("/admin/motherboard/{id}")
    public String delete(@PathVariable long id) {
        motherboardService.delete(id);
        return "Successful deleted";
    }
}

