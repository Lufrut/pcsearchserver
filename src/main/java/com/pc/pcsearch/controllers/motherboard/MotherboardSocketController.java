package com.pc.pcsearch.controllers.motherboard;

import com.pc.pcsearch.models.buildpc.motherboard.MotherboardSocket;
import com.pc.pcsearch.services.motherboard.MotherboardSocketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class MotherboardSocketController {
    @Autowired
    MotherboardSocketService socketService;

    @PostMapping("/admin/motherboardSocket")
    public MotherboardSocket create(@Valid  @RequestBody MotherboardSocket socket) {
        return socketService.create(socket);
    }

    @GetMapping("/all/motherboardSocket/{id}")
    public Optional<MotherboardSocket> getOne(@PathVariable long id) {
        return socketService.getOne(id);
    }

    @GetMapping("/all/motherboardSocket")
    public List<MotherboardSocket> getAll() {
        return socketService.getAll();
    }

    @PutMapping("/admin/motherboardSocket/{id}")
    public MotherboardSocket update(@Valid @RequestBody MotherboardSocket socket, @PathVariable long id) {
        return socketService.update(socket, id);
    }

    @DeleteMapping("/admin/motherboardSocket/{id}")
    public String delete(@PathVariable long id) {
        socketService.delete(id);
        return "Successful deleted";
    }
}

