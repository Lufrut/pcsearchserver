package com.pc.pcsearch.controllers.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.MotherboardNetwork;
import com.pc.pcsearch.services.motherboard.MotherboardNetworkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class MotherboardNetworkController {
    @Autowired
    MotherboardNetworkService networkService;

    @PostMapping("/admin/motherboardNetwork")
    public MotherboardNetwork create(@Valid  @RequestBody MotherboardNetwork network) {
        return networkService.create(network);
    }

    @GetMapping("/all/motherboardNetwork/{id}")
    public Optional<MotherboardNetwork> getOne(@PathVariable long id) {
        return networkService.getOne(id);
    }

    @GetMapping("/all/motherboardNetwork")
    public List<MotherboardNetwork> getAll() {
        return networkService.getAll();
    }

    @PutMapping("/admin/motherboardNetwork/{id}")
    public MotherboardNetwork update(@Valid @RequestBody MotherboardNetwork network, @PathVariable long id) {
        return networkService.update(network, id);
    }

    @DeleteMapping("/admin/motherboardNetwork/{id}")
    public String delete(@PathVariable long id) {
        networkService.delete(id);
        return "Successful deleted";
    }
}
